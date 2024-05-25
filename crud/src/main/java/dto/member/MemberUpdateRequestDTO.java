package dto.member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberUpdateRequestDTO {
    private String email;
    private String password;
    private String name;
    private int age;
}
