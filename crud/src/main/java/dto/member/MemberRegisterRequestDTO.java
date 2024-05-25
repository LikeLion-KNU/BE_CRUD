package dto.member;

import domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
public class MemberRegisterRequestDTO {
    @NonNull
    private String password;
    @NonNull
    private String name;
    private String email;
    private int age;
}
