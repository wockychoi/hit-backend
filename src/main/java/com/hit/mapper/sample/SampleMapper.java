package com.hit.mapper.sample;

import com.hit.model.sample.Sample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {
    List<Sample> findSampleList();

    Sample findSampleById(Integer sampleId);

    int migFile(Sample paramfile);

    Integer saveShop(Sample paramfile);
}