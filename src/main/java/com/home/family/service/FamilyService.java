package com.home.family.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.home.family.common.request.FamilyInformationRequest;
import com.home.family.common.request.FamilyMemberInformationRequest;
import com.home.family.common.response.FamilyInformationVO;
import com.home.family.dal.dao.IFamilyInformationDAO;
import com.home.family.dal.entity.FamilyInformation;
import com.home.family.dal.entity.FamilyMemberInformation;
import com.home.family.dal.entity.FamilyMemberScoreDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Project : home-family
 * @Package : com.home.family.service
 * @Author : richur
 * @Date : 2023/1/2 5:21 下午
 */
@Service
public class FamilyService {
    @Resource
    private IFamilyInformationDAO familyInformationDAO;

    public void addFamilyInfo(FamilyInformationRequest request) {
        FamilyInformation info = new FamilyInformation();
        info.setFamilyId(UUID.randomUUID().toString());
        info.setFamilyName(request.getFamilyName());
        info.setFamilyDescription(request.getFamilyDescription());
        familyInformationDAO.save(info);
    }


    public FamilyInformationVO getFamilyInfo(String familyId) {
        FamilyInformation familyInfo = familyInformationDAO.findByFamilyId(familyId);
        FamilyInformationVO vo = new FamilyInformationVO();
        vo.setFamilyId(familyInfo.getFamilyId());
        vo.setFamilyName(familyInfo.getFamilyName());
        vo.setFamilyDescription(familyInfo.getFamilyDescription());
        vo.setCreateTime(familyInfo.getCreateTime());
        return vo;
    }

    public List<FamilyInformationVO> getFamilyInfoList() {
        List<FamilyInformation> list = familyInformationDAO.list();
        List<FamilyInformationVO> informationVOList = new ArrayList<>();
        for (FamilyInformation info : list) {
            FamilyInformationVO vo = new FamilyInformationVO();
            vo.setFamilyId(info.getFamilyId());
            vo.setFamilyName(info.getFamilyName());
            vo.setFamilyDescription(info.getFamilyDescription());
            vo.setCreateTime(info.getCreateTime());
            informationVOList.add(vo);
        }
        return informationVOList;
    }




}
