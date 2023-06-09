package com.driver.repository;

import com.driver.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Integer>{

    Spot findByIdAndParkingLotId(int spotId, int parkingLotId);
    List<Spot> findByParkingLotIdAndOccupied(Integer parkingLotId, boolean occupied);
}
