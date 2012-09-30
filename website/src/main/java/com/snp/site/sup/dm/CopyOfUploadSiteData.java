/*
 * �������� 2005-5-7
 *
 */
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

import com.opensymphony.xwork.ActionContext;
import com.snp.common.Compress;
import com.snp.site.config.LanmuConfig;
import com.snp.site.init.SystemInit;
import com.snp.site.model.SiteAbout;
import com.snp.site.model.SiteAddress;
import com.snp.site.model.SiteGuest;
import com.snp.site.model.SiteJob;
import com.snp.site.model.SiteLink;
import com.snp.site.model.SiteOrderCheck;
import com.snp.site.model.SiteOrderCheckItem;
import com.snp.site.model.SiteOrderInput;
import com.snp.site.model.SiteOrderRadio;
import com.snp.site.model.SiteOrderRadioItem;
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
import com.snp.site.model.SiteSpmp7;
import com.snp.site.model.SiteSpmp7Item;
import com.snp.site.model.SiteSpmp8;
import com.snp.site.model.SiteSpmp8Item;
import com.snp.site.model.SiteSpmp9;
import com.snp.site.model.SiteSpmp9Item;
import com.snp.site.model.SiteSuser;
import com.snp.site.model.SiteSuserItem;
import com.snp.site.model.SiteUser;
import com.sunrise.sup.core.common.dao.hibernate.AdvanceDAO;
import com.sunrise.sup.core.common.error.OperationException;
import com.sunrise.sup.core.common.error.OperationSystemException;
import com.sunrise.sup.core.common.util.ApplicationContextFactory;
import com.sunrise.sup.dm.IUploadFile;

/**
 * @author Jerry Tang
 * @version v1.0.0
 */
public class CopyOfUploadSiteData implements IUploadFile {
	private static String ADD_TIME_PREIFEX = "yes";
	private static String RENAME_BY_ONLYTIME = "bytime";

	private String uploadFileName;
	private String fileName; // �ļ���
	private String saveName; //
	private String saveFolder; //

	private String filepath;
	private String docroot = "doc_root";
	private String size;
	private String subdir;
	private String timeprefix = ADD_TIME_PREIFEX; //
	private String rename; // �������������÷���
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

	// �ļ������·��
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
			File temp = new File(userhome + "/resself");
			if (temp.exists()) {
				FileUtils.copyDirectory(new File(userhome + "/resself"),
						new File(SystemInit.getWebroot() + "resself"));
			}
			FileUtils.forceDelete(fileOut);

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
					siteAbout.setFilepath(StringUtils.replace(
							siteAbout.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteAbout);

				}
				Set guest = importUser.getSiteGuests();
				for (Iterator iter = guest.iterator(); iter.hasNext();) {
					SiteGuest siteGuest = (SiteGuest) iter.next();
					siteGuest.setSiteUser(siteUser);
					siteGuest.setFilepath(StringUtils.replace(
							siteGuest.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteGuest);
				}

				Set job = importUser.getSiteJobs();
				for (Iterator iter = job.iterator(); iter.hasNext();) {
					SiteJob siteJob = (SiteJob) iter.next();
					siteJob.setSiteUser(siteUser);
					siteJob.setFilepath(StringUtils.replace(
							siteJob.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteJob);
				}
				Set s1 = importUser.getSiteS1s();
				for (Iterator iter = s1.iterator(); iter.hasNext();) {
					SiteS1 sites1 = (SiteS1) iter.next();
					sites1.setSiteUser(siteUser);
					sites1.setFilepath(StringUtils.replace(
							sites1.getFilepath(), oldUserName, newUserName));
					adao.saveObject(sites1);
				}
				Set s2 = importUser.getSiteS2s();
				for (Iterator iter = s2.iterator(); iter.hasNext();) {
					SiteS2 sites2 = (SiteS2) iter.next();
					sites2.setFilepath(StringUtils.replace(
							sites2.getFilepath(), oldUserName, newUserName));
					sites2.setSiteUser(siteUser);
					adao.saveObject(sites2);
				}

				Set link = importUser.getSiteLinks();
				for (Iterator iter = link.iterator(); iter.hasNext();) {
					SiteLink siteLink = (SiteLink) iter.next();
					siteLink.setSiteUser(siteUser);
					siteLink.setFilepath(StringUtils.replace(
							siteLink.getFilepath(), oldUserName, newUserName));

					adao.saveObject(siteLink);
				}

				Set address = importUser.getSiteAddresss();
				for (Iterator iter = address.iterator(); iter.hasNext();) {
					SiteAddress siteAddress = (SiteAddress) iter.next();
					siteAddress.setSiteUser(siteUser);
					siteAddress
							.setFilepath(StringUtils.replace(
									siteAddress.getFilepath(), oldUserName,
									newUserName));
					siteAddress.setDetail(StringUtils.replace(
							siteAddress.getDetail(), "/" + oldUserName + "/",
							"/" + newUserName + "/"));
					siteAddress.setDetail2(StringUtils.replace(
							siteAddress.getDetail2(), "/" + oldUserName + "/",
							"/" + newUserName + "/"));
					siteAddress.setDetail3(StringUtils.replace(
							siteAddress.getDetail2(), "/" + oldUserName + "/",
							"/" + newUserName + "/"));
					adao.saveObject(siteAddress);
				}

				Set presource = importUser.getSitePresources();
				for (Iterator iter = presource.iterator(); iter.hasNext();) {
					SitePresource sitePresource = (SitePresource) iter.next();
					sitePresource.setSiteUser(siteUser);
					sitePresource.setFilepath(StringUtils.replace(
							sitePresource.getFilepath(), oldUserName,
							newUserName));

					adao.saveObject(sitePresource);
				}
				try {
					FileUtils.copyDirectory(new File(userhome + "/res"),
							new File(SystemInit.getWebroot() + "res"));
				} catch (Exception e) {
				}

				Set orderInput = importUser.getSiteOrderInputs();
				for (Iterator iter = orderInput.iterator(); iter.hasNext();) {
					SiteOrderInput siteOrderInput = (SiteOrderInput) iter
							.next();
					siteOrderInput.setSiteUser(siteUser);
					adao.saveObject(siteOrderInput);
				}

				/*
				 * Set orderCheck = importUser.getSiteOrderChecks(); for
				 * (Iterator iter = orderCheck.iterator(); iter.hasNext();) {
				 * SiteOrderCheck siteOrderCheck = (SiteOrderCheck) iter.next();
				 * siteOrderCheck.setSiteUser(siteUser);
				 * adao.saveObject(siteOrderCheck); for (Iterator iter2 =
				 * siteOrderCheck.getSiteOrderCheckItems() .iterator();
				 * iter2.hasNext();) { SiteOrderCheckItem siteOrderCheckItem =
				 * (SiteOrderCheckItem) iter2 .next();
				 * adao.saveObject(siteOrderCheckItem); } }
				 */

				Set orderCheck = importUser.getSiteOrderChecks();
				for (Iterator iter = orderCheck.iterator(); iter.hasNext();) {
					SiteOrderCheck oldsiteOrderCheck = (SiteOrderCheck) iter
							.next();
					SiteOrderCheck siteOrderCheck = new SiteOrderCheck();
					BeanUtils.copyProperties(siteOrderCheck, oldsiteOrderCheck);
					siteOrderCheck.setSiteOrderCheckItems(null);
					siteOrderCheck.setSiteUser(siteUser);
					adao.saveObject(siteOrderCheck);
					for (Iterator iter2 = oldsiteOrderCheck
							.getSiteOrderCheckItems().iterator(); iter2
							.hasNext();) {
						SiteOrderCheckItem siteOrderCheckItem = (SiteOrderCheckItem) iter2
								.next();
						siteOrderCheckItem.setSiteOrderCheck(siteOrderCheck);
						adao.saveObject(siteOrderCheckItem);
					}
				}
				Set orderRadio = importUser.getSiteOrderRadios();
				for (Iterator iter = orderRadio.iterator(); iter.hasNext();) {
					SiteOrderRadio oldsiteOrderRadio = (SiteOrderRadio) iter
							.next();
					SiteOrderRadio siteOrderRadio = new SiteOrderRadio();
					BeanUtils.copyProperties(siteOrderRadio, oldsiteOrderRadio);
					siteOrderRadio.setSiteOrderRadioItems(null);
					siteOrderRadio.setSiteUser(siteUser);
					adao.saveObject(siteOrderRadio);
					for (Iterator iter2 = oldsiteOrderRadio
							.getSiteOrderRadioItems().iterator(); iter2
							.hasNext();) {
						SiteOrderRadioItem siteOrderRadioItem = (SiteOrderRadioItem) iter2
								.next();
						siteOrderRadioItem.setSiteOrderRadio(siteOrderRadio);
						adao.saveObject(siteOrderRadioItem);
					}
				}

				Set spmp1 = importUser.getSiteSpmp1s();
				for (Iterator iter = spmp1.iterator(); iter.hasNext();) {
					SiteSpmp1 oldsiteSpmp1 = (SiteSpmp1) iter.next();
					SiteSpmp1 siteSpmp1 = new SiteSpmp1();
					BeanUtils.copyProperties(siteSpmp1, oldsiteSpmp1);
					/*
					 * 这么做的原因是配置会导致下面异常 Don't change the reference to a
					 * collection with cascade="all-delete-orphan":
					 * com.snp.site.model.SiteSpmp1.siteSpmp1Items;
					 */
					siteSpmp1.setSiteSpmp1Items(null);
					siteSpmp1.setSiteUser(siteUser);

					siteSpmp1.setFilepath(StringUtils.replace(
							siteSpmp1.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteSpmp1);
					for (Iterator iter2 = oldsiteSpmp1.getSiteSpmp1Items()
							.iterator(); iter2.hasNext();) {
						SiteSpmp1Item siteSpmp1Item = (SiteSpmp1Item) iter2
								.next();
						siteSpmp1Item.setSiteSpmp1(siteSpmp1);
						siteSpmp1Item.setFilepath(StringUtils.replace(
								siteSpmp1Item.getFilepath(), oldUserName,
								newUserName));
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
					siteSpmp2.setFilepath(StringUtils.replace(
							siteSpmp2.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteSpmp2);
					for (Iterator iter2 = oldsiteSpmp2.getSiteSpmp2Items()
							.iterator(); iter2.hasNext();) {
						SiteSpmp2Item siteSpmp2Item = (SiteSpmp2Item) iter2
								.next();
						siteSpmp2Item.setSiteSpmp2(siteSpmp2);
						siteSpmp2Item.setFilepath(StringUtils.replace(
								siteSpmp2Item.getFilepath(), oldUserName,
								newUserName));
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
					siteSpmp3.setFilepath(StringUtils.replace(
							siteSpmp3.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteSpmp3);
					for (Iterator iter3 = oldsiteSpmp3.getSiteSpmp3Items()
							.iterator(); iter3.hasNext();) {
						SiteSpmp3Item siteSpmp3Item = (SiteSpmp3Item) iter3
								.next();
						siteSpmp3Item.setSiteSpmp3(siteSpmp3);
						siteSpmp3Item.setFilepath(StringUtils.replace(
								siteSpmp3Item.getFilepath(), oldUserName,
								newUserName));
						adao.saveObject(siteSpmp3Item);
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
					siteSpmp4.setFilepath(StringUtils.replace(
							siteSpmp4.getFilepath(), oldUserName, newUserName));
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
						siteSpmp4Item.setFilepath(StringUtils.replace(
								siteSpmp4Item.getFilepath(), oldUserName,
								newUserName));
						adao.saveObject(siteSpmp4Item);
						for (Iterator iterator_p = oldsiteSpmp4Item
								.getSiteProducts().iterator(); iterator_p
								.hasNext();) {
							SiteProduct siteProduct = (SiteProduct) iterator_p
									.next();
							siteProduct.setFilepath(StringUtils.replace(
									siteProduct.getFilepath(), oldUserName,
									newUserName));
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
					siteSpmp5.setFilepath(StringUtils.replace(
							siteSpmp5.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteSpmp5);
					for (Iterator iter5 = oldsiteSpmp5.getSiteSpmp5Items()
							.iterator(); iter5.hasNext();) {
						SiteSpmp5Item siteSpmp5Item = (SiteSpmp5Item) iter5
								.next();
						siteSpmp5Item.setSiteSpmp5(siteSpmp5);
						siteSpmp5Item.setFilepath(StringUtils.replace(
								siteSpmp5Item.getFilepath(), oldUserName,
								newUserName));
						adao.saveObject(siteSpmp5Item);
					}
				}
				Set spmp6 = importUser.getSiteSpmp6s();
				for (Iterator iter = spmp6.iterator(); iter.hasNext();) {
					SiteSpmp6 oldsiteSpmp6 = (SiteSpmp6) iter.next();
					SiteSpmp6 siteSpmp6 = new SiteSpmp6();
					BeanUtils.copyProperties(siteSpmp6, oldsiteSpmp6);
					siteSpmp6.setSiteSpmp6Items(null);
					siteSpmp6.setSiteUser(siteUser);
					siteSpmp6.setFilepath(StringUtils.replace(
							siteSpmp6.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteSpmp6);
					for (Iterator iter6 = oldsiteSpmp6.getSiteSpmp6Items()
							.iterator(); iter6.hasNext();) {
						SiteSpmp6Item siteSpmp6Item = (SiteSpmp6Item) iter6
								.next();
						siteSpmp6Item.setSiteSpmp6(siteSpmp6);
						siteSpmp6Item.setFilepath(StringUtils.replace(
								siteSpmp6Item.getFilepath(), oldUserName,
								newUserName));
						adao.saveObject(siteSpmp6Item);
					}
				}
				Set spmp7 = importUser.getSiteSpmp7s();
				for (Iterator iter = spmp7.iterator(); iter.hasNext();) {
					SiteSpmp7 oldsiteSpmp7 = (SiteSpmp7) iter.next();
					SiteSpmp7 siteSpmp7 = new SiteSpmp7();
					BeanUtils.copyProperties(siteSpmp7, oldsiteSpmp7);
					siteSpmp7.setSiteSpmp7Items(null);
					siteSpmp7.setSiteUser(siteUser);
					siteSpmp7.setFilepath(StringUtils.replace(
							siteSpmp7.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteSpmp7);
					for (Iterator iter7 = oldsiteSpmp7.getSiteSpmp7Items()
							.iterator(); iter7.hasNext();) {
						SiteSpmp7Item siteSpmp7Item = (SiteSpmp7Item) iter7
								.next();
						siteSpmp7Item.setSiteSpmp7(siteSpmp7);
						siteSpmp7Item.setFilepath(StringUtils.replace(
								siteSpmp7Item.getFilepath(), oldUserName,
								newUserName));
						adao.saveObject(siteSpmp7Item);
					}
				}
				Set spmp8 = importUser.getSiteSpmp8s();
				for (Iterator iter = spmp8.iterator(); iter.hasNext();) {
					SiteSpmp8 oldsiteSpmp8 = (SiteSpmp8) iter.next();
					SiteSpmp8 siteSpmp8 = new SiteSpmp8();
					BeanUtils.copyProperties(siteSpmp8, oldsiteSpmp8);
					siteSpmp8.setSiteSpmp8Items(null);
					siteSpmp8.setSiteUser(siteUser);
					siteSpmp8.setFilepath(StringUtils.replace(
							siteSpmp8.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteSpmp8);
					for (Iterator iter8 = oldsiteSpmp8.getSiteSpmp8Items()
							.iterator(); iter8.hasNext();) {
						SiteSpmp8Item siteSpmp8Item = (SiteSpmp8Item) iter8
								.next();
						siteSpmp8Item.setSiteSpmp8(siteSpmp8);
						siteSpmp8Item.setFilepath(StringUtils.replace(
								siteSpmp8Item.getFilepath(), oldUserName,
								newUserName));
						adao.saveObject(siteSpmp8Item);
					}
				}
				Set spmp9 = importUser.getSiteSpmp9s();
				for (Iterator iter = spmp9.iterator(); iter.hasNext();) {
					SiteSpmp9 oldsiteSpmp9 = (SiteSpmp9) iter.next();
					SiteSpmp9 siteSpmp9 = new SiteSpmp9();
					BeanUtils.copyProperties(siteSpmp9, oldsiteSpmp9);
					siteSpmp9.setSiteSpmp9Items(null);
					siteSpmp9.setSiteUser(siteUser);
					siteSpmp9.setFilepath(StringUtils.replace(
							siteSpmp9.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteSpmp9);
					for (Iterator iter9 = oldsiteSpmp9.getSiteSpmp9Items()
							.iterator(); iter9.hasNext();) {
						SiteSpmp9Item siteSpmp9Item = (SiteSpmp9Item) iter9
								.next();
						siteSpmp9Item.setSiteSpmp9(siteSpmp9);
						siteSpmp9Item.setFilepath(StringUtils.replace(
								siteSpmp9Item.getFilepath(), oldUserName,
								newUserName));
						adao.saveObject(siteSpmp9Item);
					}
				}

				Set suser = importUser.getSiteSusers();
				for (Iterator iter = suser.iterator(); iter.hasNext();) {
					SiteSuser oldsiteSuser = (SiteSuser) iter.next();
					SiteSuser siteSuser = new SiteSuser();
					BeanUtils.copyProperties(siteSuser, oldsiteSuser);
					siteSuser.setSiteUser(siteUser);

					siteSuser.setSiteSuserItems(null);
					siteSuser.setFilepath(StringUtils.replace(
							siteSuser.getFilepath(), oldUserName, newUserName));
					adao.saveObject(siteSuser);
					for (Iterator iter2 = oldsiteSuser.getSiteSuserItems()
							.iterator(); iter2.hasNext();) {
						SiteSuserItem siteSuserItem = (SiteSuserItem) iter2
								.next();
						siteSuserItem.setSiteSuser(siteSuser);
						siteSuserItem.setFilepath(StringUtils.replace(
								siteSuserItem.getFilepath(), oldUserName,
								newUserName));
						adao.saveObject(siteSuserItem);
					}
				}
			} catch (Exception e) {
				e.printStackTrace(); // 如果这里不加异常捕捉，会导致推出，这样下面用户的属性保存无法运行，
			}
			if (op.equals("allsite") || op.equals("createnew")) {
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
						oldUserName, newUserName));
				siteUser.setBottom(StringUtils.replace(importUser.getBottom(),
						oldUserName, newUserName));
				siteUser.setContentleft(StringUtils.replace(
						importUser.getContentleft(), oldUserName, newUserName));
				siteUser.setContentright(StringUtils.replace(
						importUser.getContentright(), oldUserName, newUserName));

				siteUser.setIndexDesc(StringUtils.replace(
						importUser.getIndexDesc(), oldUserName, newUserName));
				siteUser.setIndexDesc2(StringUtils.replace(
						importUser.getIndexDesc2(), oldUserName, newUserName));
				siteUser.setIndexDesc3(StringUtils.replace(
						importUser.getIndexDesc3(), oldUserName, newUserName));

				siteUser.setGuestDesc(StringUtils.replace(
						importUser.getGuestDesc(), oldUserName, newUserName));

				siteUser.setCheckDesc(StringUtils.replace(
						importUser.getCheckDesc(), oldUserName, newUserName));

				siteUser.setMarquee(StringUtils.replace(
						importUser.getMarquee(), oldUserName, newUserName));
				siteUser.setMarquee2(StringUtils.replace(
						importUser.getMarquee2(), oldUserName, newUserName));
				siteUser.setMarquee3(StringUtils.replace(
						importUser.getMarquee3(), oldUserName, newUserName));
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
				if (!op.equals("createnew")) {
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
			}
		} catch (Exception e) {
			throw e;
			// write_log_error("userdata pagkage is error ,plase contact www.snpsoft.net",
			// e);
		}

	}
}
