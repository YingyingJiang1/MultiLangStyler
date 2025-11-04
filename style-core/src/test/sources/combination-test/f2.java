public static byte[] readLine4(InputStream in) throws IOException {
	int b;
	// Skip leading LF
	while ((b = in.read()) == LF) {
		// skip
	}
	if (b < 0) {
		return null;
	}

	byte[] buf = new byte[256];
	int len = 0;

	while (b != CR && b != LF && b >= 0) {
		if (len >= buf.length) {
			byte[] newBuf = new byte[buf.length + 256];
			System.arraycopy(buf, 0, newBuf, 0, len);
			buf = newBuf;
		}
		buf[len++] = (byte) b;
		b = in.read();
	}

	if (b == CR) {
		if (in.markSupported()) {
			in.mark(1);
			int nextByte = in.read();
			if (nextByte != LF) {
				in.reset();
			}
		}
	}

	return (len == 0) ? new byte[0] : Arrays.copyOf(buf, len);
}