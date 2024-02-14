package com.nhnacademy.node;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.nhnacademy.message.Message;

/* input message queue -> socket out
 * flow 에서 처리된 결과를 socket으로 내보낸다.
 * (서버, 클라이언트로 보냄)
 */
public class SocketOutNode extends OutputNode {

    Socket socket;
    BufferedWriter writer;

    SocketOutNode(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void preprocess() {

    }

    @Override
    public void process() {

    }

    @Override
    public void postprocess(){
        
    }
}
