package com.java.thinking.file;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CompressUtils {

	public static void compress(File inFile, File outFile) throws IOException {
		long time = System.currentTimeMillis();
		// 做准备压缩一个字符文件，注，这里的字符文件要是utf-8编码方式的
		InputStream inputStream = new FileInputStream(inFile);
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
		// 使用GZIPOutputStream包装OutputStream流，使其具体压缩特性，最后会生成test.txt.gz压缩包
		OutputStream outputStream = new FileOutputStream(outFile);
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(outputStream));
		int c;
		while ((c = in.read()) != -1) {
			/*
			 * 注，这里是压缩一个字符文件，前面是以字符流来读的，不能直接存入c，因为c已是Unicode
			 * 码，这样会丢掉信息的(当然本身编码格式就不对)，所以这里要以utf-8来解后再存入。
			 */
			out.write(String.valueOf((char) c).getBytes("utf-8"));
		}
		in.close();
		out.close();
		System.out.println("compress耗时：" + (System.currentTimeMillis() - time));
	}

	public static void gzip(File inFile, File outFile) throws IOException {
		long time = System.currentTimeMillis();
		FileInputStream fis = null;
		GZIPOutputStream gos = null;
		try {
			fis = new FileInputStream(inFile);
			// 往外写的时候, 用GZIPOutputStream, 直接写成压缩文件, 包装流
			gos = new GZIPOutputStream(new FileOutputStream(outFile));
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) != -1) {
				gos.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeQuitely(fis);
			closeQuitely(gos);
		}
		System.out.println("gzip耗时：" + (System.currentTimeMillis() - time));
	}

	public static void unzip(InputStream is, File targetFile) {
		long time = System.currentTimeMillis();
		GZIPInputStream gis = null;
		FileOutputStream fos = null;
		try {
			gis = new GZIPInputStream(is);
			fos = new FileOutputStream(targetFile);
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = gis.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeQuitely(gis);
			closeQuitely(fos);
		}
		System.out.println("unzip耗时：" + (System.currentTimeMillis() - time));
	}

	/**
	 * 关闭流
	 * 
	 * @param stream
	 */
	public static void closeQuitely(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String readGz(File gzFile) throws IOException {
		// 使用GZIPInputStream包装InputStream流，使其具有解压特性
		InputStream inputStream = new FileInputStream(gzFile);
		Reader reader = new InputStreamReader(new GZIPInputStream(inputStream), "utf-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String s;
		StringBuilder builder = new StringBuilder();
		// 读取压缩文件里的内容
		while ((s = bufferedReader.readLine()) != null) {
			builder.append(s);
		}
		bufferedReader.close();
		return builder.toString();
	}

	public static byte[] file2byte(String filePath) {
		byte[] buffer = null;
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

	public static byte[] gzip(byte[] data) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(bos);
		gzip.write(data);
		gzip.finish();
		gzip.close();
		byte[] ret = bos.toByteArray();
		bos.close();
		return ret;
	}

	public static byte[] ungzip(byte[] data) throws Exception {
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		GZIPInputStream gzip = new GZIPInputStream(bis);
		byte[] buf = new byte[1024];
		int num = -1;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((num = gzip.read(buf, 0, buf.length)) != -1) {
			bos.write(buf, 0, num);
		}
		gzip.close();
		bis.close();
		byte[] ret = bos.toByteArray();
		bos.flush();
		bos.close();
		return ret;
	}

	public static void main(String[] args) throws Exception {

		// 读取文件
		File inFile = new File("D:/gzip/nebula.txt");
		File outFile = new File("D:/gzip/nebula.gz");
		compress(inFile, outFile);
		File inFile2 = new File("D:/gzip/nebula2.txt");
		File outFile2 = new File("D:/gzip/nebula2.gz");
		gzip(inFile2, outFile2);
	}
}