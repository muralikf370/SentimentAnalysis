package com.bcbs.sentimentanalysis.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	
	public ResponseEntity<Void>  uploadFileHandler( MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				
				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
						//"C:\\D_Drive";
				
						//System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator+"tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()+ File.separator+File.separator+file.getOriginalFilename() );
				
				//BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile.getPath()));
				
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

			//	return new ResponseEntity<Void>(HttpStatus.OK);
			} catch (Exception e) {
				logger.error(e.getMessage());
				//return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
