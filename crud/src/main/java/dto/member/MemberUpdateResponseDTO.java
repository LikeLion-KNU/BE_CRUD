package dto.member;

import domain.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberUpdateResponseDTO {
    private String email;
    private String password;
    private String name;
    private int age;

    public void update(Member member){
        email = member.getEmail();
        password = member.getPassword();
        name = member.getName();
        age = member.getAge();
    }
}
