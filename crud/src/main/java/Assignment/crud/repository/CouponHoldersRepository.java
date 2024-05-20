package Assignment.crud.repository;

import Assignment.crud.domain.CouponHolders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponHoldersRepository extends JpaRepository<CouponHolders, Long> {

    List<CouponHolders> findByMemberId(Long memberId);

    List<CouponHolders> findByCouponId(Long couponId);

    void deleteByMemberIdAndCouponId(Long memberId, Long couponId);
}
