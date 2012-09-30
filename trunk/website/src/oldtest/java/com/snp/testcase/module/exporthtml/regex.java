package com.snp.testcase.module.exporthtml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

import com.snp.testcase.common.EnvTest;

public class regex extends EnvTest {

	public static List getlistbyPerl(String strClean, String strReg,
			String strvarreg) throws IOException, MalformedPatternException {
		PatternMatcher matcher;
		PatternCompiler compiler;
		org.apache.oro.text.regex.Pattern pattern;
		PatternMatcherInput input;
		MatchResult result;
		compiler = new Perl5Compiler();
		matcher = new Perl5Matcher();
		List rslList = new ArrayList();
		String[] varreg = StringUtils.split(strvarreg, ';');// 代表
		pattern = compiler.compile(strReg, Perl5Compiler.CASE_INSENSITIVE_MASK);

		input = new PatternMatcherInput(strClean);
		while (matcher.contains(input, pattern)) {
			result = matcher.getMatch();
			log.debug("find one");
			GetObject item = new GetObject();
			// date;title;url;address;ext;
			if (!varreg[0].equals("no"))
				
				item.a0 = result.group(Integer.parseInt(varreg[0]));
			    log.debug(item.a0);

			if (!varreg[1].equals("no"))
				item.a1 = StringUtils.deleteWhitespace(result.group(Integer
						.parseInt(varreg[1])));

			if (!varreg[2].equals("no"))
				item.a2 = StringUtils.deleteWhitespace(result.group(Integer
						.parseInt(varreg[2])));

			if (!varreg[3].equals("no"))
				item.a3 = StringUtils.deleteWhitespace(result.group(Integer
						.parseInt(varreg[3])));
			if (!varreg[4].equals("no"))
				item.a4 = StringUtils.deleteWhitespace(result.group(Integer
						.parseInt(varreg[4])));
			if (!varreg[5].equals("no"))
				item.a5 = StringUtils.deleteWhitespace(result.group(Integer
						.parseInt(varreg[5])));
			if (!varreg[6].equals("no"))
				item.a6 = StringUtils.deleteWhitespace(result.group(Integer
						.parseInt(varreg[6])));
			if (!varreg[7].equals("no"))
				item.a7 = StringUtils.deleteWhitespace(result.group(Integer
						.parseInt(varreg[7])));

			// groups = result.groups();
			rslList.add(item);
		}

		return rslList;
	}
	public void simple(){
		String str = "10元 1000人民\n币 10000元 100000RMB";
   	    str = str.replaceAll("(\\d+)(元|人民币|RMB)", "$1￥");	
   	    log.debug(str);
	}
	public void simple2() throws IOException{
		String str = StringSourceFrom.getformfile(EnvTest.path_res+ "exporthtml/服务介绍_1内训.html");
		str=str.replaceAll("\n", "");
        log.debug(str.replaceAll("\n", ""));
		boolean result = Pattern.matches("aaleftbegindfdd","leftbegin");
		log.debug(result);
		// str = str.replaceAll("(.*?)<!--leftbegin-->.*?<!--leftend-->(.*?)", "$1$2");	
		 //str = "10元 1000人民币 10000元 2222RMB";
	   	 // str = str.replaceAll("(.*?)1000(.*?)10000(.*?)", "$1奇怪$2");	
   	    //log.debug(str);
	}	
	public void test_simple3() throws IOException{
		Pattern pattern = Pattern.compile("<!--leftbegin-->.*?<!--leftend-->",Pattern.MULTILINE);
		
		  // 带"\n"“\r”回车符号在正则表达里就是有问题，所以要替换掉回车
		//Matcher matcher = pattern.matcher(" Hello World,\n <!--leftbegin-->\rdfsdfsdfsdfsdf<!--leftend--> Hello World ");
		Matcher matcher = pattern.matcher(" Hello World, <!--leftbegin-->\rdfsdfsdfsdfsdf<!--leftend--> Hello World ");
		StringBuffer sbr = new StringBuffer();
		while (matcher.find()) {
		    matcher.appendReplacement(sbr, "Java");
		}
		matcher.appendTail(sbr);
		log.debug(sbr.toString()+1);
	}	
	public void test_simple4() throws IOException{
		String str = StringSourceFrom.getformfile(EnvTest.path_res+ "exporthtml/服务介绍_1内训.html");
		str=str.replaceAll("\r", "");
		str=str.replaceAll("\n", "");
		Pattern pattern = Pattern.compile("<!--leftbegin-->.*?<!--leftend-->");
		
		Matcher matcher = pattern.matcher(str);
		StringBuffer sbr = new StringBuffer();
		while (matcher.find()) {
		    matcher.appendReplacement(sbr, "Java");
		}
		matcher.appendTail(sbr);
		log.debug(sbr.toString());
	}	
	/*我们的字符串中是有字符串和换行符号的*/
	public void simple5() throws IOException{
		String s = "\n   iii \n 44\r4";
		   String reg ="[\n-\r]";
		   Pattern p = Pattern.compile(reg);
		   Matcher m = p.matcher(s);
		   String beizhu = m.replaceAll("");
		   log.debug(s+":"+beizhu);
		   
			String str = StringSourceFrom.getformfile(EnvTest.path_res+ "exporthtml/服务介绍_1内训.html");
			str=str.replaceAll("\n", "");	
			str=str.replaceAll("\r", "");
			log.debug(str);
	}	
}
