package com.example.crud.dto.coupon;

import com.example.crud.dto.member.UpdateMemberDto;
import com.example.crud.entity.Coupon;
import com.example.crud.entity.enumType.CouponType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class UpdateCouponDto {

    @Getter @Setter
    public static class UpdateCouponRequest{

        private Long couponId;

        private CouponType couponType;

        private Integer discount;

    }

    @Getter @Setter
    @Builder
    public static class UpdateCouponResponse{

        private CouponType couponType;

        private Integer discount;

        public static UpdateCouponResponse toDto(Coupon coupon){
            return UpdateCouponResponse.builder()
                    .couponType(coupon.getCouponType())
                    .discount(coupon.getDiscount())
                    .build();
        }

    }

}
