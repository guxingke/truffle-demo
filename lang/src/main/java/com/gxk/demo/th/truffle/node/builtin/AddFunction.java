package com.gxk.demo.th.truffle.node.builtin;

import com.gxk.demo.th.truffle.node.ThFunction;

public class AddFunction extends ThFunction {

  @Override
  public Object apply(Object... args) {
    long sum = 0L;
    for (Object arg : args) {
      sum += ((Long) arg);
    }
    return sum;
  }
}
