package org.javaweb.service.impl;

import org.javaweb.mapper.EmpMapper;
import org.javaweb.pojo.ClazzOption;
import org.javaweb.pojo.JobOption;
import org.javaweb.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public Object getEmpGenderDate() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public Object getEmpJobDate() {
        List<Map<String, Object>> jobMapData = empMapper.countEmpJobData();
        List<String> jobList = jobMapData.stream().map(map -> map.get("pos").toString()).toList();
        List<Integer> dataList = jobMapData.stream().map(map -> Integer.parseInt(String.valueOf(map.get("total")))).toList();

        return new JobOption<String, Integer>(jobList, dataList);
    }

    @Override
    public Object getStudentDegreeData() {
        return empMapper.countStudentDegreeData();
    }

    @Override
    public Object getStudentCountData() {
        List<Map<String, Object>> clazzMapData = empMapper.countStudentCountData();
        List<String> clazzList = clazzMapData.stream().map(map -> map.get("clazz").toString()).toList();
        List<Integer> dataList = clazzMapData.stream().map(map -> Integer.parseInt(String.valueOf(map.get("total")))).toList();
        return new ClazzOption<String, Integer>(clazzList, dataList);
    }

}
