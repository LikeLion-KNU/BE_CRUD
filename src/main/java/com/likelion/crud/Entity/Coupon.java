package com.likelion.crud.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Coupon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;
    @Enumerated(EnumType.STRING)
    private CouponType type;
    private int discount;
    private LocalDateTime issue_date;
    private LocalDateTime expiration_date;

    @JsonIgnore
    @OneToMany(mappedBy = "coupon")
    private List<CouponHolders> CouponHolders = new ArrayList<CouponHolders>();
}
