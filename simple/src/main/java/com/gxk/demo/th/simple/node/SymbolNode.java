package com.gxk.demo.th.simple.node;

import com.gxk.demo.th.simple.context.Env;

public class SymbolNode extends ThNode {
  public final String val;

  public SymbolNode(String val) {
    this.val = val;
  }

  @Override
  public ThNode eval(Env env) {
    return env.get(this.val);
  }
}
