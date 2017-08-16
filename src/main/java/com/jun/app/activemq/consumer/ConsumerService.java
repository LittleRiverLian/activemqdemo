package com.jun.app.activemq.consumer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by zz on 2017/8/16.
 */
@Service
public class ConsumerService {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 接收消息
     * @param destination
     * @return
     */
    public TextMessage receive(Destination destination){
        TextMessage tm= (TextMessage) jmsTemplate.receive(destination);
        try {
            System.out.println("从队列"+destination.toString()+"收到了消息:\t"+tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return tm;
    }
}
