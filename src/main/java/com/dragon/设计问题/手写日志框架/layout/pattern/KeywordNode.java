package com.dragon.设计问题.手写日志框架.layout.pattern;

public class KeywordNode extends Node {

    public KeywordNode(String value) {
        super(Node.KEYWORD,value);
    }

    public KeywordNode() {
    }

    public String getKeyword(){
        return value.substring(1);
    }
}
