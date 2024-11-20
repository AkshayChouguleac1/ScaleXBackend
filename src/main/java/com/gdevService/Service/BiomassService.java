package com.gdevService.Service;

import java.util.List;

import com.gdevService.Dto.FilterDto;
import com.gdevService.Models.Biomass;

public interface BiomassService {
	public Biomass addBiomass(Biomass biomass);
	public List<Biomass> addAllBiomasses(List<Biomass> biomasses,String uploader);
	public Biomass updateBiomass(Biomass biomass,int biomass_Id);
	public List<Biomass> fetchBiomasses(FilterDto filterDto);
	public Biomass fetchBiomassById(int biomass_Id);
	public void deleteBiomassById(int biomass_Id);
}
