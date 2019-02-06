package com.sun.springcloudclient.controller;

import com.sun.springcloudclient.constants.Constants;
import com.sun.springcloudclient.model.Message;
import com.sun.springcloudclient.model.Response;
import com.sun.springcloudclient.model.TestSlave;
import com.sun.springcloudclient.service.SlaveService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @class: KafkaController
 * @description:
 * @author: Jay Sun
 * @time: 2019-02-06 14:17
 **/
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Resource
    private SlaveService slaveService;

    @PostMapping("/add")
    public Response addIndex(@RequestBody TestSlave testSlave) {
        Message message = new Message();
        message.setId(testSlave.getId().toString());
        message.setAction(Constants.add_index);
        message.setSendTime(new Date());
        message.setBody(testSlave);
        slaveService.sendMessage(message);
        return Response.getInstance();
    }

    @GetMapping("delete")
    public Response deleteIndex(Integer id) {
        Message message = new Message();
        message.setId(id.toString());
        message.setAction(Constants.delete_index);
        slaveService.sendMessage(message);
        return Response.getInstance();
    }

    @PostMapping("update")
    public Response updateIndex(@RequestBody TestSlave testSlave) {
        Message message = new Message();
        message.setId(testSlave.getId().toString());
        message.setAction(Constants.update_index);
        message.setSendTime(new Date());
        message.setBody(testSlave);
        slaveService.sendMessage(message);
        return Response.getInstance();
    }

}
