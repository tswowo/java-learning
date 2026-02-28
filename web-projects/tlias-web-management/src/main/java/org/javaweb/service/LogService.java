package org.javaweb.service;

import org.javaweb.pojo.LogQueryParam;
import org.javaweb.pojo.Result;

public interface LogService {
    Result selectLogPage(LogQueryParam param);
}
