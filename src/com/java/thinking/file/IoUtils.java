package com.java.thinking.file;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Checksum;

public final class IoUtils {
	private static final int BUFFER_SIZE = 8192;

	public IoUtils() {
	}

	public static byte[] readAllBytes(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		copyAllBytes(in, out);
		return out.toByteArray();
	}

	public static byte[] readAllBytesAndClose(InputStream in) throws IOException {
		byte[] var1;
		try {
			var1 = readAllBytes(in);
		} finally {
			safeClose(in);
		}

		return var1;
	}

	public static String readAllChars(Reader reader) throws IOException {
		char[] buffer = new char[4096];
		StringBuilder builder = new StringBuilder();

		while (true) {
			int read = reader.read(buffer);
			if (read == -1) {
				return builder.toString();
			}

			builder.append(buffer, 0, read);
		}
	}

	public static String readAllCharsAndClose(Reader reader) throws IOException {
		String var1;
		try {
			var1 = readAllChars(reader);
		} finally {
			safeClose(reader);
		}

		return var1;
	}

	public static void writeAllCharsAndClose(Writer writer, CharSequence text) throws IOException {
		try {
			writer.append(text);
		} finally {
			safeClose(writer);
		}

	}

	public static void updateChecksum(InputStream in, Checksum checksum) throws IOException {
		byte[] buffer = new byte[8192];

		while (true) {
			int read = in.read(buffer);
			if (read == -1) {
				return;
			}

			checksum.update(buffer, 0, read);
		}
	}


	public static byte[] getDigest(InputStream in, String digestAlgo) throws IOException {
		MessageDigest digester;
		try {
			digester = MessageDigest.getInstance(digestAlgo);
		} catch (NoSuchAlgorithmException var5) {
			throw new RuntimeException(var5);
		}

		byte[] buffer = new byte[8192];

		while (true) {
			int read = in.read(buffer);
			if (read == -1) {
				return digester.digest();
			}

			digester.update(buffer, 0, read);
		}
	}

	public static int copyAllBytes(InputStream in, OutputStream out) throws IOException {
		int byteCount = 0;
		byte[] buffer = new byte[8192];

		while (true) {
			int read = in.read(buffer);
			if (read == -1) {
				return byteCount;
			}

			out.write(buffer, 0, read);
			byteCount += read;
		}
	}

	public static void safeClose(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException var2) {
				;
			}
		}

	}
}
