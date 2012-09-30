package word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.Range;

public class img_get_diff {

	/**
	需要研究出怎么去除用截图工具复制进去的图片，不然只能用规则来进行排序
	1.	WordExtractor ex = new WordExtractor(is_txt);方式取不到整个复制进去的图片的原始数据txt
	2.尝试下用rang也取不到，*/
	public static void main(String[] args) throws IOException {

	//	InputStream is = new FileInputStream(new File("haierq5.doc"));
		InputStream is = new FileInputStream(new File("src\\try\\res\\乐趣Q5.doc"));
		
		HWPFDocument doc = new HWPFDocument(is);
		Range r = doc.getRange();

	
		for (int i = 0; i < r.numParagraphs(); i++) {
			log.debug(i+":"+ Range.stripFields(r.getParagraph(i).text()));
			
			//log.debug(i+":"+ r.getParagraph(i).text());
		}		
		
		/*
		WordExtractor ex = new WordExtractor(is);
		String text2003 = ex.getText();
		log.debug("=====原文=======\n"+text2003+"\n================");
		String[] textarray=StringUtils.split(StringRegex.replace(text2003, "||||", " INCLUDEPICTURE(.*?)"), "||||");
		for (int i = 0; i < textarray.length; i++) {
			log.debug("段落"+i+" : "+textarray[i]);
		}		
		is.close();
		*/
		is = new FileInputStream(new File("src\\try\\res\\乐趣Q5.doc"));
		 doc = new HWPFDocument(is);
		PicturesTable picB = doc.getPicturesTable();
		List picturesB = picB.getAllPictures();
		log.debug("图片张数：" + picturesB.size());	
		
		for (Iterator iterator = picturesB.iterator(); iterator.hasNext();) {
			Picture pic = (Picture) iterator.next();
			log.debug(pic.suggestFullFileName());
			FileOutputStream fileOutput = new FileOutputStream(new File(pic.suggestFullFileName()));
			pic.writeImageContent(fileOutput);
			fileOutput.close();
		}
		//将图片写入目录中
		
		
		/*
		 * String strvarreg = "1;2;3;4;5;6;7;8;"; String strReg = ":" + ip + ":"
		 * + "(.*?):(.*?):(.*?):(.*?):(.*?):(.*?):(.*?):"; List rslList = new
		 * ArrayList();
	
		String strvarreg = "1;2;3;4;5;6;7;8;";
		String strReg = " INCLUDEPICTURE(.*?)";

		List rslList = new ArrayList();
		rslList = StringbyPerlFreemark.getlistbyPerl(text2003, strReg,
				strvarreg);
		for (Iterator iterator = rslList.iterator(); iterator.hasNext();) {
			GetObject object = (GetObject) iterator.next();
			log.debug("--------解析后-------\n"+object.a0);
		}
			 */
		// str_html = StringUtils.replace(str_html, "=/", "=./");
	
		//log.debug(StringRegex.replace(text2003, "||||", " INCLUDEPICTURE(.*?)"));

	}

}
