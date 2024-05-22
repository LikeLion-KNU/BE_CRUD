package likelion.demo.domain.holder.entity;

import jakarta.persistence.*;
import likelion.demo.domain.coupon.entity.Coupon;
import likelion.demo.domain.member.entity.Member;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_coupon_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="coupon_id")
    private Coupon coupon;

    @Builder
    public CouponHolder(Member member, Coupon coupon) {
        this.member = member;
        this.coupon = coupon;
    }


}
