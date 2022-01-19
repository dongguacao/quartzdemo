package com.lidong.quartzdemo.bo;

import java.util.List;

/**
 * @author caolidong
 * @date 2022/1/17
 */
public class User {
    String name;
    List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
