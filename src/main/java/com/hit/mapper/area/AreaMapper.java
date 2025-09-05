package com.hit.mapper.area;

import com.hit.model.area.AreaCity;
import com.hit.model.area.AreaProvince;
import com.hit.model.area.AreaStreet;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AreaMapper {
    List<AreaProvince> findAreaProvinceList(AreaProvince areaProvince);

    List<AreaCity> findAreaCityList(AreaCity areaCity);

    List<AreaStreet> findAreaStreetList(AreaStreet areaStreet);
}