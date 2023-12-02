package com.example.staffmanager.demos.service.impl;

import com.example.staffmanager.demos.entity.StaffDo;
import com.example.staffmanager.demos.mapper.StaffMapper;
import com.example.staffmanager.demos.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public List<StaffDo> selectStaffList(StaffDo staffDo) {
        return staffMapper.selectStaffList(staffDo);
    }

    @Override
    public int insertStaff(StaffDo staffDo) {
        return staffMapper.insertStaff(staffDo);
    }

    @Override
    public int updateStaff(StaffDo staffDo) {
        return staffMapper.updateStaff(staffDo);
    }

    @Override
    public String importData(List<StaffDo> staffDoList) {
        staffMapper.insertStaffs(staffDoList);
        return "导入成功";
    }

    @Override
    public int deleteStaffByIds(Long[] staffIds) {
        return staffMapper.deleteStaffByIds(staffIds);
    }
}
