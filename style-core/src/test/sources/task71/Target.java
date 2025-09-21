// M1150
        private void select() {
            try {
                selector.select();

                Set<SelectionKey> selected = selector.selectedKeys();
                ArrayList<SelectionKey> selectedList = new ArrayList<>(selected);
                Collections.shuffle(selectedList);
                Iterator<SelectionKey> selectedKeys = selectedList.iterator();
                while (!stopped && selectedKeys.hasNext()) {
                    SelectionKey key = selectedKeys.next();
                    selected.remove(key);

                    if (!key.isValid()) {
                        cleanupSelectionKey(key);
                        continue;
                    }
                    if (key.isReadable() || key.isWritable()) {
                        handleIO(key);
                    } else {
                        LOG.warn("Unexpected ops in select {}", key.readyOps());
                    }
                }
            } catch (IOException e) {
                LOG.warn("Ignoring IOException while selecting", e);
            }
        }


// M1145
        private void select() {
            try {
                selector.select();

                Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
                while (!stopped && selectedKeys.hasNext()) {
                    SelectionKey key = selectedKeys.next();
                    selectedKeys.remove();

                    if (!key.isValid()) {
                        continue;
                    }
                    if (key.isAcceptable()) {
                        if (!doAccept()) {
                            // If unable to pull a new connection off the accept
                            // queue, pause accepting to give us time to free
                            // up file descriptors and so the accept thread
                            // doesn't spin in a tight loop.
                            pauseAccept(10);
                        }
                    } else {
                        LOG.warn("Unexpected ops in accept select {}", key.readyOps());
                    }
                }
            } catch (IOException e) {
                LOG.warn("Ignoring IOException while selecting", e);
            }
        }


// M185
	synchronized public long size() throws IOException {
	    if (LOG.isTraceEnabled()) {
		LOG.trace("size() called");
	    }

	    if (this.endtime >= src.getEndTime()) {
		return src.size() - skippedAtStart;
	    }
	    
	    long pos = in.getPosition();
	    
	    if (LOG.isTraceEnabled()) {
		LOG.trace("saved pos () = " + pos);
	    }
	    
	    LogEntry e;
	  
	    LogSkipList.Mark lastseg = src.getSkipList().findMarkBefore(this.endtime);
	    in.seek(lastseg.getBytes());
	    buf = "";  // clear the buf so we don't get something we read before we sought
	    // number of entries skipped to get to the end of the iterator, less the number skipped to get to the start
	    long count = lastseg.getEntriesSkipped() - skippedAtStart; 

	    while ((e = readNextEntry()) != null) {
		if (LOG.isTraceEnabled()) {
		    //LOG.trace(e);
		}
		if (e.getTimestamp() > this.endtime) {
		    break;
		}
		count++;
	    }
	    in.seek(pos);
	    buf = "";

	    if (LOG.isTraceEnabled()) {
		LOG.trace("size() = " + count);
	    }
	    
	    return count;
	}


// M1129
    public synchronized void dumpConnectionInfo(PrintWriter pwriter, boolean brief) {
        pwriter.print(" ");
        pwriter.print(getRemoteSocketAddress());
        pwriter.print("[");
        int interestOps = getInterestOps();
        pwriter.print(interestOps == 0 ? "0" : Integer.toHexString(interestOps));
        pwriter.print("](queued=");
        pwriter.print(getOutstandingRequests());
        pwriter.print(",recved=");
        pwriter.print(getPacketsReceived());
        pwriter.print(",sent=");
        pwriter.print(getPacketsSent());

        if (!brief) {
            long sessionId = getSessionId();
            if (sessionId != 0) {
                pwriter.print(",sid=0x");
                pwriter.print(Long.toHexString(sessionId));
                pwriter.print(",lop=");
                pwriter.print(getLastOperation());
                pwriter.print(",est=");
                pwriter.print(getEstablished().getTime());
                pwriter.print(",to=");
                pwriter.print(getSessionTimeout());
                long lastCxid = getLastCxid();
                if (lastCxid >= 0) {
                    pwriter.print(",lcxid=0x");
                    pwriter.print(Long.toHexString(lastCxid));
                }
                pwriter.print(",lzxid=0x");
                pwriter.print(Long.toHexString(getLastZxid()));
                pwriter.print(",lresp=");
                pwriter.print(getLastResponseTime());
                pwriter.print(",llat=");
                pwriter.print(getLastLatency());
                pwriter.print(",minlat=");
                pwriter.print(getMinLatency());
                pwriter.print(",avglat=");
                pwriter.print(getAvgLatency());
                pwriter.print(",maxlat=");
                pwriter.print(getMaxLatency());
            }
        }
        pwriter.print(")");
    }


// M192
    private void init() throws IOException {
	File f = new File(file);
	RandomAccessFileReader in = new RandomAccessFileReader(f);
	SimpleDateFormat dateformat = new SimpleDateFormat(DATE_FORMAT);
	Pattern idp = Pattern.compile("\\[myid:(\\d+)\\]");

	long lastFp = in.getPosition();
	String line = in.readLine();
	Matcher m = null;

	// if we have read data from the file, and it matches the timep pattern
	if ((line != null) && (m = timep.matcher(line)).lookingAt()) {
	    starttime = timestampFromText(dateformat, m.group(1));
	} else {
	    throw new IOException("Invalid log format. First line doesn't start with time");
	}

	/*
	  Count number of log entries. Any line starting with a timestamp counts as an entry
	*/
	String lastentry = line;
	try {
	    while (line != null) {
		m = timep.matcher(line);
		if (m.lookingAt()) {
		    if (size % skipN == 0) {
			long time = timestampFromText(dateformat, m.group(1));
			skiplist.addMark(time, lastFp, size);
		    }
		    size++;
		    lastentry = line;
		} 
		if (serverid == 0 && (m = idp.matcher(line)).find()) {
		    serverid = Integer.valueOf(m.group(1));
		}

		lastFp = in.getPosition();
		line = in.readLine();
	    }
	} catch (EOFException eof) {
	    // ignore, simply end of file, though really (line!=null) should have caught this
	} finally {
	    in.close();
	}

	m = timep.matcher(lastentry);
	if (m.lookingAt()) {
	    endtime = timestampFromText(dateformat, m.group(1));
	} else {
	    throw new IOException("Invalid log format. Last line doesn't start with time");
	}
    }


// M41
		public void run()
		{
			try
			{
				boolean animateFromBottom = true;
				GraphicsEnvironment ge = GraphicsEnvironment
						.getLocalGraphicsEnvironment();
				Rectangle screenRect = ge.getMaximumWindowBounds();

				int screenHeight = (int) screenRect.height;

				int startYPosition;
				int stopYPosition;

				if ( screenRect.y > 0 )
				{
				  animateFromBottom = false; // Animate from top!
				}

				maxToasterInSceen = screenHeight / toasterHeight;


				int posx = (int) screenRect.width - toasterWidth - 1;

				toaster.setLocation(posx, screenHeight);
				toaster.setVisible(true);
				if ( useAlwaysOnTop )
				{
				  toaster.setAlwaysOnTop(true);
				}

				if ( animateFromBottom )
				{
					startYPosition = screenHeight;
					stopYPosition = startYPosition - toasterHeight - 1;
					if ( currentNumberOfToaster > 0 )
					{
						stopYPosition = stopYPosition - ( maxToaster % maxToasterInSceen * toasterHeight );
					}
					else
					{
						maxToaster = 0;
					}
				}
				else
				{
					startYPosition = screenRect.y - toasterHeight;
					stopYPosition = screenRect.y;

					if ( currentNumberOfToaster > 0 )
					{
						stopYPosition = stopYPosition + ( maxToaster % maxToasterInSceen * toasterHeight );
					}
					else
					{
						maxToaster = 0;
					}
				}

				currentNumberOfToaster++;
				maxToaster++;


				animateVertically( posx, startYPosition, stopYPosition );
				Thread.sleep(displayTime);
				animateVertically( posx, stopYPosition, startYPosition );

				currentNumberOfToaster--;
				toaster.setVisible(false);
				toaster.dispose();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}


