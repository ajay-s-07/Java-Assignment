package com.example.demo.models.User;

import com.example.demo.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel {

    private String name;
    private String email;
    private Role role;
    private String contact_no;
}
