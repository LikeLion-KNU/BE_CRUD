package likelion.festival.assignment.domain.coupon.dto.response;

import likelion.festival.assignment.domain.coupon.entity.Type;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record CouponAllReadResponse(Long couponId, Type type, int discount, LocalDateTime issue_time, LocalDateTime expiration_time) {
}


