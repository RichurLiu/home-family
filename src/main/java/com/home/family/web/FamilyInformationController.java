package com.home.family.web;

import com.home.family.common.ResultResponse;
import com.home.family.common.request.FamilyInformationRequest;
import com.home.family.common.response.FamilyInformationVO;
import com.home.family.service.FamilyService;
import org.springframework.web.bind.annotation.GetMapping;
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
 * @Date : 2023/1/1 11:05 下午
 */
@RestController
@RequestMapping(path = "family/")
public class FamilyInformationController {

    @Resource
    private FamilyService familyService;

    @GetMapping(path = "info/detail")
    public ResultResponse<FamilyInformationVO> getFamilyInfo(@RequestParam String familyId) {
        FamilyInformationVO familyInfo = familyService.getFamilyInfo(familyId);
        return ResultResponse.success(familyInfo);
    }

    @GetMapping(path = "info/list")
    public ResultResponse<List<FamilyInformationVO>> getFamilyInfoList() {
        List<FamilyInformationVO> familyInfoList = familyService.getFamilyInfoList();
        return ResultResponse.success(familyInfoList);
    }

    @PutMapping(path = "info/detail")
    public ResultResponse<Boolean> addFamilyInfo(@RequestBody FamilyInformationRequest request) {
        familyService.addFamilyInfo(request);
        return ResultResponse.success(true);
    }
}
