package com.hit.mapper.portal;

import com.hit.model.category.Category;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {

    List<Category> findCategoryTree();

}