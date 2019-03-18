package com.li.designer.factory.abstrac;

/**
 *
 */
public class IAbstractFactory {

    public static void main(String[] args) {

        Provider p = new SendMailFactory();
        Sender s = p.produce();
        s.send();

    }
}

interface Sender{
    void send();
}

class MailSender implements Sender{

    @Override
    public void send() {
        System.out.println("this is mail sender");
    }
}

class SmsSender implements Sender{

    @Override
    public void send() {
        System.out.println("this is sms sender");
    }
}

interface Provider {
    Sender produce();
}

class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}

class SendMailFactory implements Provider{

    @Override
    public Sender produce() {
        return new MailSender();
    }
}
