package com.example.imran.Library.Management.System.controller;

import com.example.imran.Library.Management.System.dto.MemberDto;
import com.example.imran.Library.Management.System.entity.Member;
import com.example.imran.Library.Management.System.service.MemberService;
import com.example.imran.Library.Management.System.util.ApiResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @PostMapping("/add-member")
    public ResponseEntity<Map<String, String>> addMember(@Valid @RequestBody MemberDto memberDto){
        memberService.addMember(memberDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.apiResponse("Member added successfully"));
    }
    @PutMapping("/update-member/{id}")
    public ResponseEntity<Map<String, String>> updateMember(@PathVariable Long id, @Valid @RequestBody MemberDto memberDto){
        memberService.updateMember(id, memberDto);
        return ResponseEntity.ok(ApiResponse.apiResponse(memberDto.getMemberName() + "'s record updated successfully"));
    }
    @GetMapping("/view-all-members")
    public ResponseEntity<List<Member>> viewAllMembers(){
        return ResponseEntity.ok(memberService.viewAllMembers());
    }
    @GetMapping("/view-member-by-membership-id/{membershipId}")
    public ResponseEntity<Member> viewMemberByMembershipId(@PathVariable String membershipId){
        return ResponseEntity.ok(memberService.viewMemberByMembershipId(membershipId));
    }
}
