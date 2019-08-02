package com.aawashcar.opsservice.service;

import java.util.List;

import com.aawashcar.opsservice.entities.City;
import com.aawashcar.opsservice.entities.District;
import com.aawashcar.opsservice.entities.Location;
import com.aawashcar.opsservice.entities.Province;
import com.aawashcar.opsservice.entities.ResidentialQuarter;

@Deprecated
public interface LocationService {
	
	Province retrieveDefaultProvince();
	
	City retrieveDefaultCity();
	
	District retrieveDefaultDistrict();
	
	List<District> listDistricts(int provinceId, int cityId);
	
	List<ResidentialQuarter> listResidentialQuarter(int provinceId, int cityId, int districtId);
	
	ResidentialQuarter retrieveDefaultResiQuarter();
	
	Province findProvinceById(int id);
	
	City findCityById(int id);
	
	District findDistrictById(int id);
	
	ResidentialQuarter findResidentialQuarterById(int id);
	
	Location findLalById(int id);
}
