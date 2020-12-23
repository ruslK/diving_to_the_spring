package com.derivequeries.repositories;

import com.derivequeries.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

    List<Region> findRegionByCountry(String country);
    List<Region> findByCountry(String country);

    List<Region> findDistinctByCountry(String country);

    List<Region> findByCountryContaining(String country);

    List<Region> findByCountryContainingOrderByCountryDesc (String country);
    List<Region> findByCountryContainingOrderByCountry (String country);

    List<Region> findTop1ByCountry (String country);
    List<Region> findTop2ByCountry (String country);
    List<Region> findTop3ByCountry (String country);
}
