package com.example.BE_Homework.domain.couponholders.entity;

import com.example.BE_Homework.domain.coupon.entity.Coupon;
import com.example.BE_Homework.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder @AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class CouponHolders {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
}

