package com.itheima.service.impl;

import com.itheima.dao.LogDao;
import com.itheima.pojo.Log;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Override
    public List<Log> parseLog() {
        List<String>lines=logDao.getLogList();
        List<Log> logList=lines.stream().map(line -> {
            String[] parts=line.split(",");
            return new Log(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6]);
        }).toList();
        return logList;
    }
}
