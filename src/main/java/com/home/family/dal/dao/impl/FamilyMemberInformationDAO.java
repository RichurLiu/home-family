package com.home.family.dal.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.home.family.dal.entity.FamilyMemberInformation;
import com.home.family.dal.mapper.FamilyMemberInformationMapper;
import com.home.family.dal.dao.IFamilyMemberInformationDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 家庭成员信息 服务实现类
 * </p>
 *
 * @author home-family-generator
 * @since 2023-01-01
 */
@Service
public class FamilyMemberInformationDAO extends ServiceImpl<FamilyMemberInformationMapper, FamilyMemberInformation> implements IFamilyMemberInformationDAO {

    @Override
    public FamilyMemberInformation findByUserId(String userId) {
        LambdaQueryWrapper<FamilyMemberInformation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(FamilyMemberInformation::getUserId, userId);
        return getOne(wrapper);
    }

    @Override
    public List<FamilyMemberInformation> findByFamilyId(String familyId){
        LambdaQueryWrapper<FamilyMemberInformation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(FamilyMemberInformation::getFamilyId, familyId);
        return list(wrapper);
    }
}
