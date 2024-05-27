package com.likelion.crud.entity;

import com.likelion.crud.dto.CouponUpdateDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;
    private Type type;
    private int discount;
    private LocalDateTime issueDate;
    private LocalDateTime expirationDate;

    public void update(CouponUpdateDto.Request couponUpdateDtoRequest) {
        this.type = couponUpdateDtoRequest.getType();
        this.discount = couponUpdateDtoRequest.getDiscount();
        this.expirationDate = couponUpdateDtoRequest.getExpirationDate();
    }
}
