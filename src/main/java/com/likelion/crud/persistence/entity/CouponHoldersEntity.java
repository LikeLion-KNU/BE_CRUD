package com.likelion.crud.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "coupon_holders")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CouponHoldersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_coupon_id")
    private Long memberCouponId;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "coupon_id")
    private CouponEntity coupon;
}
