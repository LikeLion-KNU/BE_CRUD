package likelion.festival.assignment.domain.couponholder.repository;

import likelion.festival.assignment.domain.couponholder.entity.CouponHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface CouponHolderRepository extends JpaRepository<CouponHolder, Long > {

    List<CouponHolder> findByMemberId(Long memberId);
    List<CouponHolder> findByCouponId(Long couponId);

    void deleteByMemberIdAndCouponId(Long memberId, Long couponId);
}
