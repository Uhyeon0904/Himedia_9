package com.ohgiraffers.restapi.section04.hateoas;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private int no;
    private String id;
    private String pwd;
    private String name;
    private Date enrollDate;
}
