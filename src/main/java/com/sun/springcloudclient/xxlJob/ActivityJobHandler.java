package com.sun.springcloudclient.xxlJob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @class: ActivityJobHandler
 * @description: test xxljob demo
 * @author: Jay Sun
 * @time: 2019-02-03 18:32
 **/
@Component
@JobHandler(value = "activityJobHandler")
public class ActivityJobHandler extends IJobHandler {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ReturnT<String> execute(String s) {
        System.out.println("XXL-job运行：" + atomicInteger.addAndGet(1));
        return ReturnT.SUCCESS;
    }

}
