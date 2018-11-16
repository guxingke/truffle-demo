package com.gxk.demo.th.truffle.node;


import com.oracle.truffle.api.frame.VirtualFrame;

public class NumberNode extends ThNode {
  public final Long val;

  public NumberNode(Long val) {
    this.val = val;
  }

  @Override
  public Object eval(VirtualFrame frame) {
    return this.val;
  }

  @Override
  public String toString() {
    return this.val.toString();
  }
}
