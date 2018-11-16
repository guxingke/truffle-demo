package com.gxk.demo.th.simple.node;

import com.gxk.demo.th.simple.context.Env;

public class NumberNode extends ThNode {
  public final Long val;

  public NumberNode(Long val) {
    this.val = val;
  }

  @Override
  public ThNode eval(Env env) {
    return this;
  }

  @Override
  public String toString() {
    return this.val.toString();
  }
}
