package com.jun.app.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by zz on 2017/8/16.
 */
public class QueueMessageListener implements MessageListener {


    public void onMessage(Message message) {
        TextMessage tm= (TextMessage) message;
        try {
            System.out.println("QueueMessageListener监听到了文本消息：\t"+ tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
