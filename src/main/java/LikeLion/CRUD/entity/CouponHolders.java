package LikeLion.CRUD.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CouponHolders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberCouponId;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}