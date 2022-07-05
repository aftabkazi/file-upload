package com.test.fileupload.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.test.fileupload.entity.FileUpload;
import com.test.fileupload.repository.FileUploadRepository;
import com.test.fileupload.repsonse.Response;

@Service
public class FileUploadService {

	@Autowired
	FileUploadRepository fileuploadRepository;
	
	public Response uploadFile(MultipartFile file) {
		return null;
	}
	
	public FileUpload store(MultipartFile file)throws IOException{
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		FileUpload fileUpload=new FileUpload(null, fileName,file.getContentType(),file.getBytes());
		return fileuploadRepository.save(fileUpload);
	}
	public FileUpload getFile(Long id) {
		return fileuploadRepository.findById(id).get();
	}
	public Stream<FileUpload>getAllFiles(){
		return fileuploadRepository.findAll().stream();
	}
}
