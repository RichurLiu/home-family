package com.home.family.common.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Project : home-family
 * @Package : com.home.family.common.response
 * @Author : richur
 * @Date : 2023/1/2 5:26 下午
 */
@Setter
@Getter
public class FamilyInformationVO implements Serializable {
    private String familyId;
    private String familyName;
    private String familyDescription;
    private LocalDateTime createTime;
}
