package com.nhnacademy.node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.nhnacademy.message.StringMessage;

/* socket in -> output message queue
 * socket에서 들어오는 데이터를 flow message로 만들어 flow에 넣는다
 * (서버 클라이언트로 들어온 메세지를 읽음)
 */
public class SocketInputNode extends InputNode {
    BufferedReader reader;
    Socket socket;

    public SocketInputNode(Socket socket) {
        this(1);
        this.socket = socket;
    }

    public SocketInputNode(int count) {
        super(count);
    }

    @Override
    void preprocess() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void process() {
        String line;
        try {
            line = reader.readLine();
            StringMessage message = new StringMessage(line);
            output(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void postprocess() {
        socket = null;
    }

}
