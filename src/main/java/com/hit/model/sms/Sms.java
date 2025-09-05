package com.hit.model.sms;

import com.hit.model.Audit;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class Sms extends Audit {
    private Integer smsId;
    private String toNumber;
    private String subject;
    private String content;
}