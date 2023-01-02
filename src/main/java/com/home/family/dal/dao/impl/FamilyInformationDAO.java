package com.home.family.dal.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.home.family.dal.entity.FamilyInformation;
import com.home.family.dal.entity.FamilyMemberInformation;
import com.home.family.dal.mapper.FamilyInformationMapper;
import com.home.family.dal.dao.IFamilyInformationDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 家庭信息 服务实现类
 * </p>
 *
 * @author home-family-generator
 * @since 2023-01-01
 */
@Service
public class FamilyInformationDAO extends ServiceImpl<FamilyInformationMapper, FamilyInformation> implements IFamilyInformationDAO {

    @Override
    public FamilyInformation findByFamilyId(String familyId) {
        LambdaQueryWrapper<FamilyInformation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(FamilyInformation::getFamilyId, familyId);
        return getOne(wrapper);
    }
}
