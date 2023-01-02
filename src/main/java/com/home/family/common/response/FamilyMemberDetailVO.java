package com.home.family.common.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Project : home-family
 * @Package : com.home.family.common.response
 * @Author : richur
 * @Date : 2023/1/2 4:57 下午
 */
@Setter
@Getter
public class FamilyMemberDetailVO implements Serializable {
    private String userId;

    private String nickname;

    private String username;

    private String appellation;

    private Long score;

    private String familyName;

    private LocalDateTime createTime;
}
