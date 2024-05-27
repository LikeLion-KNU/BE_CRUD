package com.likelion.crud.dto;


import com.likelion.crud.entity.Coupon;
import com.likelion.crud.entity.Type;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
public class CouponRegisterDto {
    @Getter
    public static class Response {
        private Long couponId;
        private Type type;
        private int discount;
        private LocalDateTime issueDate;
        private LocalDateTime expirationDate;

        public void update(Coupon coupon) {
            couponId = coupon.getCouponId();
            type = coupon.getType();
            discount = coupon.getDiscount();
            issueDate = coupon.getIssueDate();
            expirationDate = coupon.getExpirationDate();
        }
    }

    @Getter
    public static class Request {
        private Type type;
        private int discount;
        private LocalDateTime expirationDate;
    }
}
