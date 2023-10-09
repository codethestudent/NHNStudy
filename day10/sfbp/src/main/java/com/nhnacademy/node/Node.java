package com.nhnacademy.node;

import org.slf4j.Logger;

public abstract class Node {
    static int count;
    final String id;
    String name;
    Logger logger;

    Node(String id, String name) {
        count++;
        logger.trace("노드 생성 됨");
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public int getCount() {
        return count;
    }
}
