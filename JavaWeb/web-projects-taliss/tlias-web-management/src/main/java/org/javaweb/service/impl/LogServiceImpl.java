package org.javaweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.javaweb.mapper.LogMapper;
import org.javaweb.pojo.*;
import org.javaweb.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public Result selectLogPage(LogQueryParam param) {
        if (param == null) {
            log.warn("参数不能为空");
            throw new BusinessException("参数不能为空");
        }

        // 使用 PageHelper 进行分页
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<LogOption> logs = logMapper.selectAllLog();

        // 获取分页信息
        PageInfo<LogOption> pageInfo = new PageInfo<>(logs);

        // 封装到 PageResult
        PageResult<LogOption> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setRows(pageInfo.getList());

        return Result.success(pageResult);
    }
}
