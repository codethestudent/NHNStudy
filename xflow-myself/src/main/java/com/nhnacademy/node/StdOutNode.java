package com.nhnacademy.node;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

import com.nhnacademy.message.Message;

/* output message queue -> 출력
 * flow에서 처리된 결과를 stdout으로 출력함
 */
public class StdOutNode extends OutputNode {

    BufferedWriter writer;

    public StdOutNode() {
        super(1);
    }

    @Override
    public void preprocess() {
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @Override
    public void process() {
        try {
            writer.write();
            writer.flush();
        } catch (IOException e) {
        }
    }

    @Override
    public void postprocess() {

    }

}
