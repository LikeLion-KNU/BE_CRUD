package likelion.festival.assignment.domain.member.dto.request;

import likelion.festival.assignment.domain.member.entity.Role;
import lombok.Builder;

@Builder
public record MemberSaveRequest(String email, String password,String name, Role role, int age, boolean is_account_expired, boolean is_account_locked) {
}
