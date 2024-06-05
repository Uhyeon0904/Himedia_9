package com.ohgiraffers.common;

import lombok.*;

/* LomBok 라이브러리 어노테이션을 사용하면 기본 생성자, 초기화, getter, setter, toString이 자동 적용된다. */
@NoArgsConstructor      // 기본 생성자
@AllArgsConstructor     // 모든 필드 초기화
@Setter                 // setter
@Getter                 // getter
@ToString               // toString

/* Data 어노테이션은 모두 포함되어 있지만 권장은 하지 않는다. */
@Data
public class MemberDTO {
    private int sequence;

    private String id;

    private String pwd;

    private String name;
}
