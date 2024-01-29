package com.nhnacademy.node;

import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.wire.Wire;

public abstract class InputNode extends ActiveNode {
    Wire[] outputWires;

    public InputNode(int count){
        if(count<=0){
            throw new OutOfBoundsException();
        }
        
    }

    public void connectOutputWire(int index, Wire wire) {
        if (outputWires.length <= index) {
            throw new RuntimeException();
        }

        if (outputWires[index] != null) {
            throw new RuntimeException();
        }

        outputWires[index] = wire;
    }
}