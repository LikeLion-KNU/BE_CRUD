package com.example.crud.dto.coupon;

import com.example.crud.dto.member.CreateMemberDto;
import com.example.crud.dto.member.CreateMemberDto.CreateMemberResponse;
import com.example.crud.entity.Coupon;
import com.example.crud.entity.enumType.CouponType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class CreateCouponDto {

    @Getter @Setter
    public static class CreateCouponRequest{

        private CouponType couponType;

        private Integer discount;

        private Integer expiration; //per month

    }

    @Getter @Setter
    @Builder
    public static class CreateCouponResponse{

        private Long couponId;

        private CouponType couponType;

        private LocalDateTime issueDate;

        private LocalDateTime expirationDate;

        public static CreateCouponResponse toDto(Coupon coupon){
            return CreateCouponResponse.builder()
                    .couponId(coupon.getId())
                    .couponType(coupon.getCouponType())
                    .issueDate(coupon.getIssueDate())
                    .expirationDate(coupon.getExpirationDate())
                    .build();
        }

    }

}
