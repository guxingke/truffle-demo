package com.gxk.demo.th.truffle.node;

import com.oracle.truffle.api.frame.VirtualFrame;

import java.util.ArrayList;
import java.util.List;

public class ThListNode extends ThNode {

  private final List<ThNode> children;

  public ThListNode() {
    this.children = new ArrayList<>();
  }

  public ThListNode(List<ThNode> children) {
    this.children = children;
  }

  public void add(ThNode thNode) {
    this.children.add(thNode);
  }

  @Override
  public Object eval(VirtualFrame frame) {
    Object firstNodeRet = children.get(0).eval(frame);

    if (!(firstNodeRet instanceof ThFunction)) {
      throw new RuntimeException("eval list err");
    }

    ThFunction func = (ThFunction) firstNodeRet;

    Object[] args = new Object[children.size() - 1];
    for (int i = 1; i < children.size(); i++) {
      args[i - 1] = children.get(i).eval(frame);
    }

    return func.apply(args);
  }
}
