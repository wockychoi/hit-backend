package com.hit.mapper.category;

import com.hit.model.category.Category;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {

    List<Category> findCategoryList(Category category);

    void insertCategory(Category category);

    Integer updateCategory(Category category);

    Integer deleteCategory(Category category);

    Integer sortCategory(Category category);

    List<Category> findCategoryTree(Category category);
}