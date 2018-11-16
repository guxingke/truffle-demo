package com.gxk.demo.th.simple.node.builtin;

import com.gxk.demo.th.simple.node.NumberNode;
import com.gxk.demo.th.simple.node.ThFunction;
import com.gxk.demo.th.simple.node.ThNode;

public class DivFunction extends ThFunction {

  @Override
  public ThNode apply(ThNode... args) {
    Long temp = ((NumberNode) args[0]).val;

    for (int i = 1; i < args.length; i++) {
      temp /= ((NumberNode) args[i]).val;
    }
    return new NumberNode(temp);
  }
}
