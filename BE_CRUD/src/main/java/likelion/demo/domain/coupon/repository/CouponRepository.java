package likelion.demo.domain.coupon.repository;

import likelion.demo.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long> {
}
