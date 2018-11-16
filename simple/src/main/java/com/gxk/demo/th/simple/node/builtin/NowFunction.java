package com.gxk.demo.th.simple.node.builtin;

import com.gxk.demo.th.simple.node.NumberNode;
import com.gxk.demo.th.simple.node.ThFunction;
import com.gxk.demo.th.simple.node.ThNode;

public class NowFunction extends ThFunction {

  @Override
  public ThNode apply(ThNode... args) {
    return new NumberNode(System.currentTimeMillis());
  }
}
