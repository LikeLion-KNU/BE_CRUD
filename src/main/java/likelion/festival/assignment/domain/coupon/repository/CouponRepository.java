package likelion.festival.assignment.domain.coupon.repository;

import likelion.festival.assignment.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;


public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
