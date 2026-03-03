package com.codingshuttle.youtube.hospitalManagement.entity;

import com.codingshuttle.youtube.hospitalManagement.entity.type.RoleType;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "app_user")
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String username;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Enumerated
    Set<RoleType> roles = new HashSet<>();
}
