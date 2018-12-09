package com.xzj.sbtest.entity;

import lombok.Data;

/**
 * ThreadResultDO class
 *
 * @author ppx
 * @date 2018/12/09
 */
@Data
public class ThreadResultDO {
    private String threadName;
    private String threadPrefix;
    private String threadTimestamp;
    private String threadCode;
}
