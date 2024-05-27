package com.likelion.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Coupon {
    @Id
    private int coupon_id;
    private Enum type;
    private int discount;

}
