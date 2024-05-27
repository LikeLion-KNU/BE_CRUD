package com.LikeLion.CRUD.dto.coupon;

import com.LikeLion.CRUD.entity.coupon.CouponType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CouponDTO {

    private CouponType type;
    private Integer discount;
    private LocalDateTime issueDate;
    private LocalDateTime expirationDate;
}
