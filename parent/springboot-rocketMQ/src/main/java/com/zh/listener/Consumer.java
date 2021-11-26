package com.zh.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;


@Component
@RocketMQMessageListener(topic = "TopicName",
		consumerGroup = "consumer-groupA",
		selectorExpression = "*")
public class Consumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        //log.info("Receive message：" + message);
        System.out.println("消费者消费监听！"+message);
		//如果消费失败，则抛出RuntimeException，RocketMQ会自动重试
		//可以手动抛出，也可以使用 Lombok 的 @SneakyThrows 注解来抛出 RuntimeException
		//throw new RuntimeException("消费失败");
    }
}
