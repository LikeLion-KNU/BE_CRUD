package com.example.crud.dto.coupon;

import com.example.crud.entity.Coupon;
import com.example.crud.entity.CouponHolder;
import com.example.crud.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class SimpleCouponDto {

    private Long memberId;

    private String name; //member

    private Integer discount;

    private LocalDateTime issueDate;

    private LocalDateTime expirationDate;

    public static SimpleCouponDto toDto(Coupon coupon){
        return SimpleCouponDto.builder()
                .discount(coupon.getDiscount())
                .issueDate(coupon.getIssueDate())
                .expirationDate(coupon.getExpirationDate())
                .build();
    }

    public static SimpleCouponDto toDtoWithMember(CouponHolder couponHolder){
        return SimpleCouponDto.builder()
                .memberId(couponHolder.getMember().getId())
                .name(couponHolder.getMember().getName())
                .discount(couponHolder.getCoupon().getDiscount())
                .issueDate(couponHolder.getCoupon().getIssueDate())
                .expirationDate(couponHolder.getCoupon().getExpirationDate())
                .build();
    }

}
