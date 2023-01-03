package com.home.family.dal.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.home.family.dal.entity.FamilyMemberScoreDetail;
import com.home.family.dal.mapper.FamilyMemberScoreDetailMapper;
import com.home.family.dal.dao.IFamilyMemberScoreDetailDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 家庭成员积分变动明细 服务实现类
 * </p>
 *
 * @author home-family-generator
 * @since 2023-01-01
 */
@Service
public class FamilyMemberScoreDetailDAO extends ServiceImpl<FamilyMemberScoreDetailMapper, FamilyMemberScoreDetail> implements IFamilyMemberScoreDetailDAO {

    @Override
    public List<FamilyMemberScoreDetail> listByUserId(String userId){
        LambdaQueryWrapper<FamilyMemberScoreDetail> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(FamilyMemberScoreDetail::getUserId, userId);
        return list(wrapper);
    }
}
