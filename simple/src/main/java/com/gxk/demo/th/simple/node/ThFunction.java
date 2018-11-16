package com.gxk.demo.th.simple.node;

import com.gxk.demo.th.simple.context.Env;

public abstract class ThFunction extends ThNode{

  @Override
  public ThNode eval(Env env) {
    return this;
  }

  public abstract ThNode apply(ThNode... args);
}
