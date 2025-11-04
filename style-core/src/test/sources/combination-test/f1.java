public static byte[] readLine3(InputStream in) throws IOException {
	byte[] buf = new byte[256];
	int i = 0, loops = 0, ch = 0;
	while (true) {
		ch = in.read();
		if (ch < 0)
			break;
		loops++;
		// skip a leading LF's
		if (loops == 1 && ch == LF)
			continue;
		if (ch == CR || ch == LF)
			break;
		if (i >= buf.length) {
			byte[] old_buf = buf;
			buf = new byte[old_buf.length + 256];
			System.arraycopy(old_buf, 0, buf, 0, old_buf.length);
		}
		buf[i++] = (byte) ch;
	}
	if (ch == -1 && i == 0)
		return null;
	// skip a trailing LF if it exists
	if (ch == CR && in.available() >= 1 && in.markSupported()) {
		in.mark(1);
		ch = in.read();
		if (ch != LF)
			in.reset();
	}
	byte[] old_buf = buf;
	buf = new byte[i];
	System.arraycopy(old_buf, 0, buf, 0, i);
	return buf;
}