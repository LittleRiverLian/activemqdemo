package com.jun.app.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by zz on 2017/8/16.
 */
@Service
public class ProducerService {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 向指定队列发送消息
     * @param destination
     * @param msg
     */
    public void sendMessage(Destination destination,final String msg){
        System.out.println("向队列"+destination.toString()+"发送了消息---------------"+msg);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

    /**
     * 向默认队列发送消息
     * @param msg
     */
    public void sendMessage(final String msg){
        String destination=jmsTemplate.getDefaultDestination().toString();
        System.out.println("向队列"+destination.toString()+"发送了消息---------------"+msg);
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

}
