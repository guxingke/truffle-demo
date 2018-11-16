package com.gxk.demo.th.truffle.node.builtin;

import com.gxk.demo.th.truffle.node.ThFunction;

public class SubFunction extends ThFunction {

  @Override
  public Object apply(Object... args) {
    Long temp = (Long) args[0];

    for (int i = 1; i < args.length; i++) {
      temp -= (Long) args[i];
    }
    return temp;
  }
}
