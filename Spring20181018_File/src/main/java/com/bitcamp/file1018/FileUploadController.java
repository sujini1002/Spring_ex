package com.bitcamp.file1018;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
	
	@RequestMapping("/")
	public String form() {
		return "form";
	}
	@RequestMapping(value="/submitReport1", method=RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber,
								@RequestParam("report") MultipartFile report,
								Model model) 
	{
		String fileName = report.getOriginalFilename(); //파일이름
		long fileSize = report.getSize();//파일 크기
		 
		model.addAttribute("sno", studentNumber);
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);
		
		return "uploadOk";
	}
	
	@RequestMapping(value="/submitReport2", method=RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request,Model model) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile multipartFile = request.getFile("report");
		
		String fileName = multipartFile.getOriginalFilename();
		long fileSize = multipartFile.getSize();
		
		model.addAttribute("sno", studentNumber);
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);
		
		return "uploadOk";
	}
	
	@RequestMapping(value="/submitReport3", method=RequestMethod.POST)
	public String submitReport3(StudentReport studentReport,Model model) {
		
		String studentNumber = studentReport.getStudentNumber();
		String fileName = studentReport.getReport().getOriginalFilename();
		long fileSize = studentReport.getReport().getSize();
		
		model.addAttribute("sno", studentNumber);
		model.addAttribute("fileName", fileName);
		model.addAttribute("fileSize", fileSize);
		
		return "uploadOk";
	}
}
