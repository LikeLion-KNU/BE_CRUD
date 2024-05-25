package dto.member;

import domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRegisterRequestDTO {
    private String email;
    private String password;
    private String name;
    private int age;
}
