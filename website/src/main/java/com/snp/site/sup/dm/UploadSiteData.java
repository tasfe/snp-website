package com.snp.site.sup.dm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork.ActionContext;
import com.snp.common.Compress;
import com.snp.site.config.LanmuConfig;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteAbout;
import com.snp.site.model.SiteAddress;
import com.snp.site.model.SiteGuest;
import com.snp.site.model.SiteJob;
import com.snp.site.model.SiteLink;
import com.snp.site.model.SitePresource;
import com.snp.site.model.SiteProduct;
import com.snp.site.model.SiteS1;
import com.snp.site.model.SiteS2;
import com.snp.site.model.SiteSpmp1;
import com.snp.site.model.SiteSpmp1Item;
import com.snp.site.model.SiteSpmp2;
import com.snp.site.model.SiteSpmp2Item;
import com.snp.site.model.SiteSpmp3;
import com.snp.site.model.SiteSpmp3Item;
import com.snp.site.model.SiteSpmp4;
import com.snp.site.model.SiteSpmp4Item;
import com.snp.site.model.SiteSpmp4Sub;
import com.snp.site.model.SiteSpmp5;
import com.snp.site.model.SiteSpmp5Item;
import com.snp.site.model.SiteSpmp6;
import com.snp.site.model.SiteSpmp6Item;
import com.snp.site.model.SiteSpmp8;
import com.snp.site.model.SiteSpmp9;
import com.snp.site.model.SiteSpmp9Item;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.error.OperationSystemException;
import com.sunrise.sup.core.common.util.ApplicationContextFactory;
import com.sunrise.sup.dm.IUploadFile;

public class UploadSiteData implements IUploadFile {
	private static Log log = LogFactory.getLog(UploadSiteData.class);
	private static String ADD_TIME_PREIFEX = "yes";
	private static String RENAME_BY_ONLYTIME = "bytime";
	private String uploadFileName;
	private String fileName;
	private String saveName; //
	private String saveFolder; //
	private String filepath;
	private String docroot = "doc_root";
	private String size;
	private String subdir;
	private String timeprefix = ADD_TIME_PREIFEX; //
	private String rename;
	private String op = "alldata"; //
	private long fileLength;
	private String fileContentType;

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public long getFileLength() {
		return fileLength;
	}

	public void setFileLength(long fileLength) {
		this.fileLength = fileLength;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSaveFolder() {

		return saveFolder;
	}

	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}

	public String getSaveName() {
		if (StringUtils.trimToNull(saveName) == null) {
			saveName = new SimpleDateFormat("yyyyMMddHHmmss.SS")
					.format(new Date()) + "." + this.getFileName();
		}
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;

	}

	public String getFilepath() {

		return filepath;
	}

	public void setFilepath(String filepath) {
		if (subdir != null) {

			try {
				FileUtils
						.forceMkdir(new File(SystemInit.getSiteHome() + subdir));
			} catch (IOException e) {

				e.printStackTrace();
			}
			if (rename == null) {
				this.filepath = subdir + getFileName();
				return;
			}
			if (rename.equals(RENAME_BY_ONLYTIME))
				this.filepath = subdir + getNewFileNameByTime();

		}

	}

	public void saveFile(File file) throws OperationException {
		try {
			String writeFilePath = SystemInit.getSiteHome() + getFilepath();
			FileInputStream filein = new FileInputStream(file);
			File fileOut = new File(writeFilePath);
			FileOutputStream fileOutput = new FileOutputStream(fileOut);
			byte[] bytes = new byte[1024];
			int c = 0;
			while ((c = filein.read(bytes)) != -1) {
				fileOutput.write(bytes, 0, c);
			}
			fileOutput.flush();
			fileOutput.close();
			filein.close();
			// 得到该ZIP的路径后，先解压到目录，然后删除ZIP 不要重新命名，先上传上来
			// Compress.unpack(fileOut.getAbsolutePath(),
			// SystemInit.getSiteHome()+subdir);
			Map sessionMap = ActionContext.getContext().getSession();
			AdvanceDAO adao = (AdvanceDAO) ApplicationContextFactory
					.getWebAppContext().getBean("advanceDAO");
			// 要用加载的方式，直接这种方式是有问题的：siteUser=(SiteUser)sessionMap.get(SystemInit.clientloginflag);
			SiteUser current_user = (SiteUser) sessionMap
					.get(SystemInit.clientloginflag);
			SiteUser siteUser = (SiteUser) adao.loadById("SiteUser",
					current_user.getId());
			String userhome = SystemInit.getSiteHome() + siteUser.getUsername();
			ImportData(adao, fileOut, siteUser, getOp());
			try {
				FileUtils.forceDelete(fileOut);
			} catch (Exception e) {
				log.error("上传的包不能删除，可能上传过程中，改文件被打开了"
						+ fileOut.getAbsolutePath());
				e.printStackTrace();
			}

		} catch (Exception e) {

			OperationException opEx = new OperationSystemException(
					"uploadfile error", e);
			throw opEx;
		}

	}

	public String getNewFileNameByTime() {
		String newfilename = (new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date()) + "." + StringUtils.substringAfter(
				getFileName(), "."));
		// setFileName(newfilename);
		return newfilename;
	}

	public String getRename() {
		return rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSubdir() {
		return subdir;
	}

	public void setSubdir(String subdir) {
		this.subdir = subdir;
	}

	public String getDocroot() {
		return docroot;
	}

	public void setDocroot(String docroot) {
		this.docroot = docroot;
	}

	public String getTimeprefix() {
		return timeprefix;
	}

	public void setTimeprefix(String timeprefix) {
		this.timeprefix = timeprefix;
	}

	public String getHeight() {
		// Auto-generated method stub
		return null;
	}

	public void setHeight(String height) {
		// Auto-generated method stub

	}

	public String getWidth() {
		// Auto-generated method stub
		return null;
	}

	public void setWidth(String width) {
		// Auto-generated method stub

	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public static void ImportData(AdvanceDAO adao, File file,
			SiteUser siteUser, String op) throws Exception {
		try {
			String selectUsername = siteUser.getUsername();
			String userhome = SystemInit.getSiteHome() + selectUsername + "/";
			FileUtils.forceMkdir(new File(SystemInit.getSiteHome()));
			FileUtils.forceMkdir(new File(userhome));
			try {
				if (op.equals("allsite") || op.equals("createnew"))
					Compress.unpack(file.getAbsolutePath(), userhome);
				else {
					Compress.unpack_no_config(file.getAbsolutePath(), userhome);
				}

			} catch (Exception e) {
				throw e;
			}
			String filename = userhome
					+ StringUtils.substringBefore(file.getName(), ".") + ".dat";
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					filename));
			SiteUser importUser = (SiteUser) in.readObject();// 备份的数据
			in.close();
			String newname = siteUser.getUsername();
			String newpassword = siteUser.getPassword();
			String oldUserName = "/" + importUser.getUsername() + "/";
			String newUserName = "/" + siteUser.getUsername() + "/";
			try {
				Set about = importUser.getSiteAbouts();
				for (Iterator iter = about.iterator(); iter.hasNext();) {
					SiteAbout siteAbout = (SiteAbout) iter.next();
					siteAbout.setSiteUser(siteUser);

					if (siteAbout.getFilepath() != null
							&& siteAbout.getFilepath().contains("/")) {
						siteAbout.setFilepath(StringUtils.substringAfterLast(
								siteAbout.getFilepath(), "/"));
					}
					siteAbout.setDetail(StringUtils.replace(
							siteAbout.getDetail(), "/resself/", "../../site/"
									+ newUserName + "/"));
					siteAbout.setDetail2(StringUtils.replace(
							siteAbout.getDetail2(), "/resself/", "../../site/"
									+ newUserName + "/"));
					siteAbout.setDetail3(StringUtils.replace(
							siteAbout.getDetail2(), "/resself/", "../../site/"
									+ newUserName + "/"));

					adao.saveObject(siteAbout);

				}
				Set guest = importUser.getSiteGuests();
				for (Iterator iter = guest.iterator(); iter.hasNext();) {
					SiteGuest siteGuest = (SiteGuest) iter.next();
					siteGuest.setSiteUser(siteUser);

					adao.saveObject(siteGuest);
				}

				Set job = importUser.getSiteJobs();
				for (Iterator iter = job.iterator(); iter.hasNext();) {
					SiteJob siteJob = (SiteJob) iter.next();
					siteJob.setSiteUser(siteUser);
					if (siteJob.getFilepath() != null
							&& siteJob.getFilepath().contains("/")) {
						siteJob.setFilepath(StringUtils.substringAfterLast(
								siteJob.getFilepath(), "/"));
					}

					siteJob.setDetail(StringUtils.replace(siteJob.getDetail(),
							"/resself/", "../../site/" + newUserName + "/"));
					siteJob.setDetail2(StringUtils.replace(
							siteJob.getDetail2(), "/resself/", "../../site/"
									+ newUserName + "/"));
					siteJob.setDetail3(StringUtils.replace(
							siteJob.getDetail2(), "/resself/", "../../site/"
									+ newUserName + "/"));
					adao.saveObject(siteJob);
				}
				Set s1 = importUser.getSiteS1s();
				for (Iterator iter = s1.iterator(); iter.hasNext();) {
					SiteS1 sites1 = (SiteS1) iter.next();
					sites1.setSiteUser(siteUser);
					if (sites1.getFilepath() != null
							&& sites1.getFilepath().contains("/")) {
						sites1.setFilepath(StringUtils.substringAfterLast(
								sites1.getFilepath(), "/"));
					}
					sites1.setSiteUser(siteUser);
					sites1.setDetail(StringUtils.replace(sites1.getDetail(),
							"/resself/", "../../site/" + newUserName + "/"));
					sites1.setDetail2(StringUtils.replace(sites1.getDetail2(),
							"/resself/", "../../site/" + newUserName + "/"));
					sites1.setDetail3(StringUtils.replace(sites1.getDetail2(),
							"/resself/", "../../site/" + newUserName + "/"));
					adao.saveObject(sites1);
				}
				Set s2 = importUser.getSiteS2s();
				for (Iterator iter = s2.iterator(); iter.hasNext();) {
					SiteS2 sites2 = (SiteS2) iter.next();
					if (sites2.getFilepath() != null
							&& sites2.getFilepath().contains("/")) {
						sites2.setFilepath(StringUtils.substringAfterLast(
								sites2.getFilepath(), "/"));
					}
					sites2.setSiteUser(siteUser);
					sites2.setDetail(StringUtils.replace(sites2.getDetail(),
							"/resself/", "../../site/" + newUserName + "/"));
					sites2.setDetail2(StringUtils.replace(sites2.getDetail2(),
							"/resself/", "../../site/" + newUserName + "/"));
					sites2.setDetail3(StringUtils.replace(sites2.getDetail2(),
							"/resself/", "../../site/" + newUserName + "/"));
					adao.saveObject(sites2);
				}

				Set link = importUser.getSiteLinks();
				for (Iterator iter = link.iterator(); iter.hasNext();) {
					SiteLink siteLink = (SiteLink) iter.next();
					siteLink.setSiteUser(siteUser);
					siteLink.setFilepath(StringUtils.replace(
							siteLink.getFilepath(), oldUserName, newUserName));
					if (siteLink.getFilepath() != null
							&& siteLink.getFilepath().contains("/")) {
						siteLink.setFilepath(StringUtils.substringAfterLast(
								siteLink.getFilepath(), "/"));
					}
					siteLink.setDetail(StringUtils.replace(
							siteLink.getDetail(), "/resself/", "../../site/"
									+ newUserName + "/"));
					siteLink.setDetail2(StringUtils.replace(
							siteLink.getDetail2(), "/resself/", "../../site/"
									+ newUserName + "/"));
					siteLink.setDetail3(StringUtils.replace(
							siteLink.getDetail2(), "/resself/", "../../site/"
									+ newUserName + "/"));
					adao.saveObject(siteLink);
				}

				Set address = importUser.getSiteAddresss();
				for (Iterator iter = address.iterator(); iter.hasNext();) {
					SiteAddress siteAddress = (SiteAddress) iter.next();
					siteAddress.setSiteUser(siteUser);
					if (siteAddress.getFilepath() != null
							&& siteAddress.getFilepath().contains("/")) {
						siteAddress.setFilepath(StringUtils.substringAfterLast(
								siteAddress.getFilepath(), "/"));
					}
					siteAddress.setDetail(StringUtils.replace(
							siteAddress.getDetail(), "/resself/", "../../site/"
									+ newUserName + "/"));
					siteAddress.setDetail2(StringUtils.replace(
							siteAddress.getDetail2(), "/resself/",
							"../../site/" + newUserName + "/"));
					siteAddress.setDetail3(StringUtils.replace(
							siteAddress.getDetail2(), "/resself/",
							"../../site/" + newUserName + "/"));
					adao.saveObject(siteAddress);
				}

				Set spmp8 = importUser.getSiteSpmp8s();
				for (Iterator iter = spmp8.iterator(); iter.hasNext();) {
					SiteSpmp8 oldsiteSpmp8 = (SiteSpmp8) iter.next();
					SiteSpmp8 siteSpmp8 = new SiteSpmp8();
					BeanUtils.copyProperties(siteSpmp8, oldsiteSpmp8);
					siteSpmp8.setSiteSpmp8Items(null);
					siteSpmp8.setSiteUser(siteUser);
					if (siteSpmp8.getFilepath() != null
							&& siteSpmp8.getFilepath().contains("/")) {
						siteSpmp8.setFilepath(StringUtils.substringAfterLast(
								siteSpmp8.getFilepath(), "/"));
					}
					siteSpmp8.setDetail(StringUtils.replace(
							siteSpmp8.getDetail(), "/resself/", "../../site/"
									+ newUserName + "/"));
					siteSpmp8.setDetail2(StringUtils.replace(
							siteSpmp8.getDetail2(), "/resself/", "../../site/"
									+ newUserName + "/"));
					siteSpmp8.setDetail3(StringUtils.replace(
							siteSpmp8.getDetail2(), "/resself/", "../../site/"
									+ newUserName + "/"));
					adao.saveObject(siteSpmp8);
					adao.saveObject(siteSpmp8);

				}

				Set presource = importUser.getSitePresources();
				for (Iterator iter = presource.iterator(); iter.hasNext();) {
					SitePresource sitePresource = (SitePresource) iter.next();
					sitePresource.setSiteUser(siteUser);
					if (sitePresource.getFilepath() != null
							&& sitePresource.getFilepath().contains("/")) {
						sitePresource.setFilepath(StringUtils
								.substringAfterLast(
										sitePresource.getFilepath(), "/"));
					}

					adao.saveObject(sitePresource);
				}

				Set spmp1 = importUser.getSiteSpmp1s();
				for (Iterator iter = spmp1.iterator(); iter.hasNext();) {
					SiteSpmp1 oldsiteSpmp1 = (SiteSpmp1) iter.next();
					SiteSpmp1 siteSpmp1 = new SiteSpmp1();
					BeanUtils.copyProperties(siteSpmp1, oldsiteSpmp1);
					siteSpmp1.setSiteSpmp1Items(null);
					siteSpmp1.setSiteUser(siteUser);
					adao.saveObject(siteSpmp1);
					for (Iterator iter2 = oldsiteSpmp1.getSiteSpmp1Items()
							.iterator(); iter2.hasNext();) {
						SiteSpmp1Item siteSpmp1Item = (SiteSpmp1Item) iter2
								.next();
						siteSpmp1Item.setSiteSpmp1(siteSpmp1);
						if (siteSpmp1Item.getFilepath() != null
								&& siteSpmp1Item.getFilepath().contains("/")) {
							siteSpmp1Item.setFilepath(StringUtils
									.substringAfterLast(
											siteSpmp1Item.getFilepath(), "/"));
						}
						siteSpmp1Item.setDetail(StringUtils.replace(
								siteSpmp1Item.getDetail(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp1Item.setDetail2(StringUtils.replace(
								siteSpmp1Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp1Item.setDetail3(StringUtils.replace(
								siteSpmp1Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						adao.saveObject(siteSpmp1Item);
					}
				}

				Set spmp2 = importUser.getSiteSpmp2s();
				for (Iterator iter = spmp2.iterator(); iter.hasNext();) {
					SiteSpmp2 oldsiteSpmp2 = (SiteSpmp2) iter.next();
					SiteSpmp2 siteSpmp2 = new SiteSpmp2();
					BeanUtils.copyProperties(siteSpmp2, oldsiteSpmp2);
					siteSpmp2.setSiteSpmp2Items(null);
					siteSpmp2.setSiteUser(siteUser);
					adao.saveObject(siteSpmp2);
					for (Iterator iter2 = oldsiteSpmp2.getSiteSpmp2Items()
							.iterator(); iter2.hasNext();) {
						SiteSpmp2Item siteSpmp2Item = (SiteSpmp2Item) iter2
								.next();
						siteSpmp2Item.setSiteSpmp2(siteSpmp2);
						if (siteSpmp2Item.getFilepath() != null
								&& siteSpmp2Item.getFilepath().contains("/")) {
							siteSpmp2Item.setFilepath(StringUtils
									.substringAfterLast(
											siteSpmp2Item.getFilepath(), "/"));
						}
						siteSpmp2Item.setDetail(StringUtils.replace(
								siteSpmp2Item.getDetail(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp2Item.setDetail2(StringUtils.replace(
								siteSpmp2Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp2Item.setDetail3(StringUtils.replace(
								siteSpmp2Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						adao.saveObject(siteSpmp2Item);
					}
				}
				Set spmp3 = importUser.getSiteSpmp3s();
				for (Iterator iter = spmp3.iterator(); iter.hasNext();) {
					SiteSpmp3 oldsiteSpmp3 = (SiteSpmp3) iter.next();
					SiteSpmp3 siteSpmp3 = new SiteSpmp3();
					BeanUtils.copyProperties(siteSpmp3, oldsiteSpmp3);
					siteSpmp3.setSiteSpmp3Items(null);
					siteSpmp3.setSiteUser(siteUser);
					adao.saveObject(siteSpmp3);
					for (Iterator iter2 = oldsiteSpmp3.getSiteSpmp3Items()
							.iterator(); iter2.hasNext();) {
						SiteSpmp3Item siteSpmp3Item = (SiteSpmp3Item) iter2
								.next();
						siteSpmp3Item.setSiteSpmp3(siteSpmp3);
						if (siteSpmp3Item.getFilepath() != null
								&& siteSpmp3Item.getFilepath().contains("/")) {
							siteSpmp3Item.setFilepath(StringUtils
									.substringAfterLast(
											siteSpmp3Item.getFilepath(), "/"));
						}
						siteSpmp3Item.setDetail(StringUtils.replace(
								siteSpmp3Item.getDetail(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp3Item.setDetail2(StringUtils.replace(
								siteSpmp3Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp3Item.setDetail3(StringUtils.replace(
								siteSpmp3Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						adao.saveObject(siteSpmp3Item);
					}
				}
				Set spmp6 = importUser.getSiteSpmp6s();
				for (Iterator iter = spmp6.iterator(); iter.hasNext();) {
					SiteSpmp6 oldsiteSpmp6 = (SiteSpmp6) iter.next();
					SiteSpmp6 siteSpmp6 = new SiteSpmp6();
					BeanUtils.copyProperties(siteSpmp6, oldsiteSpmp6);
					siteSpmp6.setSiteSpmp6Items(null);
					siteSpmp6.setSiteUser(siteUser);
					adao.saveObject(siteSpmp6);
					for (Iterator iter2 = oldsiteSpmp6.getSiteSpmp6Items()
							.iterator(); iter2.hasNext();) {
						SiteSpmp6Item siteSpmp6Item = (SiteSpmp6Item) iter2
								.next();
						siteSpmp6Item.setSiteSpmp6(siteSpmp6);
						if (siteSpmp6Item.getFilepath() != null
								&& siteSpmp6Item.getFilepath().contains("/")) {
							siteSpmp6Item.setFilepath(StringUtils
									.substringAfterLast(
											siteSpmp6Item.getFilepath(), "/"));
						}
						siteSpmp6Item.setDetail(StringUtils.replace(
								siteSpmp6Item.getDetail(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp6Item.setDetail2(StringUtils.replace(
								siteSpmp6Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp6Item.setDetail3(StringUtils.replace(
								siteSpmp6Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						adao.saveObject(siteSpmp6Item);
					}
				}
				Set spmp9 = importUser.getSiteSpmp9s();
				for (Iterator iter = spmp9.iterator(); iter.hasNext();) {
					SiteSpmp9 oldsiteSpmp9 = (SiteSpmp9) iter.next();
					SiteSpmp9 siteSpmp9 = new SiteSpmp9();
					BeanUtils.copyProperties(siteSpmp9, oldsiteSpmp9);
					siteSpmp9.setSiteSpmp9Items(null);
					siteSpmp9.setSiteUser(siteUser);
					adao.saveObject(siteSpmp9);
					for (Iterator iter2 = oldsiteSpmp9.getSiteSpmp9Items()
							.iterator(); iter2.hasNext();) {
						SiteSpmp9Item siteSpmp9Item = (SiteSpmp9Item) iter2
								.next();
						siteSpmp9Item.setSiteSpmp9(siteSpmp9);
						if (siteSpmp9Item.getFilepath() != null
								&& siteSpmp9Item.getFilepath().contains("/")) {
							siteSpmp9Item.setFilepath(StringUtils
									.substringAfterLast(
											siteSpmp9Item.getFilepath(), "/"));
						}
						siteSpmp9Item.setDetail(StringUtils.replace(
								siteSpmp9Item.getDetail(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp9Item.setDetail2(StringUtils.replace(
								siteSpmp9Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp9Item.setDetail3(StringUtils.replace(
								siteSpmp9Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						adao.saveObject(siteSpmp9Item);
					}
				}

				Set spmp4 = importUser.getSiteSpmp4s();
				for (Iterator iter = spmp4.iterator(); iter.hasNext();) {
					SiteSpmp4 oldsiteSpmp4 = (SiteSpmp4) iter.next();
					SiteSpmp4 siteSpmp4 = new SiteSpmp4();
					BeanUtils.copyProperties(siteSpmp4, oldsiteSpmp4);
					siteSpmp4.setSiteSpmp4Items(null); // 关键代码在这里,先让父亲表为空
					siteSpmp4.setSiteSpmp4Subs(null);
					siteSpmp4.setSiteUser(siteUser);

					adao.saveObject(siteSpmp4);
					/*
					 * 因为4下面还有特殊的产品数据，所以这样保存也是不行的cascade="all-delete-orphan"
					 * <one-to-many class="com.snp.site.model.SiteProduct"/>
					 */

					for (Iterator iter4 = oldsiteSpmp4.getSiteSpmp4Items()
							.iterator(); iter4.hasNext();) {
						SiteSpmp4Item oldsiteSpmp4Item = (SiteSpmp4Item) iter4
								.next();
						SiteSpmp4Item siteSpmp4Item = new SiteSpmp4Item();
						BeanUtils.copyProperties(siteSpmp4Item,
								oldsiteSpmp4Item);
						siteSpmp4Item.setSiteSpmp4(siteSpmp4);
						siteSpmp4Item.setSiteProducts(null);
						if (siteSpmp4Item.getFilepath() != null
								&& siteSpmp4Item.getFilepath().contains("/")) {
							siteSpmp4Item.setFilepath(StringUtils
									.substringAfterLast(
											siteSpmp4Item.getFilepath(), "/"));
						}
						adao.saveObject(siteSpmp4Item);
						for (Iterator iterator_p = oldsiteSpmp4Item
								.getSiteProducts().iterator(); iterator_p
								.hasNext();) {
							SiteProduct siteProduct = (SiteProduct) iterator_p
									.next();
							if (siteProduct.getFilepath().contains("/")) {
								siteProduct
										.setFilepath(StringUtils
												.substringAfterLast(siteProduct
														.getFilepath(), "/"));
							}
							siteProduct.setSiteSpmp4Item(siteSpmp4Item);
							adao.saveObject(siteProduct);
						}
					}
					/*
					 * 子类别
					 */
					for (Iterator iter5 = oldsiteSpmp4.getSiteSpmp4Subs()
							.iterator(); iter5.hasNext();) {
						SiteSpmp4Sub oldsiteSpmp4Sub = (SiteSpmp4Sub) iter5
								.next();
						SiteSpmp4Sub siteSpmp4Sub = new SiteSpmp4Sub();
						BeanUtils.copyProperties(siteSpmp4Sub, oldsiteSpmp4Sub);
						siteSpmp4Sub.setSiteSpmp4(siteSpmp4);
						adao.saveObject(siteSpmp4Sub);

					}
				}

				Set spmp5 = importUser.getSiteSpmp5s();
				for (Iterator iter = spmp5.iterator(); iter.hasNext();) {
					SiteSpmp5 oldsiteSpmp5 = (SiteSpmp5) iter.next();
					SiteSpmp5 siteSpmp5 = new SiteSpmp5();
					BeanUtils.copyProperties(siteSpmp5, oldsiteSpmp5);
					siteSpmp5.setSiteSpmp5Items(null);
					siteSpmp5.setSiteUser(siteUser);

					adao.saveObject(siteSpmp5);
					for (Iterator iter5 = oldsiteSpmp5.getSiteSpmp5Items()
							.iterator(); iter5.hasNext();) {
						SiteSpmp5Item siteSpmp5Item = (SiteSpmp5Item) iter5
								.next();
						siteSpmp5Item.setSiteSpmp5(siteSpmp5);
						if (siteSpmp5Item.getFilepath() != null
								&& siteSpmp5Item.getFilepath().contains("/")) {
							siteSpmp5Item.setFilepath(StringUtils
									.substringAfterLast(
											siteSpmp5Item.getFilepath(), "/"));
						}
						siteSpmp5Item.setDetail(StringUtils.replace(
								siteSpmp5Item.getDetail(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp5Item.setDetail2(StringUtils.replace(
								siteSpmp5Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						siteSpmp5Item.setDetail3(StringUtils.replace(
								siteSpmp5Item.getDetail2(), "/resself/",
								"../../site/" + newUserName + "/"));
						adao.saveObject(siteSpmp5Item);
					}
				}

			} catch (Exception e) {
				e.printStackTrace(); // 如果这里不加异常捕捉，会导致推出，这样下面用户的属性保存无法运行，
			}

			siteUser.setIndexStyle(importUser.getIndexStyle());
			siteUser.setDirStyle(importUser.getDirStyle());
			siteUser.setCssStyle(importUser.getCssStyle());
			siteUser.setLanguage(importUser.getLanguage());
			siteUser.setLanguage2(importUser.getLanguage2());
			siteUser.setLanguage3(importUser.getLanguage3());

			siteUser.setLocal(importUser.getLocal());
			siteUser.setLocal2(importUser.getLocal2());
			siteUser.setLocal3(importUser.getLocal3());

			siteUser.setTitle(StringUtils.replace(importUser.getTitle(),
					"/resself", "../../site" + newUserName));
			siteUser.setBottom(StringUtils.replace(importUser.getBottom(),
					"/resself", "../../site" + newUserName));
			siteUser.setContentleft(StringUtils.replace(
					importUser.getContentleft(), "/resself", "../../site"
							+ newUserName));
			siteUser.setContentright(StringUtils.replace(
					importUser.getContentright(), "/resself", "../../site"
							+ newUserName));

			siteUser.setIndexDesc(StringUtils.replace(
					importUser.getIndexDesc(), "/resself", "../../site"
							+ newUserName));
			siteUser.setIndexDesc2(StringUtils.replace(
					importUser.getIndexDesc2(), "/resself", "../../site"
							+ newUserName));
			siteUser.setIndexDesc3(StringUtils.replace(
					importUser.getIndexDesc3(), "/resself", "../../site"
							+ newUserName));

			siteUser.setGuestDesc(StringUtils.replace(
					importUser.getGuestDesc(), "/resself", "../../site"
							+ newUserName));

			siteUser.setCheckDesc(StringUtils.replace(
					importUser.getCheckDesc(), "/resself", "../../site"
							+ newUserName));

			siteUser.setMarquee(StringUtils.replace(importUser.getMarquee(),
					"/resself", "../../site" + newUserName));
			siteUser.setMarquee2(StringUtils.replace(importUser.getMarquee2(),
					"/resself", "../../site" + newUserName));
			siteUser.setMarquee3(StringUtils.replace(importUser.getMarquee3(),
					"/resself", "../../site" + newUserName));
			siteUser.setS1Lanmu(importUser.getS1Lanmu());
			siteUser.setS1Lanmu2(importUser.getS1Lanmu2());
			siteUser.setS1Lanmu3(importUser.getS1Lanmu3());

			siteUser.setS2Lanmu(importUser.getS2Lanmu());
			siteUser.setS2Lanmu2(importUser.getS2Lanmu2());
			siteUser.setS2Lanmu3(importUser.getS2Lanmu3());

			siteUser.setGuestLanmu(importUser.getGuestLanmu());
			siteUser.setGuestLanmu2(importUser.getGuestLanmu2());
			siteUser.setGuestLanmu3(importUser.getGuestLanmu3());

			siteUser.setIndexLanmu(importUser.getIndexLanmu());
			siteUser.setIndexLanmu2(importUser.getIndexLanmu2());
			siteUser.setIndexLanmu3(importUser.getIndexLanmu3());

			siteUser.setJobLanmu(importUser.getJobLanmu());
			siteUser.setJobLanmu2(importUser.getJobLanmu2());
			siteUser.setJobLanmu3(importUser.getJobLanmu3());

			siteUser.setAddressLanmu(importUser.getAddressLanmu());
			siteUser.setAddressLanmu2(importUser.getAddressLanmu2());
			siteUser.setAddressLanmu3(importUser.getAddressLanmu3());

			siteUser.setCheckLanmu(importUser.getCheckLanmu());
			siteUser.setCheckLanmu2(importUser.getCheckLanmu2());
			siteUser.setCheckLanmu3(importUser.getCheckLanmu3());

			siteUser.setSpmp1Lanmu(importUser.getSpmp1Lanmu());
			siteUser.setSpmp1Lanmu2(importUser.getSpmp1Lanmu2());
			siteUser.setSpmp1Lanmu3(importUser.getSpmp1Lanmu3());

			siteUser.setSpmp2Lanmu(importUser.getSpmp2Lanmu());
			siteUser.setSpmp2Lanmu2(importUser.getSpmp2Lanmu2());
			siteUser.setSpmp2Lanmu3(importUser.getSpmp2Lanmu3());

			siteUser.setSpmp3Lanmu(importUser.getSpmp3Lanmu());
			siteUser.setSpmp3Lanmu2(importUser.getSpmp3Lanmu2());
			siteUser.setSpmp3Lanmu3(importUser.getSpmp3Lanmu3());

			siteUser.setSpmp4Lanmu(importUser.getSpmp4Lanmu());
			siteUser.setSpmp4Lanmu2(importUser.getSpmp4Lanmu2());
			siteUser.setSpmp4Lanmu3(importUser.getSpmp4Lanmu3());

			siteUser.setSpmp5Lanmu(importUser.getSpmp5Lanmu());
			siteUser.setSpmp5Lanmu2(importUser.getSpmp5Lanmu2());
			siteUser.setSpmp5Lanmu3(importUser.getSpmp5Lanmu3());

			siteUser.setSpmp6Lanmu(importUser.getSpmp6Lanmu());
			siteUser.setSpmp6Lanmu2(importUser.getSpmp6Lanmu2());
			siteUser.setSpmp6Lanmu3(importUser.getSpmp6Lanmu3());

			siteUser.setSpmp7Lanmu(importUser.getSpmp7Lanmu());
			siteUser.setSpmp7Lanmu2(importUser.getSpmp7Lanmu2());
			siteUser.setSpmp7Lanmu3(importUser.getSpmp7Lanmu3());

			siteUser.setSpmp8Lanmu(importUser.getSpmp8Lanmu());
			siteUser.setSpmp8Lanmu2(importUser.getSpmp8Lanmu2());
			siteUser.setSpmp8Lanmu3(importUser.getSpmp8Lanmu3());

			adao.updateObject(siteUser);
			if (!op.equals("createnew")) {// 新建用户，是没有这个文件的，
				SiteUser siteuser = (SiteUser) ActionContext.getContext()
						.getSession().get(SystemInit.clientloginflag);
				String userLunmuXmlPath = SystemInit.getSiteHome()
						+ siteuser.getUsername() + "/"
						+ SystemInit.LanmuConfFileName;

				LanmuConfig lanmuObject = SystemInit
						.getLanmuObjectFromXml(userLunmuXmlPath);
				ActionContext.getContext().getSession()
						.put("lanmuobject", lanmuObject);
			}

		} catch (Exception e) {
			throw e;

		}

	}
}
