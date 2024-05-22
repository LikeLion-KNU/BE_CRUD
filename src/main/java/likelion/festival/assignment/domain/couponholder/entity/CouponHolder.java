package likelion.festival.assignment.domain.couponholder.entity;


import jakarta.persistence.*;
import likelion.festival.assignment.domain.coupon.entity.Coupon;
import likelion.festival.assignment.domain.member.entity.Member;
import likelion.festival.assignment.domain.member.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CouponHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_coupon_id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @Builder
    public CouponHolder(Member member, Coupon coupon){
        this.member = member;
        this.coupon = coupon;
    }

}
