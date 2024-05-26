package com.likelion.crud.persistence.entity;

import com.likelion.crud.domain.Coupon;
import com.likelion.crud.domain.CouponType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "coupon")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long couponId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CouponType type;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    public Coupon toDomain() {
        return new Coupon(couponId, type, discount, issueDate, expirationDate);
    }

    public static CouponEntity fromDomain(Coupon coupon) {
        return new CouponEntity(coupon.couponId(), coupon.type(), coupon.discount(), coupon.issueDate(), coupon.expirationDate());
    }
}
