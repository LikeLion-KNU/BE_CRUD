package dto.member;

import domain.Member;
import domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRegisterResponseDTO {
    private String name;
    private Role role;

    public void update(Member member){
        name = member.getName();
        role = member.getRole();
    }
}
