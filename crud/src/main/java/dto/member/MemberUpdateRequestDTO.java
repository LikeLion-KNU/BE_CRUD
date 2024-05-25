package dto.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
public class MemberUpdateRequestDTO {
    @NonNull
    private String name;
    @NonNull
    private String password;
    @NonNull
    private String email;
    private int age;
}
