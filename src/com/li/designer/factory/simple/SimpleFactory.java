package com.li.designer.factory.simple;

public class SimpleFactory {

    public static Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }

    public static void main(String[] args) {

        Sender mail = SimpleFactory.produce("mail");
        mail.send();
    }
}//http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html


interface Sender {
    void send();
}

class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is mail sender!");
    }
}

class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is sms sender");
    }
}