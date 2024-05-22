package likelion.demo.domain.member.dto.request;

public record MemberCreateRequest(String email,String password,String name,int age) {
}
