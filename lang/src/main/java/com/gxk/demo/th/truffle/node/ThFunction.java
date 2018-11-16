package com.gxk.demo.th.truffle.node;

import com.oracle.truffle.api.frame.VirtualFrame;

public abstract class ThFunction extends ThNode{
  @Override
  public Object eval(VirtualFrame frame) {
    return this;
  }

  public abstract Object apply(Object... args);
}
