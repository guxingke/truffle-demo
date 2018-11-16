package com.gxk.demo.th.simple;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ThLangTest {
  @Test
  public void eval() throws Exception {    List<String> code = Arrays.asList(
      "(println (now))",
      "(+ 1 2 3 4)",
      "(* 1 (+ 1) (- 3 1))",
      "(println (now))"
  );


    ThLang.eval(code);
  }
}