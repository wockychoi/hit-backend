package com.hit.model.msg;

import com.hit.model.Audit;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Msg extends Audit {
    private Integer msgId;
    private String senderId;
    private String receiverId;
    private String subject;
    private String content;
    private String sendTime;
    private String isRead;
    private String readTime;
    private String useYn;
}