package com.gxk.demo.th.truffle;

import com.gxk.demo.th.truffle.node.NumberNode;
import com.gxk.demo.th.truffle.node.SymbolNode;
import com.gxk.demo.th.truffle.node.ThEvalRootNode;
import com.gxk.demo.th.truffle.node.ThListNode;
import com.gxk.demo.th.truffle.node.ThNode;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.source.Source;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@TruffleLanguage.Registration(
    id = ThLang.ID,
    name = ThLang.NAME,
    defaultMimeType = ThLang.MIME,
    characterMimeTypes = ThLang.MIME
)
public class ThLang extends TruffleLanguage<ThContext> {

  public static final String ID = "th";
  public static final String NAME = "truffle hello";
  public static final String MIME = "application/x-th";

  @Override
  protected ThContext createContext(Env env) {
    return new ThContext(env);
  }

  @Override
  protected boolean isObjectOfLanguage(Object object) {
    return false;
  }

  @Override
  protected CallTarget parse(ParsingRequest request) throws Exception {
    Source source = request.getSource();

    return Truffle.getRuntime().createCallTarget(
        new ThEvalRootNode(this, read(readLines(source)))
    );
  }

  private List<String> readLines(Source source) {
    String code = (String) source.getCharacters();
    return Arrays.asList(code.split("\n"));
  }

  private List<ThNode> read(List<String> sources) {
    return sources.stream()
        .map(Reader::readStr)
        .collect(Collectors.toList());
  }
}
