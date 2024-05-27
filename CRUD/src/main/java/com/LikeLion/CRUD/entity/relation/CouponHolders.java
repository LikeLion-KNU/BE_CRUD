package com.LikeLion.CRUD.entity.relation;

import com.LikeLion.CRUD.entity.coupon.Coupon;
import com.LikeLion.CRUD.entity.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
