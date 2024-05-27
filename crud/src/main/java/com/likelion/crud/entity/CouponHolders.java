package com.likelion.crud.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class CouponHolders {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberCouponId;
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


}
