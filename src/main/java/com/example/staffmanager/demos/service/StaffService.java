package com.example.staffmanager.demos.service;


import com.example.staffmanager.demos.entity.StaffDo;

import java.util.List;

public interface StaffService {
    List<StaffDo> selectStaffList(StaffDo staffDo);

    int insertStaff(StaffDo staffDo);

    int updateStaff(StaffDo staffDo);

    String importData(List<StaffDo> staffDoList);

    int deleteStaffByIds(Long[] staffIds);
}
