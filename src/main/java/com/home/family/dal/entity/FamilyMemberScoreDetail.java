package com.home.family.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 家庭成员积分变动明细
 * </p>
 *
 * @author home-family-generator
 * @since 2023-01-01
 */
@Setter
@Getter
@TableName("family_member_score_detail")
public class FamilyMemberScoreDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 成员ID
     */
    private String userId;

    /**
     * 积分变动描述
     */
    private String changeDescription;

    /**
     * 工作成员ID
     */
    private String workUserId;

    /**
     * 积分
     */
    private Long score;

    /**
     * 是否删除，0-否，1-是
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
