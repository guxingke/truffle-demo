package com.gxk.demo.th.truffle;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ThLangTest {

  @Test
  public void runtimeTest() {
    Context context = Context.create();

    List<String> code = Arrays.asList(
        "(println (now))",
        "(+ 1 2 3 4)",
        "(* 1 (+ 1) (- 3 1))",
        "(println (- (now) 2 3 4 5 6 (now)))",
        "(+ 3 3)"
    );

    String source = code.stream().collect(Collectors.joining("\n"));

    Value val = context.eval(ThLang.ID, source);
    assertEquals(6L, val.asLong());
    context.close();
  }
}