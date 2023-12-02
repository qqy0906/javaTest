package com.example.staffmanager.demos.web;

import com.example.staffmanager.demos.entity.AjaxResult;
import com.example.staffmanager.demos.entity.StaffDo;
import com.example.staffmanager.demos.poi.ExcelUtil;
import com.example.staffmanager.demos.service.StaffService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api("职工信息")
@RequestMapping("/staff")
@RestController
public class StaffCountroller {
    @Autowired
    private StaffService staffServiceImpl;


    @ApiOperation("获取职工列表")
    @PostMapping("/getStaffList")
    public AjaxResult selectStaffList(@RequestBody StaffDo staffDo){
        PageHelper.startPage(staffDo.getPageNum(), staffDo.getPageSize());
        List<StaffDo> staffDos = staffServiceImpl.selectStaffList(staffDo);
        PageInfo<StaffDo> staffDoPageInfo = new PageInfo<>(staffDos);
        return AjaxResult.success(staffDoPageInfo);
    }

    @PostMapping("/export")
    public void export(HttpServletResponse response, StaffDo staffDo)
    {
        staffDo.setPageNum(null);
        staffDo.setPageSize(null);
        List<StaffDo> staffDos = staffServiceImpl.selectStaffList(staffDo);
        ExcelUtil<StaffDo> util = new ExcelUtil<StaffDo>(StaffDo.class);
        util.exportExcel(response, staffDos, "职工数据");
    }

    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<StaffDo> util = new ExcelUtil<StaffDo>(StaffDo.class);
        List<StaffDo> staffDoList = util.importExcel(file.getInputStream());
        String message = staffServiceImpl.importData(staffDoList);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<StaffDo> util = new ExcelUtil<StaffDo>(StaffDo.class);
        util.importTemplateExcel(response, "职工数据");
    }

    @ApiOperation("新增职工信息")
    @PostMapping("/insertStaff")
    public AjaxResult insertStaff(@RequestBody StaffDo staffDo){
        int rows = staffServiceImpl.insertStaff(staffDo);
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @ApiOperation("修改职工信息")
    @PostMapping("/updateStaff")
    public AjaxResult updateStaff(@RequestBody StaffDo staffDo){
        int rows = staffServiceImpl.updateStaff(staffDo);
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @ApiOperation("删除职工信息")
    @DeleteMapping("/{staffIds}")
    public AjaxResult remove(@PathVariable Long[] staffIds)
    {
        int rows = staffServiceImpl.deleteStaffByIds(staffIds);
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
