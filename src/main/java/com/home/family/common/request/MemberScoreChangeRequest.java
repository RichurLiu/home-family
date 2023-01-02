package com.home.family.common.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @Project : home-family
 * @Package : com.home.family.common.request
 * @Author : richur
 * @Date : 2023/1/2 12:42 下午
 */
@Setter
@Getter
public class MemberScoreChangeRequest {
    private String userId;
    private String workUserId;
    private String changeDescription;
    private Long score;
}
