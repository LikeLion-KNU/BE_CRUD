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
    private Long member_coupon_id;
    private int coupon_id;
    private int member_id;
}
