package com.example.BE_Homework.entity;

import com.example.BE_Homework.entity.enumType.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Coupon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Integer discount;

    private LocalDateTime issueDate;

    private LocalDateTime expirationDate;

    @OneToMany(mappedBy = "coupon")
    private List<CouponHolders> couponHolders;

}
