package word;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
public class insertbysort {
	/*通过正则表达式替换掉字符串中的一部分，比如换行，回车等
	 导出网页中大量用到
	 str_html = StringUtils.replace(str_html, "=/", "=./");
	 * */
	public static String replace(String src, String str_new,String str_regex){
		src=src.replaceAll("\r", "");
		src=src.replaceAll("\n", "");
		Pattern pattern = Pattern.compile(str_regex);
		Matcher matcher = pattern.matcher(src);	
		while (matcher.find()) {
			StringBuffer sbr = new StringBuffer();
				
		    matcher.appendReplacement(sbr, str_new); //替换后加上
		    //matcher.appendTail(sbr);
		    log.debug("插入文字"+sbr.toString());   
		    log.debug("插入图片");
		}
		
		String txt_last=StringUtils.substringAfterLast(src, "1");
		if(txt_last.length()>0)
		log.debug("插入最后的文字"+txt_last);
	
		//	log.debug(sbr.toString());
		return "";
	}
	public static void main(String[] args) throws IOException {
       log.debug(insertbysort.replace("1a 111b 1c 1d33331222", "", "1"));
	}

}
