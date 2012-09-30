package com.snp.common;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.snp.site.init.SystemInit;

public class ImageProcessor {
	/**
	 * 缩放
	 * 
	 * @param filePath
	 *            图片路径
	 * @param newfile
	 *            新文件图片路径
	 * 
	 * @param height
	 *            高度
	 * @param width
	 *            宽度
	 * @param bb
	 *            比例不对时是否需要补白
	 */
	public static void resize(File f, String newfile, int height, int width,
			boolean bb) {
		try {
			double ratio = 0.0; // 缩放比例

			File newf = new File(newfile);
			BufferedImage bi = ImageIO.read(f);
			Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
			// 计算比例
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				if (bi.getHeight() > bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue()
							/ bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			}
			if (bb) {
				BufferedImage image = new BufferedImage(width, height,
						BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				g.dispose();
				itemp = image;
			}
			ImageIO.write((BufferedImage) itemp, "jpg", newf); // 会不会默认都变成JPG

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get_img_height(File f) {
		try {
			BufferedImage bi = ImageIO.read(f);
			return String.valueOf(bi.getHeight());
		} catch (IOException e) {
			return SystemInit.img_spmp4_height;
		}
	}

	public static String get_img_width(File f) {
		try {
			BufferedImage bi = ImageIO.read(f);
			return String.valueOf(bi.getWidth());

		} catch (IOException e) {
			return SystemInit.img_spmp4_width;
		}
	}

	public static void compress_img(File f, String newfile, boolean bb) {
		try {
			File newf = new File(newfile);
			BufferedImage bi;
			bi = ImageIO.read(f);
			int width = bi.getWidth();
			int height = bi.getHeight();
			resize(f, newfile, height, width, true);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}