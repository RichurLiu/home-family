package com.home.family.service;
import java.time.LocalDateTime;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.home.family.common.request.FamilyMemberInformationRequest;
import com.home.family.common.request.MemberScoreChangeRequest;
import com.home.family.common.response.FamilyMemberDetailVO;
import com.home.family.common.response.FamilyMemberScoreDetailVO;
import com.home.family.dal.dao.IFamilyInformationDAO;
import com.home.family.dal.dao.IFamilyMemberInformationDAO;
import com.home.family.dal.dao.IFamilyMemberScoreDetailDAO;
import com.home.family.dal.entity.FamilyInformation;
import com.home.family.dal.entity.FamilyMemberInformation;
import com.home.family.dal.entity.FamilyMemberScoreDetail;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Project : home-family
 * @Package : com.home.family.service
 * @Author : richur
 * @Date : 2023/1/2 11:24 上午
 */
@Service
public class FamilyMemberService {

    @Resource
    private IFamilyMemberScoreDetailDAO familyMemberScoreDetailDAO;
    @Resource
    private IFamilyMemberInformationDAO familyMemberInformationDAO;
    @Resource
    private IFamilyInformationDAO familyInformationDAO;

    private static final Map<String, String> USERNAME_MAP = Maps.newHashMap();

    public List<FamilyMemberScoreDetailVO> getMemberScoreDetail(String userId) {
        List<FamilyMemberScoreDetail> scoreDetailList = familyMemberScoreDetailDAO.listByUserId(userId);
        return wrapperFamilyMemberScoreDetailVO(scoreDetailList);
    }

    public List<FamilyMemberScoreDetailVO> getScoreDetail() {
        List<FamilyMemberScoreDetail> scoreDetailList = familyMemberScoreDetailDAO.list();
        return wrapperFamilyMemberScoreDetailVO(scoreDetailList);
    }

    private List<FamilyMemberScoreDetailVO> wrapperFamilyMemberScoreDetailVO(List<FamilyMemberScoreDetail> scoreDetailList) {
        List<FamilyMemberScoreDetailVO> scoreDetailVOList = Lists.newArrayList();
        for (FamilyMemberScoreDetail detail : scoreDetailList) {
            FamilyMemberScoreDetailVO scoreDetailVO = new FamilyMemberScoreDetailVO();
            String userId = detail.getUserId();
            String workUserId = detail.getWorkUserId();
            String username = USERNAME_MAP.get(userId);
            String workUsername = USERNAME_MAP.get(workUserId);
            if (!StringUtils.hasLength(username)) {
                FamilyMemberInformation memberInfo = familyMemberInformationDAO.findByUserId(userId);
                username = memberInfo.getUsername();
                USERNAME_MAP.put(userId, username);
            }
            if (!StringUtils.hasLength(workUsername) && StringUtils.hasLength(workUserId)) {
                FamilyMemberInformation memberInfo = familyMemberInformationDAO.findByUserId(workUserId);
                workUsername = memberInfo.getUsername();
                USERNAME_MAP.put(workUserId, workUsername);
            }
            scoreDetailVO.setUsername(username);
            scoreDetailVO.setChangeDescription(detail.getChangeDescription());
            scoreDetailVO.setWorkUsername(workUsername);
            scoreDetailVO.setScore(detail.getScore());
            scoreDetailVO.setCreateTime(detail.getCreateTime());
            scoreDetailVOList.add(scoreDetailVO);
        }
        return scoreDetailVOList;
    }

    public void addMemberScore(MemberScoreChangeRequest request) {
        String userId = request.getUserId();
        FamilyMemberInformation memberInfo = familyMemberInformationDAO.findByUserId(userId);
        long totalScore = memberInfo.getScore() + request.getScore();
        memberInfo.setScore(totalScore);
        // todo 暂不考虑并发问题
        familyMemberInformationDAO.updateById(memberInfo);
        recordMemberScoreDetail(request);
    }

    public void consumerMemberScore(MemberScoreChangeRequest request) {
        String userId = request.getUserId();
        FamilyMemberInformation memberInfo = familyMemberInformationDAO.findByUserId(userId);
        long totalScore = memberInfo.getScore() - request.getScore();
        memberInfo.setScore(totalScore);
        // todo 暂不考虑并发问题
        familyMemberInformationDAO.updateById(memberInfo);
        recordMemberScoreDetail(request);
    }

    public FamilyMemberDetailVO getFamilyMemberDetail(String userId) {
        FamilyMemberInformation memberInfo = familyMemberInformationDAO.findByUserId(userId);
        String familyId = memberInfo.getFamilyId();
        FamilyInformation familyInfo = familyInformationDAO.findByFamilyId(familyId);
        FamilyMemberDetailVO vo = new FamilyMemberDetailVO();
        vo.setUserId(memberInfo.getUserId());
        vo.setNickname(memberInfo.getNickname());
        vo.setUsername(memberInfo.getUsername());
        vo.setAppellation(memberInfo.getAppellation());
        vo.setScore(memberInfo.getScore());
        vo.setFamilyName(familyInfo.getFamilyName());
        vo.setCreateTime(memberInfo.getCreateTime());
        return vo;
    }

    public List<FamilyMemberDetailVO> getFamilyMemberDetailList(String familyId) {
        List<FamilyMemberInformation> memberInfoList = familyMemberInformationDAO.findByFamilyId(familyId);
        FamilyInformation familyInfo = familyInformationDAO.findByFamilyId(familyId);
        List<FamilyMemberDetailVO> voList = new ArrayList<>();
        for (FamilyMemberInformation memberInfo : memberInfoList) {
            FamilyMemberDetailVO vo = new FamilyMemberDetailVO();
            vo.setUserId(memberInfo.getUserId());
            vo.setNickname(memberInfo.getNickname());
            vo.setUsername(memberInfo.getUsername());
            vo.setAppellation(memberInfo.getAppellation());
            vo.setScore(memberInfo.getScore());
            vo.setFamilyName(familyInfo.getFamilyName());
            vo.setCreateTime(memberInfo.getCreateTime());
            voList.add(vo);
        }
        return voList;
    }


    private void recordMemberScoreDetail(MemberScoreChangeRequest request) {
        FamilyMemberScoreDetail scoreDetail = new FamilyMemberScoreDetail();
        scoreDetail.setUserId(request.getUserId());
        scoreDetail.setChangeDescription(request.getChangeDescription());
        scoreDetail.setWorkUserId(request.getWorkUserId());
        scoreDetail.setScore(request.getScore());
        familyMemberScoreDetailDAO.save(scoreDetail);
    }

    public void addFamilyMemberInfo(FamilyMemberInformationRequest request) {
        FamilyMemberInformation memberInfo = new FamilyMemberInformation();
        memberInfo.setUserId(UUID.randomUUID().toString());
        memberInfo.setNickname(request.getNickname());
        memberInfo.setUsername(request.getUsername());
        memberInfo.setAppellation(request.getAppellation());
        memberInfo.setFamilyId(request.getFamilyId());
        familyMemberInformationDAO.save(memberInfo);
    }
}
