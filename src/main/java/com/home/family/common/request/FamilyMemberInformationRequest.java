package com.home.family.common.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Project : home-family
 * @Package : com.home.family.common.request
 * @Author : richur
 * @Date : 2023/1/2 7:52 下午
 */
@Setter
@Getter
public class FamilyMemberInformationRequest {
    private String nickname;
    private String username;
    private String appellation;
    private String familyId;
}
