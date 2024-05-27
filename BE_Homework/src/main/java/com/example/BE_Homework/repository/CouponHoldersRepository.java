package com.example.BE_Homework.repository;

import com.example.BE_Homework.entity.CouponHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponHoldersRepository extends JpaRepository<CouponHolders, Long> {
}
