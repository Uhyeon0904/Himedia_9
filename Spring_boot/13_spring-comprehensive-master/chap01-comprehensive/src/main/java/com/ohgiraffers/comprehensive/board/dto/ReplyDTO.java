package com.ohgiraffers.comprehensive.board.dto;

import com.ohgiraffers.comprehensive.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class ReplyDTO {

    private Long replyNo;
    private Long refBoardNo;
    private String replyBody;
    private MemberDTO writer;
    private String replyStatus;
    private LocalDateTime createdDate;
}
