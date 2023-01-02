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
 * 家庭成员信息
 * </p>
 *
 * @author home-family-generator
 * @since 2023-01-01
 */
@Setter
@Getter
@TableName("family_member_information")
public class FamilyMemberInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 成员ID
     */
    private String userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 姓名
     */
    private String username;

    /**
     * 称谓
     */
    private String appellation;

    /**
     * 积分
     */
    private Long score;

    /**
     * 家庭ID
     */
    private String familyId;

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
