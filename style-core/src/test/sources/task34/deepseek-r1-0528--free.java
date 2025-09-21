
    public InputStream getView(int size) {
        if (view != null) {
            viewSize = size;
            return view;
        }

        view = new InputStream() {
            @Override
            public int read() throws IOException {
                if (viewSize < 1) return -1;
                int res = DataReader.this.read();
                if (res > 0) viewSize--;
                return res;
            }

            @Override
            public int read(byte[] buffer) throws IOException {
                return read(buffer, 0, buffer.length);
            }

            @Override
            public int read(byte[] buffer, int offset, int count) throws IOException {
                if (viewSize < 1) return -1;
                int res = DataReader.this.read(buffer, offset, Math.min(viewSize, count));
                viewSize -= res;
                return res;
            }

            @Override
            public long skip(long amount) throws IOException {
                if (viewSize < 1) return 0;
                int res = (int) DataReader.this.skipBytes(Math.min(amount, viewSize));
                viewSize -= res;
                return res;
            }

            @Override
            public int available() {
                return viewSize;
            }

            @Override
            public void close() {
                viewSize = 0;
            }

            @Override
            public boolean markSupported() {
                return false;
            }
        };

        viewSize = size;
        return view;
    }
