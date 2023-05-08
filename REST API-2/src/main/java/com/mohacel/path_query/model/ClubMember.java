package com.mohacel.path_query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubMember {
    private Integer memberId;
    private String departmentName;
    private String memberName;
}
