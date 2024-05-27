package com.likelion.crud.dto;


import com.likelion.crud.entity.Coupon;
import com.likelion.crud.entity.Type;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
public class CouponRegisterDto {
    @Getter
    public static class Response {
        private Long id;
        private Type type;
        private int discount;
        private LocalDateTime issueDate;
        private LocalDateTime expirationDate;

        public void update(Coupon coupon) {
            id = coupon.getId();
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
