package com.ohgiraffers.comprehensive.member.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ohgiraffers.comprehensive.member.model.MemberRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter @Setter @ToString
public class MemberDTO implements UserDetails {
    private Long memberNo;
    private String memberId;
    private String memberPwd;
    private String nickname;
    private String phone;
    private String email;
    private String address;
    private Date enrollDate;
    private String memberStatus;
    private MemberRole memberRole;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roleName = "";
        if(memberRole != null) roleName = memberRole.name();
        return Arrays.asList(new SimpleGrantedAuthority(roleName));
    }

    @Override
    public String getPassword() {
        return memberPwd;
    }

    @Override
    public String getUsername() {
        return memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
