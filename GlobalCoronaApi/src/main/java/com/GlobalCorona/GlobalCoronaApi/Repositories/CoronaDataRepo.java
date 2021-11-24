package com.GlobalCorona.GlobalCoronaApi.Repositories;

import com.GlobalCorona.GlobalCoronaApi.Models.CoronaDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CoronaDataRepo extends JpaRepository<CoronaDataModel,Long> {

    @Query(value = "select * from corona_data_model where country_region = ?1", nativeQuery = true)
    List<CoronaDataModel> findByCountry(String country);

}
