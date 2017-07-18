package com.java.thinking.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.java.thinking.file.IoUtils;

public class TestFile {
	public static void main(String[] args) {
		File from=new File("D:/AndDoc/liuxian/git.txt");
		File to=new File("D:/AndDoc/liuxian/gitCopy.txt");
		try {
			copyFile(from, to);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void copyFile(File from, File to) throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(from));
		try {
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(to));
			try {
				IoUtils.copyAllBytes(in, out);
			} finally {
				IoUtils.safeClose(out);
			}
		} finally {
			IoUtils.safeClose(in);
		}

	}
}
