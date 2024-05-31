package com.example.BE_Homework.domain.coupon.entity;

import com.example.BE_Homework.domain.coupon.dto.CouponReadRequestDto;
import com.example.BE_Homework.domain.coupon.dto.CouponUpdateRequestDto;
import com.example.BE_Homework.domain.couponholders.entity.CouponHolders;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CouponType couponType;

    private Integer discount;

    private LocalDateTime issueDate;

    private LocalDateTime expirationDate;

    @OneToMany(mappedBy = "coupon")
    private List<CouponHolders> couponHolders;


    public void update(CouponUpdateRequestDto couponUpdateRequestDto){
        this.couponType = couponUpdateRequestDto.couponType();
        this.discount = couponUpdateRequestDto.discount();
        this.expirationDate = couponUpdateRequestDto.expirationDate();
    }

    // 정적 펙토리 메소드?
    public static Coupon toEntity(CouponReadRequestDto couponReadRequestDto){
        return Coupon.builder()
                .couponType(couponReadRequestDto.couponType())
                .discount(couponReadRequestDto.discount())
                .expirationDate(couponReadRequestDto.expirationDate())
                .build();
    }

    @Builder
    public Coupon(CouponType couponType, Integer discount, LocalDateTime issueDate, LocalDateTime expirationDate, List<CouponHolders> couponHolders) {
        this.couponType = couponType;
        this.discount = discount;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.couponHolders = couponHolders;
    }
}
