package com.gxk.demo.th.simple;

import com.gxk.demo.th.simple.context.Env;
import com.gxk.demo.th.simple.node.builtin.AddFunction;
import com.gxk.demo.th.simple.node.ThNode;
import com.gxk.demo.th.simple.node.builtin.DivFunction;
import com.gxk.demo.th.simple.node.builtin.MultiFunction;
import com.gxk.demo.th.simple.node.builtin.NowFunction;
import com.gxk.demo.th.simple.node.builtin.PrintlnFunction;
import com.gxk.demo.th.simple.node.builtin.SubFunction;
import com.gxk.demo.th.simple.parser.Reader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThLang {

  public static void main(String[] args) {
    // just support str
    String code = Arrays.stream(args).collect(Collectors.joining(" "));
    System.out.println(code);

    // rep
    // reader
    ThNode node = Reader.readStr(code);
    // eval
    Env env = new Env();
    env.set("+", new AddFunction());
    env.set("-", new SubFunction());
    env.set("*", new MultiFunction());
    env.set("/", new DivFunction());
    env.set("println", new PrintlnFunction());
    env.set("now", new NowFunction());

    ThNode result = node.eval(env);

    // printer
    System.out.println(result);
  }

  public static void eval(List<String> codes) {
    Env env = new Env();
    env.set("+", new AddFunction());
    env.set("-", new SubFunction());
    env.set("*", new MultiFunction());
    env.set("/", new DivFunction());
    env.set("println", new PrintlnFunction());
    env.set("now", new NowFunction());

    for (String code : codes) {
      ThNode node = Reader.readStr(code);
      ThNode result = node.eval(env);
      System.out.println(result);
    }
  }
}
