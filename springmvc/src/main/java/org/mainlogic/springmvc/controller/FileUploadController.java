package org.mainlogic.springmvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path="/file")
public class FileUploadController {

	@RequestMapping(path="/fileUpload")
	public void processUpload(@RequestParam("uploadedFile") MultipartFile file) {
		
		try {
			byte[] bytes = file.getBytes();
			File ofile = new File("/home/sri/Pictures/uploaded.jpg");
			ofile.createNewFile();
		
			FileOutputStream io = new FileOutputStream(ofile);
			io.write(bytes);
			
			io.flush();
			io.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(path="/fileUpload2")
	public void processUploadServlet(@RequestParam("uploadedFile") Part file) {
		
		try {
			 byte[] buffer = new byte[file.getInputStream().available()];
			file.getInputStream().read(buffer);
			
			File ofile = new File("/home/sri/Pictures/" + file.getName());
			ofile.createNewFile();
		
			FileOutputStream io = new FileOutputStream(ofile);
			io.write(buffer);
			
			io.flush();
			io.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping
	public String uploadHome() {
		
		return "FileUpload";
	}
}
