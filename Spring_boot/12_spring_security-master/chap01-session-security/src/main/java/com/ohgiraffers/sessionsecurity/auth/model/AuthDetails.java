package com.ohgiraffers.sessionsecurity.auth.model;


import com.ohgiraffers.sessionsecurity.user.model.dto.LoginUserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthDetails  implements UserDetails {

    private LoginUserDTO loginUserDTO;

    public AuthDetails() {}

    public AuthDetails(LoginUserDTO loginUserDTO) {
        this.loginUserDTO = loginUserDTO;
    }

    public LoginUserDTO getLoginUserDTO() {
        return loginUserDTO;
    }

    public void setLoginUserDTO(LoginUserDTO loginUserDTO) {
        this.loginUserDTO = loginUserDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /* 권한 정보를 가져오겠다. */

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        loginUserDTO.getRole().forEach(role -> authorities.add(() -> role));

        return authorities;
    }

    @Override
    public String getPassword() {
        return loginUserDTO.getPassword();
        /* 비밀번호를 비교할 때 사용 */
    }

    @Override
    public String getUsername() {
        return loginUserDTO.getUserName();
        /* 아이디를 비교할 때 사용 */
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
        /* 계정이 만료되었는지 확인 */
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
        /* 계정이 잠겨있는지 확인 */
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
        /* 계정이 탈퇴되었는지 확인 */
    }

    @Override
    public boolean isEnabled() {
        return true;
        /* 계정이 사용가능한지 확인 */
    }
}
