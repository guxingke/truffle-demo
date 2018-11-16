package com.gxk.demo.th.truffle.node.builtin;

import com.gxk.demo.th.truffle.node.ThFunction;

public class MultiFunction extends ThFunction {

  @Override
  public Object apply(Object... args) {
    Long temp = 1L;

    for (int i = 0; i < args.length; i++) {
      temp *= ((Long) args[i]);
    }
    return temp;
  }
}
