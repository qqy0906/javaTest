package com.example.staffmanager.demos.mapper;

import com.example.staffmanager.demos.entity.StaffDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffMapper {

    List<StaffDo> selectStaffList(StaffDo staffDo);

    int insertStaff(StaffDo staffDo);

    int updateStaff(StaffDo staffDo);

    int deleteStaffByIds(@Param("staffIds") Long[] staffIds);

    void insertStaffs(@Param("staffDoList") List<StaffDo> staffDoList);
}
