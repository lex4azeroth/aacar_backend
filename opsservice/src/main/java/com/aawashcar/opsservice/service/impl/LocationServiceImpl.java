package com.aawashcar.opsservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.opsservice.entities.City;
import com.aawashcar.opsservice.entities.District;
import com.aawashcar.opsservice.entities.Location;
import com.aawashcar.opsservice.entities.Province;
import com.aawashcar.opsservice.entities.ResidentialQuarter;
import com.aawashcar.opsservice.mappers.CityMapper;
import com.aawashcar.opsservice.mappers.DistrictMapper;
import com.aawashcar.opsservice.mappers.LocationMapper;
import com.aawashcar.opsservice.mappers.ProvinceMapper;
import com.aawashcar.opsservice.mappers.ResidentialQuarterMapper;
import com.aawashcar.opsservice.service.LocationService;

@Deprecated
@Service()
public class LocationServiceImpl implements LocationService {

	@Autowired
	private CityMapper cityMapper;

	@Autowired
	private ProvinceMapper provinceMapper;

	@Autowired
	private DistrictMapper districtMapper;
	
	@Autowired
	private ResidentialQuarterMapper residentialQuarterMapper;

	@Autowired
	private ResidentialQuarterMapper resiQuarterMapper;
	
	@Autowired
	private LocationMapper locationMapper;

	private final static String DEFAULT_NAME_PROVINCE = "上海";
	private final static String DEFAULT_NAME_CITY = "上海";
	private final static String DEFAULT_DISTRICT = "宝山";
	private final static String DEFAULT_RESI_QUARTER = "大华";

	@Override
	public Province retrieveDefaultProvince() {
		return provinceMapper.findProvinceByName(DEFAULT_NAME_PROVINCE);
	}

	@Override
	public City retrieveDefaultCity() {
		return cityMapper.findCityByName(DEFAULT_NAME_CITY);
	}

	@Override
	public District retrieveDefaultDistrict() {
		return districtMapper.findDistrictByName(DEFAULT_DISTRICT);
	}

	@Override
	public ResidentialQuarter retrieveDefaultResiQuarter() {
		return resiQuarterMapper.findResidentialQuarterByName(DEFAULT_RESI_QUARTER);
	}

	@Override
	public List<District> listDistricts(int provinceId, int cityId) {
		return districtMapper.listDistricts(provinceId, cityId);
	}
	
	@Override
	public List<ResidentialQuarter> listResidentialQuarter(int provinceId, int cityId, int districtId) {
		return residentialQuarterMapper.listResidentialQuarter(provinceId, cityId, districtId);
	}

	@Override
	public City findCityById(int id) {
		return cityMapper.findCityById(id);
	}

	@Override
	public District findDistrictById(int id) {
		return districtMapper.findDistrictById(id);
	}

	@Override
	public ResidentialQuarter findResidentialQuarterById(int id) {
		return residentialQuarterMapper.findResidentialQuarterById(id);
	}

	@Override
	public Province findProvinceById(int id) {
		return provinceMapper.findProvinceById(id);
	}

	@Override
	public Location findLalById(int id) {
		return locationMapper.findLocationById(id);
	}
}
