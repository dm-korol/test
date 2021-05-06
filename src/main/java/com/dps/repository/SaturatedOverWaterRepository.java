package com.dps.repository;

import com.dps.entity.SaturatedOverWater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaturatedOverWaterRepository extends JpaRepository<SaturatedOverWater, Integer> {
}
