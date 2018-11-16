package com.gxk.demo.th.simple.node.builtin;

import com.gxk.demo.th.simple.node.ThFunction;
import com.gxk.demo.th.simple.node.ThNode;

public class PrintlnFunction extends ThFunction {

  @Override
  public ThNode apply(ThNode... args) {
    for (ThNode arg : args) {
      System.out.println(arg);
    }
    return args[args.length - 1];
  }
}
