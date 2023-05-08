package com.mohacel.path_query.controller;

import com.mohacel.path_query.model.ClubMember;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClubMemberController {
    @GetMapping("/club/department/{departmentName}/member/{memberName}")
    public ResponseEntity<ClubMember> getMember(@PathVariable("departmentName") String departmentName,
                                                @PathVariable("memberName") String memberName ){
        ClubMember member= new ClubMember();
        member.setMemberId(1002);
        member.setMemberName(memberName);
        member.setDepartmentName(departmentName);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
