package com.example.imran.Library.Management.System.service;

import com.example.imran.Library.Management.System.dto.MemberDto;
import com.example.imran.Library.Management.System.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    void addMember(MemberDto memberDto);
    void updateMember(Long id, MemberDto memberDto);
    List<Member>  viewAllMembers();
    Member viewMemberByMembershipId(String membershipId);
}
