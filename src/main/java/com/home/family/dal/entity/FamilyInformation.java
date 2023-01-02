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
 * 家庭信息
 * </p>
 *
 * @author home-family-generator
 * @since 2023-01-01
 */
@Setter
@Getter
@TableName("family_information")
public class FamilyInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 家庭ID
     */
    private String familyId;

    /**
     * 家庭名称
     */
    private String familyName;

    /**
     * 家庭描述
     */
    private String familyDescription;

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
