package com.home.family.web;

import com.home.family.common.ResultResponse;
import com.home.family.common.request.FamilyMemberInformationRequest;
import com.home.family.common.request.MemberScoreChangeRequest;
import com.home.family.common.response.FamilyMemberDetailVO;
import com.home.family.common.response.FamilyMemberScoreDetailVO;
import com.home.family.service.FamilyMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Project : home-family
 * @Package : com.home.family.web
 * @Author : richur
 * @Date : 2023/1/1 11:17 下午
 */
@RestController
@RequestMapping(path = "family/member/")
public class FamilyMemberController {
    @Resource
    private FamilyMemberService familyMemberService;

    @GetMapping(path = "score/detail")
    public ResultResponse<List<FamilyMemberScoreDetailVO>> getScoreDetail() {
        List<FamilyMemberScoreDetailVO> list = familyMemberService.getScoreDetail();
        return ResultResponse.success(list);
    }

    @PostMapping(path = "score/add")
    public ResultResponse<Boolean> addMemberScore(@RequestBody MemberScoreChangeRequest request) {
        familyMemberService.addMemberScore(request);
        return ResultResponse.success(true);
    }


    @PostMapping(path = "score/consumer")
    public ResultResponse<Boolean> consumerMemberScore(@RequestBody MemberScoreChangeRequest request) {
        familyMemberService.consumerMemberScore(request);
        return ResultResponse.success(true);
    }

    @GetMapping(path = "info/detail")
    public ResultResponse<FamilyMemberDetailVO> getFamilyMemberInfo(@RequestParam String userId) {
        FamilyMemberDetailVO familyMemberDetail = familyMemberService.getFamilyMemberDetail(userId);
        return ResultResponse.success(familyMemberDetail);
    }

    @GetMapping(path = "info/detail/list")
    public ResultResponse<List<FamilyMemberDetailVO>> getFamilyMemberInfoList(@RequestParam String familyId) {
        List<FamilyMemberDetailVO> familyMemberDetailList = familyMemberService.getFamilyMemberDetailList(familyId);
        return ResultResponse.success(familyMemberDetailList);
    }

    @PutMapping(path = "info/detail")
    public ResultResponse<Boolean> addFamilyMemberInfo(@RequestBody FamilyMemberInformationRequest request) {
        familyMemberService.addFamilyMemberInfo(request);
        return ResultResponse.success(true);
    }
}
