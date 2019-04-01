package com.li.dsa.sequentiallist;

/**
 * 顺序表
 */
public class SLType {

    public static final int MAXLEN = 100;

    Data[] listData = new Data[MAXLEN + 1];

    public int listLen;

    public SLType(SLType SL) {

        SL.listLen = 0;
    }

    //计算顺序表长度
    public int SLLength(SLType SL) {

        return SL.listLen;
    }

    //插入节点
    public int SLInsert(SLType SL, int n, Data data) {

        if (n >= MAXLEN) {

            System.out.println("顺序表已满,不能插入节点!\n");
            return 0;
        }
        if (n < 1 || n > SL.listLen) {

            System.out.println("插入元素序号错误,不能插入元素!\n");
            return 0;
        }
        for (int i = SL.listLen; i >= n; i--) {

            listData[i + 1] = listData[i];
        }

        SL.listLen++;
        return 1;
    }

    //追加节点
    public int SLAdd(SLType SL, Data data) {

        if (SL.listLen == MAXLEN) {

            System.out.println("顺序表已满,不能再添加节点了!\n");
            return 0;
        }

        listData[++SL.listLen] = data;
        return 1;
    }

    //删除节点
    public int SLDelete(SLType SL, int n) {

        if (n < 1 || n > SL.listLen + 1) {

            System.out.println("删除节点序号错误,不能删除节点!\n");
            return 0;
        }
        for (int i = n; i < SL.listLen; i++) {

            listData[i] = listData[i + 1];
        }
        SL.listLen--;
        return 1;
    }

    //查找节点
    public Data SLFindByNum(SLType SL, int n) {

        if (n < 1 || n > SL.listLen) {

            System.out.println("节点序号错误,不能返回节点!\n");
            return null;
        }

        return SL.listData[n];
    }

    //按照关键字查找节点
    public int SLFindByCont(SLType SL, String key) {

        for (int i = 0; i <= SL.listLen; i++) {

            if (SL.listData[i].key.compareTo(key) == 0) {

                return i;
            }
        }

        return 0;
    }

    //显示所有节点
    public void SLAll(SLType SL) {

        for (int i = 0; i <= SL.listLen; i++) {

            System.out.printf("(%s,%s,%d)\n", SL.listData[i].key, SL.listData[i].name, SL.listData[i].age);
        }
    }
}
