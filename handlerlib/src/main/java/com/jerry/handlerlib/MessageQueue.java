package com.jerry.handlerlib;

public class MessageQueue {

    Message[] items;
    private int putIndex;
    private int tackIndex;

    public MessageQueue() {
        this.items = new Message[50];
    }

    public void enqueueMessage(Message msg){
        items[putIndex]=msg;
        putIndex=(++putIndex==items.length)?0:putIndex;

    }

    public Message next(){
        Message msg = null;
        msg = items[tackIndex];
        items[tackIndex]= null;
        tackIndex=(++tackIndex==items.length)?0:tackIndex;
        return null;
    }
}
