package com.snp.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.oro.io.GlobFilenameFilter;
import org.apache.oro.text.GlobCompiler;

public class FileProcessor {
	// 遍历出的各个文件全路径
	public static void listfile(File dir, List picturelist, List videolist,
			List otherlist) {
		String strPath;
		File[] files;
		files = dir.listFiles(); // 得到一个由文件和目录组成的数组;
		Arrays.sort(files); // 把数组按升序排列;
		for (int i = 0; i < files.length; i++) {
			strPath = files[i].toString();
			if (files[i].isDirectory()) {
				listfile(files[i], picturelist, videolist, otherlist);
			} else {
				if (strPath.endsWith(".jpg") || strPath.endsWith(".gif")) {
					// log.debug(files[i].getAbsolutePath());
					picturelist.add(files[i].getAbsolutePath());
					// picturelist.add(StringUtils.substringAfter(files[i].getAbsolutePath(),
					// dir.getAbsolutePath()));
				} else if (strPath.endsWith(".flv")) {
					videolist.add(files[i].getAbsolutePath());
				} else {
					otherlist.add(files[i].getAbsolutePath());
				}
			}// 递归

		}

	}

	public static boolean getNetfile(String url, String savepath)
			throws Exception {
		try {
			URL address;
			address = new URL(url);
			byte[] data = new byte[2024];
			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					address.openStream()); // 获取输入流

			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(savepath));
			int c = 0;
			while ((c = bufferedInputStream.read(data)) != -1) {// 这里才能保证不会写入多余的缓存字节数
				bufferedOutputStream.write(data, 0, c);
			}
			if (c == 0)
				return false;// 当没读到数据时
			bufferedOutputStream.flush();
			bufferedInputStream.close();
			bufferedOutputStream.close();
			return true;
		} catch (Exception e) {
			throw e;

		}
	}

	/**
	 * 建立新文件夹的时候，先删除掉旧的 我们在导出图片包，视频包时要就建立一个临时TEMP文件夹
	 * */
	public static void createNewDir(String filepath) {
		try {
			FileUtils.deleteDirectory(new File(filepath));
			FileUtils.forceMkdir(new File(filepath));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 检查文件是否存在，CSS更改里面，还有FTP里面
	 * */
	public static boolean checkFileExit(String filepath) {
		try {
			new FileInputStream(filepath);
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}

	/**
	 * 检查文件是否存在，CSS更改里面，还有FTP里面
	 * 
	 * @throws Exception
	 * */
	public static boolean noExitCreate(String filepath) {
		try {
			new FileInputStream(filepath);
			return true;
		} catch (FileNotFoundException e) {
			try {
				FileUtils.forceMkdir(new File(filepath));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return true;
		}
	}

	/**
	 * 求某目录下的文件个数，我们的LICENCEMANAGER用到了
	 */
	public static String[] getfilenames(String path, String strfilter)
			throws Exception {
		File dir;
		FilenameFilter filter;
		dir = new File(path);

		filter = new GlobFilenameFilter(strfilter,
				GlobCompiler.STAR_CANNOT_MATCH_NULL_MASK);
		String[] filenames = dir.list(filter);
		return filenames;
	}

	/**
	 * 字符串变成新文件
	 * */
	public static void strToDoc(String filename, String str) {
		FileOutputStream fostemp;
		try {
			fostemp = new FileOutputStream(filename, false);
			PrintStream out = new PrintStream(
					new BufferedOutputStream(fostemp), false, "utf-8");
			out.print(str);
			out.close();
			fostemp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * JFrameVersion下载升级包时，是下载一个ZIP包，必须用这种方式才不会让包损坏
	 * FileProcessor.betyToDoc(server_path, get.getResponseBody());
	 * 我们如果通过网络转化一个字符串的话，会导致ZIP文件不能使用,
	 */
	public static void betyToDoc(String filename, byte[] betyarray)
			throws Exception {
		FileOutputStream fis = new FileOutputStream(filename);
		fis.write(betyarray);
		fis.close();
	}

	public static int getfilesize(String filename) throws Exception {
		File file = new File(filename);
		FileInputStream fis = null;
		fis = new FileInputStream(file);
		// log.debug("文件size:"+String.valueOf(fis.available()));
		return fis.available();

	}

	/**
	 * 带时间标签写入新文件里面，是添加新行的模式
	 **/
	public static void writetofile(String filename, String infostr)
			throws Exception {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strCurrTime = df.format(date);
		FileOutputStream fos = new FileOutputStream(filename, true);
		PrintStream out = new PrintStream(new BufferedOutputStream(fos));
		out.println(strCurrTime + " " + infostr);
		out.close();

	}

	public static void writetofileNotime(String filename, String infostr)
			throws Exception {
		FileOutputStream fos = new FileOutputStream(filename, true);
		PrintStream out = new PrintStream(new BufferedOutputStream(fos));
		out.println(infostr);
		out.close();

	}

	/*
	 * java用的是Unicode 编码char 型变量的范围是0-65535 无符号的值，可以表示
	 * 65536个字符，基本上地球上的字符可被全部包括了,
	 * 实际中,我们希望判断一个字符是不是汉字,或者一个字符串里的字符是否有汉字来满足业务上的需求,String类中有个这样的方法可得到其字符长度length
	 * () ,看下面例子, String s1 = "我是中国人"; String s2 = "imchinese"; String s3 =
	 * "im中国人"; log.debug(s1+":"+new String(s1).length()); log.debug(s2+":"+new
	 * String(s2).length()); log.debug(s3+":"+new String(s3).length()); OUTPUT:
	 * 我是中国人:5 imchinese:9 im中国人:5
	 * 看到了吧,字符串里如果有双字节的字符java就把每个字符都按双字节编码,如果都是单字节的字符就按单字节编码 于是按照以上的规律,结合一位QQ昵称
	 * ？G茶？I珠海 兄的提示由以下解决方法,就是判断字符串的长度和字符字节的长度是否相同来判断是否有双字节的字符
	 * log.debug((s1.getBytes().length == s1.length())?"s1无汉字":"s1有汉字");
	 * log.debug((s2.getBytes().length == s2.length())?"s2无汉字":"s2有汉字");
	 * log.debug((s3.getBytes().length == s3.length())?"s3无汉字":"s3有汉字");
	 */
	public static boolean check_chinese_string(String filepath)
			throws Exception {
		if (filepath.getBytes().length == filepath.length()) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		try {
			FileUtils.forceMkdir(new File("c:/temp/可以吗"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/*
	 * public static List getdirnames(String path) throws Exception { ArrayList
	 * dirnamelist = new ArrayList(); File dir = new File(path); File[] filelist
	 * = dir.listFiles(); for (int i = 0; i < filelist.length; i++) { File
	 * element = (File) filelist[i]; if (element.isDirectory())
	 * dirnamelist.add(element.getName()); } return dirnamelist; }
	 */
	/*
	 * public static int getFileSize(String filename) throws Exception {
	 * InputStream in; try { in = new FileInputStream(filename); return
	 * in.available(); } catch (Exception e) { log.debug("读文件大小错误！" + filename);
	 * throw e; } }
	 */
	/*
	 * 按时间分目录写入不同文件名的目录 public static void writetoDifFile(String path, String
	 * filename, String infostr) throws Exception { Date date = new Date();
	 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); String
	 * strCurrTime = df.format(date); path = path + strCurrTime + '/'; File file
	 * = new File(path); if (!file.exists()) { file.mkdirs(); } FileOutputStream
	 * fos = new FileOutputStream(path + filename, true); PrintStream out = new
	 * PrintStream(new BufferedOutputStream(fos)); out.println(infostr);
	 * out.close(); }
	 */
	/*
	 * public static int getLineNumber(String filename) throws Exception {
	 * BufferedReader br = new BufferedReader(new InputStreamReader( new
	 * FileInputStream(filename), "utf-8")); int linenumber = 0; while
	 * (br.readLine() != null) { linenumber++; } return linenumber; }
	 */
	/*
	 * 建立文件夹下的字目录 public static void checkFileDir(String filedir, String subdir)
	 * { String[] temp = StringUtils.split(subdir, "/"); for (int i = 0; i <
	 * temp.length; i++) { filedir = filedir + "/" + temp[i]; File FileDir = new
	 * File(filedir); if (!FileDir.exists()) { FileDir.mkdir(); } } }
	 */
	/*
	 * public static void checkFileDir(String filepath) { File FileDir = new
	 * File(filepath); if (!FileDir.exists()) { FileDir.mkdir(); } }
	 */
}