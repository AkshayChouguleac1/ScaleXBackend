package com.gdevService.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gdevService.Dto.ResponseDto;
import com.gdevService.Models.Biomass;
import com.gdevService.Service.BiomassService;
import com.gdevService.Utils.ReadExcelUtil;
import com.gdevService.Utils.S3Utils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/biomass")
public class BiomassController {
	
	@Autowired
	BiomassService biomassService;
	
    @PostMapping("/uploadFile")
	public ResponseDto<List<Biomass>> uploadExcel(@RequestParam("file") MultipartFile file,@RequestParam("uploader")String uploader){
    	ResponseDto<List<Biomass>> Responsebiomasses = new ResponseDto<List<Biomass>>();
		S3Utils.uploadFile(file);
		List<Biomass> biomassesFromExcel=new ArrayList<>();
		biomassesFromExcel=ReadExcelUtil.readExcelFile(file);
		this.biomassService.addAllBiomasses(biomassesFromExcel, uploader);
		Responsebiomasses.setData(biomassesFromExcel);
		Responsebiomasses.setSuccessMessage("File Processed Successfully !");
		Responsebiomasses.setStatusCode(200);
		return Responsebiomasses;
	}
	 
}
