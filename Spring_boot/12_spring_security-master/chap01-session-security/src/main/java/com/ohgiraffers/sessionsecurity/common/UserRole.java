package com.ohgiraffers.sessionsecurity.common;

/* enum: 상수 선언한다는 뜻 */
public enum UserRole {

    USER("USER"),
    ADMIN("ADMIN");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role='" + role + '\'' +
                '}';
    }
}
