package com.example.imran.Library.Management.System.service.serviceImpl;

import com.example.imran.Library.Management.System.dto.MemberDto;
import com.example.imran.Library.Management.System.entity.Member;
import com.example.imran.Library.Management.System.exception.ResourceNotFoundException;
import com.example.imran.Library.Management.System.repository.MemberRepository;
import com.example.imran.Library.Management.System.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public void addMember(MemberDto memberDto) {
        Member member = new Member();
        member.setMemberName(memberDto.getMemberName());
        member.setMemberEmail(memberDto.getMemberEmail());
        member.setMemberContactNumber(memberDto.getMemberContactNumber());
        member.setMembershipId(memberDto.getMembershipId());
        memberRepository.save(member);
    }

    @Override
    public void updateMember(Long id, MemberDto memberDto) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No member found with given id"));
        member.setMemberName(memberDto.getMemberName());
        member.setMemberEmail(memberDto.getMemberEmail());
        member.setMemberContactNumber(memberDto.getMemberContactNumber());
        member.setMembershipId(memberDto.getMembershipId());
        memberRepository.save(member);
    }

    @Override
    public List<Member> viewAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member viewMemberByMembershipId(String membershipId) {
        Member member = memberRepository.findMemberByMembershipId(membershipId);
        if (member == null)
            throw new ResourceNotFoundException("No member found with given membership id");
        return member;
    }
}
