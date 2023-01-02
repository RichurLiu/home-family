package com.home.family.dal.dao;

import com.home.family.dal.entity.FamilyInformation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 家庭信息 服务类
 * </p>
 *
 * @author home-family-generator
 * @since 2023-01-01
 */
public interface IFamilyInformationDAO extends IService<FamilyInformation> {

    FamilyInformation findByFamilyId(String familyId);
}
