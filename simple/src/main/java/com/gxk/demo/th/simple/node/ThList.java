package com.gxk.demo.th.simple.node;

import com.gxk.demo.th.simple.context.Env;

import java.util.ArrayList;
import java.util.List;

public class ThList extends ThNode {
  private final List<ThNode> children;

  public ThList() {
    this.children = new ArrayList<>();
  }

  @Override
  public ThNode eval(Env env) {
    ThNode firstNodeRet = children.get(0).eval(env);
    if (!(firstNodeRet instanceof ThFunction)) {
      throw new RuntimeException("eval list err");
    }
    ThFunction func = (ThFunction) firstNodeRet;

    ThNode[] args = new ThNode[children.size() - 1];
    for (int i = 1; i < children.size(); i++) {
      args[i - 1] = children.get(i).eval(env);
    }

    return func.apply(args);
  }

  public void add(ThNode thNode) {
    this.children.add(thNode);
  }
}
