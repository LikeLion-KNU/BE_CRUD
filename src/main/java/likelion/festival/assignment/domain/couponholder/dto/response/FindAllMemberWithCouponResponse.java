package likelion.festival.assignment.domain.couponholder.dto.response;

import likelion.festival.assignment.domain.member.entity.Member;
import lombok.Builder;

@Builder
public record FindAllMemberWithCouponResponse(Long member_coupon_id, Long member_id, Long coupon_id){
}
