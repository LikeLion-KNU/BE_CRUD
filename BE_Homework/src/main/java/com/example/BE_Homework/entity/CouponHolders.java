package com.example.BE_Homework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class CouponHolders {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberCouponId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
}

