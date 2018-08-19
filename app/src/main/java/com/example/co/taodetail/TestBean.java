package com.example.co.taodetail;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by jieding on 2018/8/10 11:32
 */
public class TestBean implements MultiItemEntity {
    public static final int ITEMONE=1;
    public static final int ITEMTWO=2;
    private String name="李四";
    private int price=10;
    private int num=10;
    private String parameter="白色";
    private int itemType;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }



    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int getItemType() {
        if (price==10){
            setItemType(ITEMONE);
        }
        else {
            setItemType(ITEMTWO);
        }
        return itemType;
    }
}
