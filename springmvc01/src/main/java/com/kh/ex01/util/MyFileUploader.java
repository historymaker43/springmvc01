package com.kh.ex01.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class MyFileUploader {
	
	public static String uploadFile(String uploadPath, String originalFilename, byte[] fileData) {
		
		UUID uuid = UUID.randomUUID(); // 중복되지 않는 긴 문자열
		String saveFilename = uploadPath + "/" + uuid + "_" + originalFilename;
		System.out.println("saveFilename : " + saveFilename);
		File fTarget = new File(saveFilename);
		try {
			FileCopyUtils.copy(fileData, fTarget);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveFilename;
	}
}
