package com.gdevService.Dto;

import java.util.List;

import com.gdevService.Models.Biomass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
	private T data;
	private int statusCode;
	private String errorMessage;
	private String successMessage;
}
