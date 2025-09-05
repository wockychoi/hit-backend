package com.hit.model.category;

import com.hit.model.Audit;
import com.hit.model.type.Type;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Category extends Audit {
    private Integer categoryId;
    private String categoryNm;
    private Integer dispOrd;
    private String iconImg;
    private Integer typeCnt;
    private Integer typeDetailCnt;
    private Integer typeDetailShopCnt;
    private List<Type> typeList;
    private String topYn;
    private String leftYn;
    private String route;
    private Boolean noCount;
}