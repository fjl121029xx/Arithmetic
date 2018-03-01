package com.li.queue;

public class SQType {

    public static final int QUEUELEN = 15;

    DATA4[] data = new DATA4[QUEUELEN];

    public int head;
    public int tail;

    //初始化队列结构
    public SQType SQTypeInit() {

        SQType q;

        if ((q = new SQType()) != null) {

            q.head = 0;
            q.tail = 0;
            return q;
        } else {

            return null;
        }
    }

    //判断空队列
    public int SQTypeIsEmpty(SQType q) {

        int temp = 0;
        if (q.head == q.tail) {

            temp = 1;
        }
        return temp;
    }

    //判断满队列
    public int SQTypeIsFull(SQType q) {

        int temp = 0;
        if (q.tail == QUEUELEN) {

            temp = 1;
        }
        return temp;
    }

    //清空队列
    public void SQTypeClear(SQType q) {

        q.head = 0;
        q.tail = 0;
    }

    //释放空间
    public void SQTypeFree(SQType q) {

        if (q != null) {

            q = null;
        }
    }

    //入队列
    public int InSQType(SQType q, DATA4 data) {

        if (q.tail == QUEUELEN) {

            System.out.println("队列已满!操作失败!\n");
            return 0;
        }

        q.data[q.tail++] = data;
        return 1;
    }

    //出队列
    public DATA4 OutSQType(SQType q) {

        if (q.head == q.tail) {

            System.out.println("\n队列已空!操作失败!\n");
            System.exit(0);
        } else {

            return q.data[q.head++];
        }
        return null;
    }

    //读结点数据
    public DATA4 PeekSQType(SQType q) {

        if (SQTypeIsEmpty(q) == 1) {

            System.out.println("\n空队列\n");
            return null;
        } else {

            return q.data[q.head];
        }
    }

    //计算队列长度
    public int SQTypeLen(SQType q) {

        int temp;
        temp = q.tail - q.head;
        return temp;
    }

}
