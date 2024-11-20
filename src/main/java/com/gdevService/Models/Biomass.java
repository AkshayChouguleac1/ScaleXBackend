package com.gdevService.Models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Biomass extends Baseclass{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int biomass_Id;
	String biomass_Name;
	String country;
	Double quantity;
	int industryCount;
	String useCases;
	Double priceInCurrentCountry;
	String topIndustryName;
	LocalDate SurveyStartDate;
}
