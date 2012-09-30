package com.snp.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.zip.ZipOutputStream;

public class Compress {
	private static Log log = LogFactory.getLog(Compress.class);

	/**
	 * 压缩一个目录
	 * 
	 * @param zipFileName
	 *            zip文件名
	 * @param fileOrDir
	 *            要压缩的目录
	 * @throws Exception
	 */
	public static void zip(String fileOrDir, String zipFileName)
			throws Exception {
		File inputFile = new File(fileOrDir);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				zipFileName));
		zip(out, inputFile, "");
		out.close();
	}

	/*
	 * private static void zip(String zipFileName, File inputFile) throws
	 * Exception { ZipOutputStream out = new ZipOutputStream(new
	 * FileOutputStream( zipFileName)); zip(out, inputFile, ""); out.close(); }
	 */
	private static void zip(ZipOutputStream out, File f, String base)
			throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			byte[] bytes = new byte[1024];
			int c = 0;
			// log.debug(base);
			while ((c = in.read(bytes)) != -1) {
				out.write(bytes, 0, c);
			}
			in.close();
		}
	}

	/**
	 * 解压带目录结构的ZIP 只有这样才能解压缩目录结构的ZIP文件
	 * 
	 * @param filename
	 *            要解压的文件
	 * @param filepath
	 *            解压后存放的路径
	 * 
	 */
	public static void unpack(String filename, String filepath)
			throws Exception {
		Enumeration entries;
		ZipFile zipFile;
		zipFile = new ZipFile(filename);
		entries = zipFile.entries();
		String newfilename = "";
		while (entries.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) entries.nextElement();
			log.debug(entry.getName());
			if (entry.getName().startsWith("other/")
					|| entry.getName().startsWith("index.html")
					|| entry.getName().startsWith("resself"))
				continue;

			if (entry.isDirectory()) {
				(new File(filepath + entry.getName())).mkdir();
				continue;
			}
			// log.debug(filepath + entry.getName());
			// 有时 ZIP里面可能有中文文件，会导致解压错误直接退出，所以用try
			try {
				if (entry.getName().contains("/")) {
					newfilename = StringUtils.substringAfterLast(
							entry.getName(), "/");
				} else {
					newfilename = entry.getName();
				}
				copyInputStream(zipFile.getInputStream(entry),
						new BufferedOutputStream(new FileOutputStream(filepath
								+ newfilename)));

			} catch (Exception e) {
				log.debug("error file in zip:" + filepath + entry.getName() + e);
			}
		}
		zipFile.close();
	}

	// member_config.xml
	public static void unpack_no_config(String filename, String filepath)
			throws Exception {
		Enumeration entries;
		ZipFile zipFile;
		zipFile = new ZipFile(filename);
		entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) entries.nextElement();

			if (entry.getName().equals("member_config.xml")
					|| entry.getName().equals("LanmuConfig.xml"))
				continue;
			// System.err.println("FileName: " + entry.getName());
			if (entry.isDirectory()) {
				(new File(filepath + entry.getName())).mkdir();
				continue;
			}
			// log.debug(filepath + entry.getName());
			try {
				copyInputStream(zipFile.getInputStream(entry),
						new BufferedOutputStream(new FileOutputStream(filepath
								+ entry.getName())));
			} catch (Exception e) {
				log.debug("error file in zip:" + filepath + entry.getName() + e);
			}

		}
		zipFile.close();
	}

	/* 上面的函数用到 */
	public static final void copyInputStream(InputStream in, OutputStream out)
			throws IOException {
		byte[] buffer = new byte[1024];
		int len;
		while ((len = in.read(buffer)) >= 0)
			out.write(buffer, 0, len);
		in.close();
		out.close();
	}
}
