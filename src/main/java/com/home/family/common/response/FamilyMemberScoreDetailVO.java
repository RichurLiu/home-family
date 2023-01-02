package com.home.family.common.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Project : home-family
 * @Package : com.home.family.common.vo
 * @Author : richur
 * @Date : 2023/1/2 11:32 上午
 */
@Setter
@Getter
public class FamilyMemberScoreDetailVO implements Serializable {

    /**
     * 成员ID
     */
    private String username;

    /**
     * 积分变动描述
     */
    private String changeDescription;

    /**
     * 工作成员ID
     */
    private String workUsername;

    /**
     * 积分
     */
    private Long score;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
