package com.example.module;

/**
 * 聊天实体类
 * Created by hs on 2015/3/18.
 */
public class ChatMessage {

    /**
     * 收到信息
     */
    public static final int MESSAGE_COME = 1;
    /**
     * 发出信息
     */
    public static final int MESSAGE_UP = 0;
    /**
     *标志是收到信息还是发出信息
     */
    private int direction;
    /**
     * 消息内容
     */
    private String content;

    public ChatMessage(int direction, String content){

        super();
        this.direction = direction;
        this.content = content;

    }

    public int getDirection(){

        return direction;

    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

}
