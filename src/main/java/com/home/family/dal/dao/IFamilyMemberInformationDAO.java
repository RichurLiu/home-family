package com.home.family.dal.dao;

import com.home.family.dal.entity.FamilyMemberInformation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 家庭成员信息 服务类
 * </p>
 *
 * @author home-family-generator
 * @since 2023-01-01
 */
public interface IFamilyMemberInformationDAO extends IService<FamilyMemberInformation> {

    FamilyMemberInformation findByUserId(String userId);

    List<FamilyMemberInformation> findByFamilyId(String familyId);
}
