package com.sxyht.common.utils;

/* author：zss
 * 日期：2017年3月31日
 * 功能：根据文件名称判断类型
 * 接受参数类型：String 
 * 返回参数类型：String
 * 备注：文件类型不完善，有需要的自行添加
 */
public class FileType {
	public static final String[] PICTURE = { "bmp", "jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd",
			"cdr", "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf" };
	public static final String[] DOCUMENT = { "txt", "doc", "docx", "xls", "htm", "html", "jsp", "rtf", "wpd", "pdf", "ppt" };
	public static final String[] VIDEO = { "mp4", "avi", "mov", "wmv", "asf", "navi", "3gp", "mkv", "f4v", "rmvb", "webm" };
	public static final String[] MUSIC = { "mp3", "wma", "wav", "mod", "ra", "cd", "md", "asf", "aac", "vqf", "ape", "mid", "ogg",
			"m4a", "vqf" };
	public static final String[] SCRIPT= {"sql"};
	public static final String[] COMPRESS = {"zip"};
	public static int fileType(String fileName) {
		if (fileName == null) {
			fileName = "文件名为空！";
			return 500;
		}
		// 获取文件后缀名并转化为小写，用于后续比较
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
		for (int i = 0; i < PICTURE.length; i++) {
			if (PICTURE[i].equals(fileType)) 
				return 0;
			if (DOCUMENT[i].equals(fileType)) 
				return 1;
			if (VIDEO[i].equals(fileType)) 
				return 2;
			if (MUSIC[i].equals(fileType)) 
				return 3;
			if(SCRIPT[i].equals(fileType))
				return 4;
			if(COMPRESS[i].equals(fileType))
				return 5;
		}
		//4
		return 99;
	}
}