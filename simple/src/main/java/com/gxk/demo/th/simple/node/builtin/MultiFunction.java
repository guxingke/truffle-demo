package com.gxk.demo.th.simple.node.builtin;

import com.gxk.demo.th.simple.node.NumberNode;
import com.gxk.demo.th.simple.node.ThFunction;
import com.gxk.demo.th.simple.node.ThNode;

public class MultiFunction extends ThFunction {

  @Override
  public ThNode apply(ThNode... args) {
    Long temp = 1L;

    for (int i = 0; i < args.length; i++) {
      temp *= ((NumberNode) args[i]).val;
    }
    return new NumberNode(temp);
  }
}
