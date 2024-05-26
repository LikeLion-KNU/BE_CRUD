package com.example.crud.dto.coupon;

import com.example.crud.entity.Coupon;
import com.example.crud.entity.CouponHolder;
import com.example.crud.entity.Member;
import com.example.crud.entity.enumType.CouponType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class SimpleCouponDto {

    private Long couponId;

    private CouponType couponType;

    private Integer discount;

    private LocalDateTime issueDate;

    private LocalDateTime expirationDate;

    public static SimpleCouponDto toDto(Coupon coupon){
        return SimpleCouponDto.builder()
                .couponId(coupon.getId())
                .couponType(coupon.getCouponType())
                .discount(coupon.getDiscount())
                .issueDate(coupon.getIssueDate())
                .expirationDate(coupon.getExpirationDate())
                .build();
    }

}
