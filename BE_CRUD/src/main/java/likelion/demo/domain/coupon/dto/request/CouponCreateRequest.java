package likelion.demo.domain.coupon.dto.request;

import likelion.demo.domain.coupon.entity.Type;

import java.time.LocalDateTime;

public record CouponCreateRequest(
        Type type,
        int discount,
        LocalDateTime issueDate,
        LocalDateTime expirationDate

) {
}
