package com.snp.common.freemarker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

import com.snp.common.regex.GetObject;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.SimpleHash;
import freemarker.template.Template;

public class FreemarkProcessor {
	public static void getfilebyFreemark(String savehtmlname,
			String templetpath, String Fltfilename, SimpleHash root)
			throws Exception {
		try {
			Configuration cfg = new Configuration();
			cfg.setDefaultEncoding("utf-8"); // 这个如果设置成utf-8代表该flt是utf8得，所以去掉
			cfg.setDirectoryForTemplateLoading(new File(templetpath));
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			Template temp = cfg.getTemplate(Fltfilename);
			Charset charset = Charset.forName("utf-8"); // 保存到本地的文件就是GBK，如果浏览起器打开就是正确的
			CharsetEncoder encoder = charset.newEncoder();

			Writer out = new OutputStreamWriter(new FileOutputStream(
					savehtmlname, false), encoder);

			temp.process(root, out);

			out.flush();
		} catch (Exception e) {

			throw e;
		}

	}

	public static List getlistbyPerl(String strClean, String strReg,
			String strvarreg) throws Exception {

		PatternMatcher matcher;
		PatternCompiler compiler;
		Pattern pattern = null;
		PatternMatcherInput input;
		MatchResult result;
		compiler = new Perl5Compiler();
		matcher = new Perl5Matcher();
		List rslList = new ArrayList();
		String[] varreg = StringUtils.split(strvarreg, ';');// 代表

		try {
			/*
			 * pattern = compiler.compile(strReg,
			 * Perl5Compiler.CASE_INSENSITIVE_MASK |
			 * Perl5Compiler.SINGLELINE_MASK);
			 */
			pattern = compiler.compile(strReg,
					Perl5Compiler.CASE_INSENSITIVE_MASK);
		} catch (MalformedPatternException e) {
			throw e;
		}
		input = new PatternMatcherInput(strClean);

		while (matcher.contains(input, pattern)) {
			result = matcher.getMatch();

			GetObject item = new GetObject();
			// date;title;url;address;ext;
			if (!varreg[0].equals("no"))
				item.a0 = result.group(Integer.parseInt(varreg[0]));

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

	public static void main(String[] args) throws Exception {
		/* Adjust the configuration */

	}

}
