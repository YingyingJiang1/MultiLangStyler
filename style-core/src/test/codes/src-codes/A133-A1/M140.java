    void _processDo(int option) throws IOException
    {
        if (debugoptions)
        {
            System.err.println("RECEIVED DO: "
                + TelnetOption.getOption(option));
        }

        if (__notifhand != null)
        {
            __notifhand.receivedNegotiation(
                TelnetNotificationHandler.RECEIVED_DO,
                option);
        }

        boolean acceptNewState = false;


        /* open TelnetOptionHandler functionality (start)*/
        if (optionHandlers[option] != null)
        {
            acceptNewState = optionHandlers[option].getAcceptLocal();
        }
        else
        {
        /* open TelnetOptionHandler functionality (end)*/
            /* TERMINAL-TYPE option (start)*/
            if (option == TERMINAL_TYPE)
            {
                if ((terminalType != null) && (terminalType.length() > 0))
                {
                    acceptNewState = true;
                }
            }
            /* TERMINAL-TYPE option (end)*/
        /* open TelnetOptionHandler functionality (start)*/
        }
        /* open TelnetOptionHandler functionality (end)*/

        if (_willResponse[option] > 0)
        {
            --_willResponse[option];
            if (_willResponse[option] > 0 && _stateIsWill(option))
            {
                --_willResponse[option];
            }
        }

        if (_willResponse[option] == 0)
        {
            if (_requestedWont(option))
            {

                switch (option)
                {

                default:
                    break;

                }


                if (acceptNewState)
                {
                    _setWantWill(option);
                    _sendWill(option);
                }
                else
                {
                    ++_willResponse[option];
                    _sendWont(option);
                }
            }
            else
            {
                // Other end has acknowledged option.

                switch (option)
                {

                default:
                    break;

                }

            }
        }

        _setWill(option);
    }
