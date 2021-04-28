package com.dps.repository;

import com.dps.entity.SoilHumidity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilHumidityRepository extends JpaRepository<SoilHumidity, Integer> {
}
