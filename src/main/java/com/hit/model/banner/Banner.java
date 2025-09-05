package com.hit.model.banner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hit.model.Audit;
import com.hit.model.file.File;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Banner extends Audit {
    private Integer bannerId;
    private String bannerType;
    private String bannerNm;
    private String fileId;
    private Integer dispOrd;
    private String bannerLink;
    private LocalDateTime strDt;
    private LocalDateTime endDt;
    private File file;
}