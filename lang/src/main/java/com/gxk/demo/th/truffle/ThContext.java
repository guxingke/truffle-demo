package com.gxk.demo.th.truffle;

import com.oracle.truffle.api.TruffleLanguage;

public class ThContext {
  private TruffleLanguage.Env env;

  public ThContext(TruffleLanguage.Env env) {
    this.env = env;
  }
}
