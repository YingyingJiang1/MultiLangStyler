    private int __read(boolean mayBlock) throws IOException
    {
        int ch;

        while (true)
        {

            // If there is no more data AND we were told not to block,
            // just return WOULD_BLOCK (-2). (More efficient than exception.)
            if(!mayBlock && super.available() == 0) {
                return WOULD_BLOCK;
            }

            // Otherwise, exit only when we reach end of stream.
            if ((ch = super.read()) < 0) {
                return EOF;
            }

            ch = (ch & 0xff);

            /* Code Section added for supporting AYT (start)*/
            synchronized (__client)
            {
                __client._processAYTResponse();
            }
            /* Code Section added for supporting AYT (end)*/

            /* Code Section added for supporting spystreams (start)*/
            __client._spyRead(ch);
            /* Code Section added for supporting spystreams (end)*/

            switch (__receiveState)
            {

            case _STATE_CR:
                if (ch == '\0')
                {
                    // Strip null
                    continue;
                }
                // How do we handle newline after cr?
                //  else if (ch == '\n' && _requestedDont(TelnetOption.ECHO) &&

                // Handle as normal data by falling through to _STATE_DATA case

                //$FALL-THROUGH$
            case _STATE_DATA:
                if (ch == TelnetCommand.IAC)
                {
                    __receiveState = _STATE_IAC;
                    continue;
                }


                if (ch == '\r')
                {
                    synchronized (__client)
                    {
                        if (__client._requestedDont(TelnetOption.BINARY)) {
                            __receiveState = _STATE_CR;
                        } else {
                            __receiveState = _STATE_DATA;
                        }
                    }
                } else {
                    __receiveState = _STATE_DATA;
                }
                break;

            case _STATE_IAC:
                switch (ch)
                {
                case TelnetCommand.WILL:
                    __receiveState = _STATE_WILL;
                    continue;
                case TelnetCommand.WONT:
                    __receiveState = _STATE_WONT;
                    continue;
                case TelnetCommand.DO:
                    __receiveState = _STATE_DO;
                    continue;
                case TelnetCommand.DONT:
                    __receiveState = _STATE_DONT;
                    continue;
                /* TERMINAL-TYPE option (start)*/
                case TelnetCommand.SB:
                    __suboption_count = 0;
                    __receiveState = _STATE_SB;
                    continue;
                /* TERMINAL-TYPE option (end)*/
                case TelnetCommand.IAC:
                    __receiveState = _STATE_DATA;
                    break; // exit to enclosing switch to return IAC from read
                case TelnetCommand.SE: // unexpected byte! ignore it (don't send it as a command)
                    __receiveState = _STATE_DATA;
                    continue;
                default:
                    __receiveState = _STATE_DATA;
                    __client._processCommand(ch); // Notify the user
                    continue; // move on the next char
                }
                break; // exit and return from read
            case _STATE_WILL:
                synchronized (__client)
                {
                    __client._processWill(ch);
                    __client._flushOutputStream();
                }
                __receiveState = _STATE_DATA;
                continue;
            case _STATE_WONT:
                synchronized (__client)
                {
                    __client._processWont(ch);
                    __client._flushOutputStream();
                }
                __receiveState = _STATE_DATA;
                continue;
            case _STATE_DO:
                synchronized (__client)
                {
                    __client._processDo(ch);
                    __client._flushOutputStream();
                }
                __receiveState = _STATE_DATA;
                continue;
            case _STATE_DONT:
                synchronized (__client)
                {
                    __client._processDont(ch);
                    __client._flushOutputStream();
                }
                __receiveState = _STATE_DATA;
                continue;
            /* TERMINAL-TYPE option (start)*/
            case _STATE_SB:
                switch (ch)
                {
                case TelnetCommand.IAC:
                    __receiveState = _STATE_IAC_SB;
                    continue;
                default:
                    // store suboption char
                    if (__suboption_count < __suboption.length) {
                        __suboption[__suboption_count++] = ch;
                    }
                    break;
                }
                __receiveState = _STATE_SB;
                continue;
            case _STATE_IAC_SB: // IAC received during SB phase
                switch (ch)
                {
                case TelnetCommand.SE:
                    synchronized (__client)
                    {
                        __client._processSuboption(__suboption, __suboption_count);
                        __client._flushOutputStream();
                    }
                    __receiveState = _STATE_DATA;
                    continue;
                case TelnetCommand.IAC: // De-dup the duplicated IAC
                    if (__suboption_count < __suboption.length) {
                        __suboption[__suboption_count++] = ch;
                    }
                    break;
                default:            // unexpected byte! ignore it
                    break;
                }
                __receiveState = _STATE_SB;
                continue;
            /* TERMINAL-TYPE option (end)*/
            }

            break;
        }

        return ch;
    }
