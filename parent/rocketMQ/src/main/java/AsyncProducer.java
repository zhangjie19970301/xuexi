import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
//发送异步消息
public class AsyncProducer {
	public static void main(String[] args) throws Exception {
    	// 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("groupB");
    	// 设置NameServer的地址
        producer.setNamesrvAddr("47.106.185.191:9876");
        // 设置消息异步发送失败时的重试次数，默认为 2
        producer.setRetryTimesWhenSendAsyncFailed(2);
        // 设置消息发送超时时间，默认3000ms
        producer.setSendMsgTimeout(3000);
    	// 启动Producer实例
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
    	for (int i = 0; i < 100; i++) {
                final int index = i;
            	// 创建消息，并指定Topic，Tag和消息体A
                Message msg = new Message("TopicA",
                    "TagA",
                    "OrderID188",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
                // SendCallback接收异步返回结果的回调
                producer.send(msg, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                    }
                    @Override
                    public void onException(Throwable e) {
      	              System.out.printf("%-10d Exception %s %n", index, e);
      	              e.printStackTrace();
                    }
            	});
    	}
    	// 如果不再发送消息，关闭Producer实例。
    	//producer.shutdown();
    }
}
