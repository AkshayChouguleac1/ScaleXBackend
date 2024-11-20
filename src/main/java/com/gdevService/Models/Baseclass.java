package com.gdevService.Models;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Baseclass {
	LocalDate createdAt;
	String createdBy;
	LocalDate modifiedAt;
	String modifiedBy;
}
