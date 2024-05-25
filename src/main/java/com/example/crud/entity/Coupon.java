package com.example.crud.entity;

import com.example.crud.entity.enumType.CouponType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Coupon {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @Enumerated(STRING)
    private CouponType couponType;

    private Integer discount;

    private LocalDateTime issueDate;

    private LocalDateTime expirationDate;

    public void update(CouponType couponType, Integer discount){
        this.couponType = couponType;
        this.discount = discount;
    }

}
