    private void flushAuxiliar(long amount) throws IOException {
        if (aux.length < 1) {
            return;
        }

        out.flush();
        aux.flush();

        boolean underflow = aux.offset < aux.length || out.offset < out.length;
        byte[] buffer = new byte[COPY_BUFFER_SIZE];

        aux.target.seek(0);
        out.target.seek(out.length);

        long length = amount;
        while (length > 0) {
            int read = (int) Math.min(length, Integer.MAX_VALUE);
            read = aux.target.read(buffer, 0, Math.min(read, buffer.length));

            if (read < 1) {
                amount -= length;
                break;
            }

            out.writeProof(buffer, read);
            length -= read;
        }

        if (underflow) {
            if (out.offset >= out.length) {
                // calculate the aux underflow pointer
                if (aux.offset < amount) {
                    out.offset += aux.offset;
                    aux.offset = 0;
                    out.target.seek(out.offset);
                } else {
                    aux.offset -= amount;
                    out.offset = out.length + amount;
                }
            } else {
                aux.offset = 0;
            }
        } else {
            out.offset += amount;
            aux.offset -= amount;
        }

        out.length += amount;

        if (out.length > maxLengthKnown) {
            maxLengthKnown = out.length;
        }

        if (amount < aux.length) {
            // move the excess data to the beginning of the file
            long readOffset = amount;
            long writeOffset = 0;

            aux.length -= amount;
            length = aux.length;
            while (length > 0) {
                int read = (int) Math.min(length, Integer.MAX_VALUE);
                read = aux.target.read(buffer, 0, Math.min(read, buffer.length));

                aux.target.seek(writeOffset);
                aux.writeProof(buffer, read);

                writeOffset += read;
                readOffset += read;
                length -= read;

                aux.target.seek(readOffset);
            }

            aux.target.setLength(aux.length);
            return;
        }

        if (aux.length > THRESHOLD_AUX_LENGTH) {
            aux.target.setLength(THRESHOLD_AUX_LENGTH);// or setLength(0);
        }

        aux.reset();
    }
