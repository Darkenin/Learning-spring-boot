package com.lsio.springboot.services;

import java.util.List;

import com.lsio.springboot.Pojos.CityRequest;
import com.lsio.springboot.entities.City;
import com.lsio.springboot.entities.Country;
import com.lsio.springboot.repositories.CityRepository;
import com.lsio.springboot.repositories.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired CityRepository cityresRepository;
    @Autowired CountryRepository countryRepository;

    public CityService(){
        
    }

    public List<City> getCities(){

        return cityresRepository.findAll();

    }

	public City saveCity(City city) {

        return cityresRepository.save(city);

	}

	public City getCity(String cityname) {
		return cityresRepository.findByCityname(cityname);
	}

	public City addCity(CityRequest cityrequest) {
        Country country = countryRepository.findById(cityrequest.country_id);

        City city = new City();
        city.setCityname(cityrequest.cityname);
        city.setCitycode(cityrequest.citycode);
        city.setCountry(country);

    	return cityresRepository.save(city);
	}

}
