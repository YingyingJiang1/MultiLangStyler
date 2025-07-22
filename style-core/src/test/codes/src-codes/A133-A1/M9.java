    @SuppressWarnings("resource")
    public static long select(boolean v, long telnetPortPid, String select) throws InputMismatchException {
        Map<Long, String> processMap = listProcessByJps(v);
        // Put the port that is already listening at the first
        if (telnetPortPid > 0 && processMap.containsKey(telnetPortPid)) {
            String telnetPortProcess = processMap.get(telnetPortPid);
            processMap.remove(telnetPortPid);
            Map<Long, String> newProcessMap = new LinkedHashMap<Long, String>();
            newProcessMap.put(telnetPortPid, telnetPortProcess);
            newProcessMap.putAll(processMap);
            processMap = newProcessMap;
        }

        if (processMap.isEmpty()) {
            AnsiLog.info("Can not find java process. Try to run `jps` command lists the instrumented Java HotSpot VMs on the target system.");
            return -1;
        }

		// select target process by the '--select' option when match only one process
		if (select != null && !select.trim().isEmpty()) {
			int matchedSelectCount = 0;
			Long matchedPid = null;
			for (Entry<Long, String> entry : processMap.entrySet()) {
				if (entry.getValue().contains(select)) {
					matchedSelectCount++;
					matchedPid = entry.getKey();
				}
			}
			if (matchedSelectCount == 1) {
				return matchedPid;
			}
		}

        AnsiLog.info("Found existing java process, please choose one and input the serial number of the process, eg : 1. Then hit ENTER.");
        // print list
        int count = 1;
        for (String process : processMap.values()) {
            if (count == 1) {
                System.out.println("* [" + count + "]: " + process);
            } else {
                System.out.println("  [" + count + "]: " + process);
            }
            count++;
        }

        // read choice
        String line = new Scanner(System.in).nextLine();
        if (line.trim().isEmpty()) {
            // get the first process id
            return processMap.keySet().iterator().next();
        }

        int choice = new Scanner(line).nextInt();

        if (choice <= 0 || choice > processMap.size()) {
            return -1;
        }

        Iterator<Long> idIter = processMap.keySet().iterator();
        for (int i = 1; i <= choice; ++i) {
            if (i == choice) {
                return idIter.next();
            }
            idIter.next();
        }

        return -1;
    }
