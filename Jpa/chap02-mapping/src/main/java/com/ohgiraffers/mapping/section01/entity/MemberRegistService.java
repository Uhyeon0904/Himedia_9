package com.ohgiraffers.mapping.section01.entity;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MemberRegistService {

    public MemberRepository memberRepository;

    public MemberRegistService (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
        /* resistMember() 전달 받는 곳은 DTO 타입으로 받아와서 가공 후
         memberRepository.save(); 엔티티 타입을 넣어줘야 한다. */
    public void registMember(MemberRegistDTO newMember) {
        Member member = new Member(
                newMember.getMemberId(),
                newMember.getMemberPwd(),
                newMember.getMemberName(),
                newMember.getPhone(),
                newMember.getAddress(),
                newMember.getEnrollDate(),
                newMember.getMemberRole(),
                newMember.getStatus()
        );
        memberRepository.save(member);
    }

    @Transactional
    public String registMemberAndFindName(MemberRegistDTO newMember) {
        registMember(newMember);
        return memberRepository.findNameById(newMember.getMemberId());
    }
}
