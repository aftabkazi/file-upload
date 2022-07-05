package com.test.fileupload.helper;

import java.io.FileOutputStream;
//import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.test.fileupload.repsonse.Response;

@Component
public class FileUploadHandler {
	
//	public final String upload_dir="C:\\Users\\cdac\\Desktop\\Aftab\\Uploaded files\\";
	public final String upload_dir=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHandler() throws Exception {
		 
	}
	
	
	public Response uploadFile(MultipartFile file) {
		try {
				InputStream is=file.getInputStream();
				byte data[]=new byte[is.available()];
				is.read(data);
				FileOutputStream fos=new FileOutputStream(upload_dir+file.getOriginalFilename());
				fos.write(data);
				fos.close();
			}
			catch( Exception e) {
				e.printStackTrace();
			}
		return new Response("File uploaded sucessfully");
	}
}
