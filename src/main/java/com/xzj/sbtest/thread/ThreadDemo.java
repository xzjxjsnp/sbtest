package com.xzj.sbtest.thread;

import com.xzj.sbtest.entity.ThreadResultDO;
import lombok.Data;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class ThreadDemo {
    private static ThreadDemo ourInstance = new ThreadDemo();

    public static ThreadDemo getInstance() {
        return ourInstance;
    }

    private short sequence = -1;

    private List<ThreadResultDO> threadResultDOList = new LinkedList<>();

    private ThreadDemo() {
    }

    public short nextSequence() {
        sequence++;
        return sequence;
    }

    public String nextId(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        DecimalFormat df = new DecimalFormat("000");

        short sequenceNo = nextSequence();
        return "5513" + "-" + timestamp + "-" + df.format(sequenceNo);
    }
}
