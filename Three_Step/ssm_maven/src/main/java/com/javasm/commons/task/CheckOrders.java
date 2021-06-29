package com.javasm.commons.task;

import java.util.TimerTask;

public class CheckOrders extends TimerTask {
    private String orderId;

    public CheckOrders(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println("查看orderId状态,如果未付款,则取消该订单");
    }
}
