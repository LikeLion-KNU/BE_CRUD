package likelion.demo.domain.member.dto.response;

import likelion.demo.domain.member.entity.Member;
import lombok.Builder;

import java.util.List;

@Builder
public record MemberReadResponse(String email, String name, int age) {

    public static List<MemberReadResponse> makeListMember(List<Member> members) {
        return members.stream()
                .map(member -> MemberReadResponse
                        .builder()
                        .email(member.getEmail())
                        .name(member.getName())
                        .age(member.getAge())
                        .build())
                .toList();
    }
}
