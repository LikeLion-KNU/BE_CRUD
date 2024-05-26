package com.likelion.crud.Repository;

import com.likelion.crud.Entity.CouponHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponHoldeersRepository extends JpaRepository<CouponHolders,Long> {
}
