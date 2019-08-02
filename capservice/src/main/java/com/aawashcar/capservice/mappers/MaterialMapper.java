package com.aawashcar.capservice.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.capservice.entities.Material;

@Mapper
public interface MaterialMapper {

	int addMaterial(Material material);

	Material findMaterialById(int id);
	
	int updateMaterial(Material material);
}
