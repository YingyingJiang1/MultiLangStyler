    private Elst parseEdts(final Box ref) throws IOException {
        final Box b = untilBox(ref, ATOM_ELST);
        if (b == null) {
            return null;
        }

        final Elst obj = new Elst();

        final boolean v1 = stream.read() == 1;
        stream.skipBytes(3); // flags

        final int entryCount = stream.readInt();
        if (entryCount < 1) {
            obj.bMediaRate = 0x00010000; // default media rate (1.0)
            return obj;
        }

        if (v1) {
            stream.skipBytes(DataReader.LONG_SIZE); // segment duration
            obj.mediaTime = stream.readLong();
            // ignore all remain entries
            stream.skipBytes((entryCount - 1) * (DataReader.LONG_SIZE * 2));
        } else {
            stream.skipBytes(DataReader.INTEGER_SIZE); // segment duration
            obj.mediaTime = stream.readInt();
        }

        obj.bMediaRate = stream.readInt();

        return obj;
    }
