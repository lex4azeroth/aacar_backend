package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.opsservice.entities.WashCarService;

@Mapper
public interface ServiceMapper {

	int addService(WashCarService service);

	void updateServiceStatus(@Param("id") int id, @Param("enabled") boolean enabled);

	void updateServiceIconUrlById(@Param("id") int id, @Param("iconUrl") String iconUrl);

	List<WashCarService> listServices();

	WashCarService findServiceById(int id);

	double findOriginPrice(@Param("vtId") int vtId, @Param("vcId") int vcId, @Param("serviceId") int serviceId);
}
