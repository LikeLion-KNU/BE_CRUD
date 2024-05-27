package com.likelion.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CouponHolders {
    @Id
    private Long memberCouponId;
    private int couponId;
    private int memberId;
}
