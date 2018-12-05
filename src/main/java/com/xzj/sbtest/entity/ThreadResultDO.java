package com.xzj.sbtest.entity;

import lombok.Data;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class ThreadResultDO {
    private static ThreadResultDO ourInstance = new ThreadResultDO();

    public static ThreadResultDO getInstance() {
        return ourInstance;
    }

    private short sequence = -1;

    private List<String> threadResult = new LinkedList<>();

    private ThreadResultDO() {
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
        return "5513" + timestamp + df.format(sequenceNo);
    }
}
