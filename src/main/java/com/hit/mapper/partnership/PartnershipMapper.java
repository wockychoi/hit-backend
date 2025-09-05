package com.hit.mapper.partnership;

import com.hit.model.partnership.Partnership;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PartnershipMapper {

    void insertPartnership(Partnership partnership);

    Integer updatePartnershipFiles(Partnership partnership);

    Integer updatePartnershipYn(Partnership partnership);
}