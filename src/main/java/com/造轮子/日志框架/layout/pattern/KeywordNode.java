package com.造轮子.日志框架.layout.pattern;

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
