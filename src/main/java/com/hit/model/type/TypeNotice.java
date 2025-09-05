package com.hit.model.type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hit.model.Audit;
import com.hit.model.category.Category;
import com.hit.model.file.File;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TypeNotice extends Audit {
    private Integer typeNoticeId;
    private Integer typeId;
    private String noticeType;
    private String noticeTypeNm;
    private String title;
    private String content;
    private LocalDateTime refreshDt;
    private List<File> fileList;
    private Integer viewCnt;
    private Integer likeCnt;
    //    private List<File> commentList;

    @JsonIgnore(false)
    private String creId;

    private String nickname;
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Type type;
    private Category category;
    private String search;
}