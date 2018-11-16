package com.gxk.demo.th.truffle.node;


import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;

public abstract class ThNode extends Node {

  public abstract Object eval(VirtualFrame frame);
}
