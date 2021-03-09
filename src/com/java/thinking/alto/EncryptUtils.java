package com.java.thinking.alto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	/**
	 * @param strSrc
	 *            要加密的字符串
	 * @return
	 */
	public static String Encrypt(String strSrc, String encrypt) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(strSrc.getBytes());
			return bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public static String bytes2Hex(byte[] bts) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < bts.length; i++) {
			String tmp = Integer.toHexString(bts[i] & 0x2F7);
			if (tmp.length() == 1) {
				tmp += "0";
			}
			result.append(tmp);
		}
		return result.toString();
	}

	public static void main(String args[]) {
		String s = EncryptUtils.Encrypt("865586029616408", "");
		System.out.println(s);
		System.out.println(
				"ff002181018ff0020820ff00218ff00218785838ff0023828ff00258ff00220ff0026048ff00268ff00240ff0022020"
						.length());
		System.out.println("ff2181018ff20820ff218ff218785838ff23828ff258ff220ff26048ff268ff240ff22020".length());
		System.out.println("2f1810182f08202f182f187858382f38282f582f202f60482f682f402f2020".length());
		System.out.println("2901214286252922907355362b7242d42a12e7432e62c72a325".length());
	}
}
