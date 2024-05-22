package likelion.festival.assignment.domain.member.dto.response;

import likelion.festival.assignment.domain.member.entity.Role;
import lombok.Builder;

@Builder
public record MemberAllReadResponse(Long member_id, String email, String name, Role role, int age){
}
