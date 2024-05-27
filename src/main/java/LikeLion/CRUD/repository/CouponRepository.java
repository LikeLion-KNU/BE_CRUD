package LikeLion.CRUD.repository;

import LikeLion.CRUD.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}