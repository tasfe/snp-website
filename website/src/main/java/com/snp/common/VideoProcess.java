package com.snp.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.snp.site.init.SystemInit;

public class VideoProcess {
	private static Log log = LogFactory.getLog(VideoProcess.class);

	public static void run_ffmpeg(String command) {
		Runtime run = Runtime.getRuntime();
		Process process;
		try {
			process = run.exec(command);
			InputStream stderr = process.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				log.debug(line);
			int exitVal = process.waitFor();
			if (exitVal != 0) {
				log.error("vedio convert error:" + command);
			}
		} catch (Exception e) {
			log.error("vedio convert error:" + command);
			e.printStackTrace();
		}
	}

	// 在跟文件同样的目录生成一个flv文件
	public static void gen_video(String filename, String width, String height)
			throws Exception {
		// StringUtils.substringBeforeLast(str, separator)Last(str, separator)
		String fileflvname = StringUtils.substringBeforeLast(filename, ".")
				+ ".flv";

		String file_post = StringUtils.substringAfterLast(filename, ".");
		String cmdString = null;
		String os = System.getProperty("os.name").toLowerCase();
		if (os.indexOf("window") >= 0) {
			cmdString = "video/ffmpeg.exe -i  ";
		}
		if (os.indexOf("linux") >= 0) {
			cmdString = "ffmpeg -i  ";
		}
		/*
		 * if (filename.endsWith("ASF") || filename.endsWith("asf") ||
		 * filename.endsWith("AVI") || filename.endsWith("avi") ||
		 * filename.endsWith("MOV") || filename.endsWith("mov") ||
		 * filename.endsWith("MPEG") || filename.endsWith("mpeg"))
		 */
		// 不同格式的命令是不一样的
		if (file_post.equalsIgnoreCase("avi")
				|| file_post.equalsIgnoreCase("mov")
				|| file_post.equalsIgnoreCase("mpg"))

		{
			cmdString = cmdString + filename + "  -s " + width + "*" + height
					+ "  " + fileflvname;
		} else {
			cmdString = cmdString + filename + "  -ar 44100   -s " + width
					+ "*" + height + "   " + fileflvname;
			if (file_post.equalsIgnoreCase("mp3")) {
				// ffmpeg.exe -i mp3.mp3 mp3.flv
				cmdString = cmdString + filename + "  " + fileflvname;
			}
		}
		log.info(cmdString);
		run_ffmpeg(cmdString);
		try {
			if (FileProcessor.getfilesize(fileflvname) == 0) {
				throw new Exception("该文件处理异常");
			}
		} catch (Exception e) {
			throw e;

		}

	}

	public static void gen_video_gif(String filename) {
		String cmdString = null;
		String os = System.getProperty("os.name").toLowerCase();
		if (os.indexOf("window") >= 0) {
			cmdString = "video/ffmpeg.exe -i  ";
		}
		if (os.indexOf("linux") >= 0) {
			cmdString = "ffmpeg -i  ";
		}
		String smallfilename = StringUtils.substringBeforeLast(filename, ".")
				+ ".gif";
		cmdString = cmdString + filename
				+ "  -pix_fmt rgb24 -r 1  -vframes 4  -s "
				+ SystemInit.img_spmp8_width + "*"
				+ SystemInit.img_spmp8_height + "  -y -loop_output 0 "
				+ smallfilename;
		log.info("cmd:" + cmdString);
		run_ffmpeg(cmdString);
	}

}
/*
 * 
 * 
 * public static String getConverntCmdStr(String filename, String fileflvname,
 * int width, int height) { String cmdString = null; String os =
 * System.getProperty("os.name").toLowerCase(); if (os.indexOf("window") >= 0) {
 * cmdString = "video/ffmpeg.exe -i  "; } if (os.indexOf("linux") >= 0) {
 * cmdString = "ffmpeg -i  "; } // 如果是直接导入，是不会处理FLV文件，生成的文件直接在选择目录 if
 * (filename.endsWith("ASF") || filename.endsWith("asf") ||
 * filename.endsWith("AVI") || filename.endsWith("avi") ||
 * filename.endsWith("MOV") || filename.endsWith("mov") ||
 * filename.endsWith("MPEG") || filename.endsWith("mpeg")) { cmdString =
 * cmdString + filename + "  -s " + width + "*" + height + "  " + fileflvname; }
 * else { cmdString = cmdString + filename + "  -ar 44100   -s " + width + "*" +
 * height + "   " + fileflvname; } log.info(cmdString); return cmdString; }
 * 
 * // 在相同目录下，生成GIF文件 public static String get_video_gif(String filename) {
 * String cmdString = null; String os =
 * System.getProperty("os.name").toLowerCase(); if (os.indexOf("window") >= 0) {
 * cmdString = "video/ffmpeg.exe -i  "; } if (os.indexOf("linux") >= 0) {
 * cmdString = "ffmpeg -i  "; } String smallfilename =
 * StringUtils.substringBefore(filename, ".") + ".gif"; cmdString = cmdString +
 * filename + "  -pix_fmt rgb24 -r 1  -vframes 4  -s " +
 * SystemInit.img_spmp8_width + "*" + SystemInit.img_spmp8_height +
 * "  -y -loop_output 0 " + smallfilename; return cmdString; }
 * 
 * public static String getConverntCmdStr(String filename, String fileflvname,
 * int width, int height) { String cmdString = null; String os =
 * System.getProperty("os.name").toLowerCase(); if (os.indexOf("window") >= 0) {
 * cmdString = "video/ffmpeg.exe -i  "; } if (os.indexOf("linux") >= 0) {
 * cmdString = "ffmpeg -i  "; } // 如果是直接导入，是不会处理FLV文件，生成的文件直接在选择目录 if
 * (filename.endsWith("ASF") || filename.endsWith("asf") ||
 * filename.endsWith("AVI") || filename.endsWith("avi") ||
 * filename.endsWith("MOV") || filename.endsWith("mov") ||
 * filename.endsWith("MPEG") || filename.endsWith("mpeg")) { cmdString =
 * cmdString + filename + "  -s " + width + "*" + height + "  " + fileflvname; }
 * else { cmdString = cmdString + filename + "  -ar 44100   -s " + width + "*" +
 * height + "   " + fileflvname; } log.info(cmdString); return cmdString; }
 * 
 * // 在相同目录下，生成GIF文件 public static String get_video_gif(String filename) {
 * String cmdString = null; String os =
 * System.getProperty("os.name").toLowerCase(); if (os.indexOf("window") >= 0) {
 * cmdString = "video/ffmpeg.exe -i  "; } if (os.indexOf("linux") >= 0) {
 * cmdString = "ffmpeg -i  "; } String smallfilename =
 * StringUtils.substringBefore(filename, ".") + ".gif"; cmdString = cmdString +
 * filename + "  -pix_fmt rgb24 -r 1  -vframes 4  -s " +
 * SystemInit.img_spmp8_width + "*" + SystemInit.img_spmp8_height +
 * "  -y -loop_output 0 " + smallfilename; return cmdString; }
 * 
 * public static boolean acceptfile(String name) { return name.endsWith(".mpg")
 * || name.endsWith("MPG") || name.endsWith("avi") || name.endsWith("AVI") ||
 * name.endsWith("mpeg") || name.endsWith("MPEG") || name.endsWith(".3gp") ||
 * name.endsWith(".3GP") || name.endsWith(".asf") || name.endsWith(".ASF") ||
 * name.endsWith(".MOV") || name.endsWith(".mov") || name.endsWith(".mp4") ||
 * name.endsWith(".MP4") || name.endsWith(".WMV") || name.endsWith(".wmv");
 * 
 * }
 * 
 * 
 * public static String getNewFileNameByTime(String filename) {
 * 
 * String houzhui = StringUtils.substringAfterLast(filename, "."); String
 * newfilename = new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date());
 * 
 * return newfilename + "." + houzhui; } public static boolean
 * systemprocess(String commandstr) {
 * 
 * try { Runtime run = Runtime.getRuntime(); // 这个如果写在外面，视频还没处理完，就跳出来了 //
 * log.debug(Dateprocess.getTimeStr()+"开始运行"); Process proc =
 * run.exec(commandstr); // log.debug(Dateprocess.getTimeStr()+"开始完毕");
 * 
 * InputStream stderr = proc.getErrorStream(); InputStreamReader isr = new
 * InputStreamReader(stderr); BufferedReader br = new BufferedReader(isr);
 * String line = null; log.debug(""); while ((line = br.readLine()) != null)
 * log.debug(line); log.debug(""); int exitVal = proc.waitFor();
 * log.debug("Process exitValue: " + exitVal);
 * 
 * return true;// 当上面调用的程序运行完后，会返回true } catch (Exception e) { return true; } }
 */