package likelion.festival.assignment.domain.member.dto.request;

import likelion.festival.assignment.domain.member.entity.Role;
import lombok.Builder;

@Builder
public record MemberUpdateRequest(String email, String password, String name, Role role,int age){
}
