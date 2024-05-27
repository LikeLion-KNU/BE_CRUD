package com.LikeLion.CRUD.entity.coupon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Coupon")
@Getter
@Setter
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private CouponType type;

    private Integer discount;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

}
