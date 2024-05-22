package likelion.festival.assignment.domain.couponholder.dto.request;

import lombok.Builder;

@Builder
public record CouponToMemberRequest(Long memberId, Long couponId) {
}
