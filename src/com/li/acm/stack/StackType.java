package com.li.acm.stack;

public class StackType {

    public static final int MAXLEN = 50;

    Data3[] data = new Data3[MAXLEN];

    public int top;

    //初始化栈结构
    public StackType STInit() {

        StackType p;

        if ((p = new StackType()) != null) {
            p.top = 0;
            return p;
        }
        return null;
    }

    //判断空栈
    public boolean STIsEmpty(StackType s) {

        boolean t;
        t = (s.top == 0);
        return t;
    }

    //判断满栈
    public boolean STIsFull(StackType s) {

        boolean t;
        t = (s.top == MAXLEN);
        return t;
    }

    //清空栈
    public void STClear(StackType s) {

        s.top = 0;
    }

    //释放空间
    public void STFree(StackType s) {

        if (s != null) {
            s = null;
        }
    }

    //入栈
    public int PushST(StackType s, Data3 data) {

        if ((s.top + 1) > MAXLEN) {

            System.out.println("栈溢出!\n");
            return 0;
        }

        s.data[++s.top] = data;
        return 1;
    }

    //出栈
    public Data3 PopSt(StackType s) {

        if (s.top == 0) {

            System.out.println("栈为空!\n");
            return null;
        }

        return (s.data[s.top--]);
    }

    //读结点数据
    public Data3 PeekST(StackType s) {

        if (s.top == 0) {
            System.out.println("栈为空!\n");
            System.exit(0);
        }
        return (s.data[s.top]);
    }
}

