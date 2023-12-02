package com.example.staffmanager.demos.entity;

import com.example.staffmanager.demos.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class StaffDo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @Excel(name = "职工名称")
    private String empName;
    @Excel(name = "性别")
    private String sex;
    @Excel(name = "年龄")
    private Integer age;
    @Excel(name = "部门名称")
    private String deptName;
    @Excel(name = "学历")
    private String empDegreeName;
    private Integer pageNum;
    private Integer pageSize;
}
