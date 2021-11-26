package com.zh.controller;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class ProducerTest {

	//自动注入
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/send")
    public void sendSyncMessage() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
    	//构建消息
    	Message message = new Message("TopicName", "Tag", "hash", "msgData".getBytes());
    	
    	//发送同步消息 
    	//方法1：使用与第三章相同的方法，调用 getProducer() 方法时会返回DefaultMQProducer对象，然后调用其方法第三章的一样了。
        SendResult sendResult =  rocketMQTemplate.getProducer().send(message);

		//方法2：使用rocketMQTemplate封装的消息发送方法
		// 第一个参数指定Topic与Tag，格式: `topicName:tags`
		// 第二个参数，Message对象
		sendResult = rocketMQTemplate.syncSend("TopicName:Tag", message);
    }
}
