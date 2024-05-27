package com.LikeLion.CRUD.Entity.Relation;

import com.LikeLion.CRUD.Entity.Coupon.Coupon;
import com.LikeLion.CRUD.Entity.Member.Member;
import jakarta.persistence.*;

@Entity
@Table(name = "coupon_holders")
public class CouponHolders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_coupon_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coupon_id", nullable = false)
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}
