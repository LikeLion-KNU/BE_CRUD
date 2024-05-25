package com.likelion.crud.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
public class CouponHolders {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_coupon_id;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name="coupon_id")
    private Coupon coupon;
}
