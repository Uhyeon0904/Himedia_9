package com.ohgiraffers.restapi.section03.valid;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private int no;
    @NotNull(message = "아이디는 반드시 입력되어야 합니다.")
    /* @NotBlank: 공백이면 안 된다.(값이 비어있을 때는 Blank)
    * ex) "id": "", 이런 형태*/
    @NotBlank(message = "아이디는 공백일 수 없습니다.")
    private String id;
    @Length(max = 10, message = "비밀번호 길이는 10을 초과할 수 없습니다.")
    @NotNull(message = "비밀번호는 반드시 입력되어야 합니다.")
    @NotBlank(message = "비밀번호는 공백일 수 없습니다.")
    private String pwd;
    @Size(max = 10, message = "이름은 길이 10을 초과할 수 없습니다.")
    @NotNull(message = "이름은 반드시 입력되어야 합니다.")
    @NotBlank(message = "이름은 공백일 수 없습니다.")
    private String name;
    /* @Past: 현재 시점보다는 과거 날짜 @Future: 현재 시점보다는 미래 날짜가 들어와야한다. */
    @Past(message = "가입일은 현재보다 과거 날짜가 입력 되어야 합니다.")
    private Date enrollDate;
}
