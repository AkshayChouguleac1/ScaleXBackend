package com.gdevService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdevService.Models.Biomass;
@Repository
public interface BiomassRepo extends JpaRepository<Biomass, Integer>{

}
