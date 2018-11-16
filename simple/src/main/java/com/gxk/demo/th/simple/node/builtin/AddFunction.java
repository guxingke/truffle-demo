package com.gxk.demo.th.simple.node.builtin;

import com.gxk.demo.th.simple.node.NumberNode;
import com.gxk.demo.th.simple.node.ThFunction;
import com.gxk.demo.th.simple.node.ThNode;

public class AddFunction extends ThFunction {

  @Override
  public ThNode apply(ThNode... args) {
    long sum = 0L;
    for (ThNode arg : args) {
      sum += ((NumberNode) arg).val;
    }
    return new NumberNode(sum);
  }
}
