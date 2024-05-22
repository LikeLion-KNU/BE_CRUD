package likelion.demo.domain.holder.repository;

import likelion.demo.domain.coupon.entity.Coupon;
import likelion.demo.domain.holder.entity.CouponHolder;
import likelion.demo.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CouponHolderRepository extends JpaRepository<CouponHolder,Long> {

    Optional<CouponHolder> findByMemberAndCoupon(Member member, Coupon coupon);

    List<CouponHolder> findByMember_Id(Long memberId);
    List<CouponHolder> findByCoupon_Id(Long couponId);
}
