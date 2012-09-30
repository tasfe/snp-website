package com.snp.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Dateprocess {
	private static Log log = LogFactory.getLog(Dateprocess.class);

	/**
	 * 得到另一天的字符串，如果是前几天，就是负�，后几天就加正数
	 */
	public static String getOhterDayByNumnber(String dateStr, int daynum)
			throws Exception {
		GregorianCalendar rili = new GregorianCalendar();
		// DateFormat df = DateFormat.getDateInstance("yyyy-MM-dd");
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
				"yyyy-MM-dd"); //$NON-NLS-1$	
		Date begindate = df.parse(dateStr);
		rili.setTime(begindate);
		rili.add(GregorianCalendar.DATE, daynum);
		begindate = rili.getTime();
		String s = df.format(begindate);
		return s;
	}

	public static Date getOtherDateByNumnber(Date begindate, int daynum)
			throws Exception {
		GregorianCalendar rili = new GregorianCalendar();
		rili.setTime(begindate);
		rili.add(GregorianCalendar.DATE, daynum);
		begindate = rili.getTime();
		return begindate;
	}

	// 根据当天的日期求相对日期
	public static String getDay2Today(int daynum) throws Exception {
		GregorianCalendar rili = new GregorianCalendar();
		// DateFormat df = DateFormat.getDateInstance("yyyy-MM-dd");
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
				"yyyy-MM-dd"); //$NON-NLS-1$	
		try {
			Date begindate = new java.util.Date();
			rili.setTime(begindate);
			rili.add(GregorianCalendar.DATE, daynum);
			begindate = rili.getTime();
			String s = df.format(begindate);
			return s;
		} catch (Exception e) {
			// Auto-generated catch block

			throw e;
		}

	}

	public static String getTimeStr() throws Exception {
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
				"yyyyMMddhhmmss"); //$NON-NLS-1$
		String timestr = df.format(date);
		return timestr;

	}

	/**
	 * 根据格式得到日期字符串
	 * 
	 * @param date
	 * @param format
	 *            "yyyyMMddhhmmss"类似
	 * @return
	 */
	public static String getTimeStrByDate(Date date, String format) {

		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(format); //$NON-NLS-1$
		String timestr = df.format(date);
		return timestr;

	}

	/**
	 * 根据格式得到当前日期字符串
	 * 
	 * @param date
	 * @param format
	 *            "yyyyMMddhhmmss"类似
	 * @return
	 */
	public static String getTimeStr(String format) throws Exception {
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(format); //$NON-NLS-1$
		String timestr = df.format(date);
		return timestr;

	}

	//
	public static boolean compareDayStr(String dateBegin, String dateEnd)
			throws Exception {
		try {
			DateFormat df = DateFormat.getDateInstance();
			Date begindate = df.parse(dateBegin);
			Date enddate = df.parse(dateEnd);

			if (begindate.before(enddate) || begindate.equals(enddate)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// Auto-generated catch block

			throw e;
		}

	}

	public static String getCountDayStr(String dateStr, int daynum)
			throws Exception {
		GregorianCalendar rili = new GregorianCalendar();
		DateFormat df = DateFormat.getDateInstance();
		try {
			Date begindate = df.parse(dateStr);
			rili.setTime(begindate);
			rili.add(GregorianCalendar.DATE, daynum);// ��һ��
			begindate = rili.getTime();
			df = DateFormat.getDateInstance();
			String s = df.format(begindate);
			return s;
		} catch (ParseException e) {
			// Auto-generated catch block

			throw e;
		}

	}

	public static void main(String[] args) {
		try {
			log.debug(Dateprocess.getTimeStr("yyyy-MM-dd"));
			log.debug(Dateprocess.getOhterDayByNumnber("2010-01-27", 5));
			log.debug(Dateprocess.compareDayStr("2010-01-27", "2010-01-3"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
