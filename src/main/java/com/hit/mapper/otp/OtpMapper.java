package com.hit.mapper.otp;

import com.hit.model.otp.Otp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OtpMapper {
    Otp findOtp(Otp otp);

    void insertOtp(Otp otp);
}