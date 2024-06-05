package com.ohgiraffers.comprehensive.board.dto;

import com.ohgiraffers.comprehensive.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class BoardDTO {

    private Long boardNo;
    private Integer boardType;
    private Long categoryCode;
    private CategoryDTO category;
    private String boardTitle;
    private String boardBody;
    private Long boardWriterMemberNo;
    private MemberDTO writer;
    private int boardCount;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String boardStatus;
    private List<ReplyDTO> replyList;
    private List<AttachmentDTO> attachmentList;

}
