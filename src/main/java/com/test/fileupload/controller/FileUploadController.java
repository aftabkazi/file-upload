package com.test.fileupload.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.test.fileupload.helper.FileUploadHandler;
import com.test.fileupload.repsonse.Response;
import com.test.fileupload.service.FileUploadService;


// create a folder as static and inside that folder create another folder as image
//location>> fileUpload>>fileUpload>>target>>classes>>static>>image and then run the project

@RestController
public class FileUploadController {

	@Autowired
	FileUploadService fileuploadservice;
	
	@Autowired
	FileUploadHandler FileUploadHandler;
	
	@GetMapping("/get")
	public String helloWorld() {
		return "Welcome Aftab";
	}
	// post data in folder
	@PostMapping("/uploads")
	public Response uploadFile(@RequestParam("file") MultipartFile file) {
		if(file.isEmpty()){
			return new Response("select file to upload");
		}
		else{
			FileUploadHandler.uploadFile(file);
			return new Response("File uploaded");
		}
	}
}
