package com.jinwei.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jinwei.model.FileImage;

@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
	
	private String filepath ;//= "D:/";
	
	@Value("#{prop.filePath}")
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	private String getFileExt(String fileName){
		return FilenameUtils.getExtension(fileName);
	}
	
	private String newFileName(String fileName){
		return UUID.randomUUID() + "." + getFileExt(fileName);
	}
	
	/* (non-Javadoc)
	 * @see com.jinwei.util.FileUpload#uploadFile(com.jinwei.model.FileImage)
	 */
	@Override
	public String uploadFile(FileImage fileImage){
		String pic = newFileName(fileImage.getFilename());
		try {
			FileUtil.copyFile(fileImage.getFile(), new File(filepath,pic));
			return pic;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			fileImage.getFile().delete();
		}
	}
	
}
