package com.gdevService.Dto;

import java.util.List;

import com.gdevService.Models.Biomass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterDto {
	private String searchStr;
	private String pageNo;
	private String limit;
	List<FieldDto> fieldList;
}
