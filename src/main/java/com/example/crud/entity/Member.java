package com.example.crud.entity;

import com.example.crud.entity.enumType.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    @Enumerated(STRING)
    private Role role;

    private String name;

    private Integer age;

    private Boolean isAccountExpired;

    private Boolean isAccountLocked;

    public void update(String email, String name, String password){
        this.email=email;
        this.name=name;
        this.password=password;
    }

}
