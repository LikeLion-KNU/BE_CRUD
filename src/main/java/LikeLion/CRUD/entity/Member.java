package LikeLion.CRUD.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String name;
    private int age;
    private boolean isAccountExpired;
    private boolean isAccountLocked;
}