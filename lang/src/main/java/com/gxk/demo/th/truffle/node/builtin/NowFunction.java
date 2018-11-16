package com.gxk.demo.th.truffle.node.builtin;

import com.gxk.demo.th.truffle.node.ThFunction;

public class NowFunction extends ThFunction {

  @Override
  public Object apply(Object... args) {
    return System.nanoTime();
  }
}
