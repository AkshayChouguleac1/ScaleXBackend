package com.gdevService.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdevService.Dto.FilterDto;
import com.gdevService.Models.Biomass;
import com.gdevService.Repo.BiomassRepo;

@Service
public class BiomassServiceImpl implements BiomassService{
	
	@Autowired
	BiomassRepo biomassRepo;

	@Override
	public Biomass addBiomass(Biomass biomass) {
		return biomassRepo.save(biomass);
	}

	@Override
	public Biomass updateBiomass(Biomass biomass, int biomass_Id) {
		Biomass existingBiomass = biomassRepo.findById(biomass_Id).orElse(null);
		existingBiomass.setBiomass_Name(biomass.getBiomass_Name());
		existingBiomass.setCountry(biomass.getCountry());
		existingBiomass.setIndustryCount(biomass.getIndustryCount());
		existingBiomass.setPriceInCurrentCountry(biomass.getPriceInCurrentCountry());
		existingBiomass.setQuantity(biomass.getQuantity());
		existingBiomass.setTopIndustryName(biomass.getTopIndustryName());
		existingBiomass.setUseCases(biomass.getUseCases());
		return biomassRepo.save(existingBiomass);
	}

	@Override
	public List<Biomass> fetchBiomasses(FilterDto filterDto) {
		
		return biomassRepo.findAll();
	}

	@Override
	public Biomass fetchBiomassById(int biomass_Id) {
		return biomassRepo.findById(biomass_Id).orElse(null);
	}

	@Override
	public void deleteBiomassById(int biomass_Id) {
		biomassRepo.deleteById(biomass_Id);
	}

	@Override
	public List<Biomass> addAllBiomasses(List<Biomass> biomasses,String uploader) {

		//setting created at , created by dates
		biomasses.stream().forEach(biomass->{
							biomass.setCreatedAt(LocalDate.now());
							biomass.setCreatedBy(uploader);
	                        });
		
		return biomassRepo.saveAll(biomasses);
	}

}
