package com.nhnacademy.node;

import com.nhnacademy.exception.InvalidArgumentException;
import com.nhnacademy.wire.Wire;

public abstract class OutputNode extends ActiveNode {
    Wire[] inputWires;

    OutputNode(String name, int count) {
        super(name);
        if (count <= 0) {
            throw new InvalidArgumentException();
        }
        inputWires = new Wire[count];
    }

    OutputNode(int count) {
        super();
        if (count <= 0) {
            throw new InvalidArgumentException();
        }

        inputWires = new Wire[count];
    }

    public void connectInputWire(int index, Wire wire) {
        if (inputWires.length <= index) {
            throw new RuntimeException();
        }
        if (inputWires[index] != null) {
            throw new RuntimeException();
        }

        inputWires[index] = wire;
    }

    public int getInputWireLength() {
        return inputWires.length;
    }

    public Wire getInputWire(int index) {
        return inputWires[index];
    }
}