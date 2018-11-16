package com.gxk.demo.th.truffle.node.builtin;


import com.gxk.demo.th.truffle.node.ThFunction;

public class PrintlnFunction extends ThFunction {

  @Override
  public Object apply(Object... args) {
    for (Object arg : args) {
      System.out.println(arg);
    }
    return args[args.length - 1];
  }
}
