package com.gdevService.Utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.gdevService.Models.Biomass;

public class ReadExcelUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ReadExcelUtil.class);
	
	public static List<Biomass> readExcelFile(MultipartFile excelFile) {
		List<Biomass> Biomasses = new ArrayList<>();
		Workbook workbook = null;

		try {
			workbook = WorkbookFactory.create(excelFile.getInputStream());
			logger.info("Number of sheets: " + workbook.getNumberOfSheets());

			workbook.forEach(sheet -> {
				logger.info("Title of sheet => " + sheet.getSheetName());

				DataFormatter dataFormatter = new DataFormatter();
				int index = 0;
				for (Row row : sheet) {
					if (index++ == 0)
						continue;
					Biomass biomass = new Biomass();

					if (row.getCell(0) != null && row.getCell(0).getCellType() == CellType.STRING) {
						biomass.setBiomass_Name((String) row.getCell(0).getStringCellValue());	
					}
					
					if (row.getCell(1) != null && row.getCell(1).getCellType() == CellType.STRING) {
						biomass.setCountry((String) row.getCell(1).getStringCellValue());
					}
					
					if (row.getCell(2) != null && row.getCell(2).getCellType() == CellType.NUMERIC) {
						biomass.setQuantity((Double) row.getCell(2).getNumericCellValue());
					}
					
					if (row.getCell(3) != null && row.getCell(3).getCellType() == CellType.NUMERIC) {
						biomass.setIndustryCount((int) row.getCell(3).getNumericCellValue());
					}
					
					if (row.getCell(4) != null && row.getCell(4).getCellType() == CellType.STRING) {
						biomass.setUseCases((String) row.getCell(4).getStringCellValue());	
					}

					if (row.getCell(5) != null && row.getCell(5).getCellType() == CellType.NUMERIC) {
						biomass.setPriceInCurrentCountry((Double) row.getCell(5).getNumericCellValue());
					}
					
					if (row.getCell(6) != null && row.getCell(6).getCellType() == CellType.STRING) {
						biomass.setTopIndustryName((String) row.getCell(6).getStringCellValue());	
					}

					Cell dateCell = row.getCell(7);
					if (DateUtil.isCellDateFormatted(dateCell)) {
						LocalDate date = dateCell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault())
								.toLocalDate();
						biomass.setSurveyStartDate(date);
					}

					Biomasses.add(biomass);
				}
			});
		} catch (EncryptedDocumentException | IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (workbook != null)
					workbook.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}

		return Biomasses;
	}
}
