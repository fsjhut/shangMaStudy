package javasm;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author:sunhang
 * @className: Producer
 * @description:
 * @date: 2021-08-10 11:15
 * @version:0.1
 * @since: 1.8
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        //声明并初始化一个producer
        //需要一个producer group名字作为构造方法的参数
        DefaultMQProducer producer = new DefaultMQProducer("javasm_producer");
        //设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用；分隔
        //producer.setNamesrvAddr("192.168.13.141:9876;192.168.13.137:9876");
        producer.setNamesrvAddr("192.168.74.128:9876");
        //调用start()方法启动一个producer实例
        producer.start();
        //发送10条消息到Topic为TopicTest，tag为TagA
        for (int i = 0; i < 10; i++) {
            try {
                Message msg = new Message("TopicTest",// topic
                        "TagA",// tag
                        ("Hello Javasm RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)// body
                );
                //调用producer的send()方法发送消息
                //这里调用的是同步的方式，所以会有返回结果
                SendResult sendResult = producer.send(msg);
                //打印返回结果，可以看到消息发送的状态以及一些相关信息
                System.out.println(sendResult);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }
        //发送完消息之后，调用shutdown()方法关闭producer
        producer.shutdown();
    }
}


