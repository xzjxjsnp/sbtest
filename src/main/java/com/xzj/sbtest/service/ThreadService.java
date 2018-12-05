package com.xzj.sbtest.service;

import java.util.List;

public interface ThreadService {
    List<String> threadTest(Integer threadNum) throws InterruptedException;
}
