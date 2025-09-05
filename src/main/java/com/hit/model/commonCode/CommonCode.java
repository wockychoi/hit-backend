package com.hit.model.commonCode;

import com.hit.model.Audit;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CommonCode extends Audit {
    private String codeGrp;
    private String code;
    private String codeNm;
    private Integer dispOrd;
}
