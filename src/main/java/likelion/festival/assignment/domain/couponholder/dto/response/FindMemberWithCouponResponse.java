package likelion.festival.assignment.domain.couponholder.dto.response;

import likelion.festival.assignment.domain.member.entity.Member;
import likelion.festival.assignment.domain.member.entity.Role;
import lombok.Builder;

@Builder
public record FindMemberWithCouponResponse(Long member_id, String email, String name, Role role, int age) {
}
