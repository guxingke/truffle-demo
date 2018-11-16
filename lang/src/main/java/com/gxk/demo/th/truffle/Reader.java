package com.gxk.demo.th.truffle;

import com.gxk.demo.th.truffle.node.NumberNode;
import com.gxk.demo.th.truffle.node.SymbolNode;
import com.gxk.demo.th.truffle.node.ThListNode;
import com.gxk.demo.th.truffle.node.ThNode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
  private List<String> tokens;
  private int position;

  private Reader(List<String> tokens) {
    this.tokens = tokens;
    this.position = 0;
  }

  String next() {
    if (position == tokens.size()) {
      return null;
    }
    String token = tokens.get(position);
    position++;
    return token;
  }

  String peek() {
    if (position == tokens.size()) {
      return null;
    }
    return tokens.get(position);
  }

  public static ThNode readStr(String code) {
    List<String> tokens = tokenizer(code);
    Reader reader = new Reader(tokens);

    return readForm(reader);
  }

  private static ThNode readForm(Reader reader) {
    String token = reader.peek();
    if (token == null) {
      throw new EOFException();
    }
    ThNode form;
    switch (token) {
//      case "'":
//        reader.next();
//        return read_shorthand(new symbol("quote"), read_form(reader));
//      case "`":
//        reader.next();
//        return read_shorthand(new symbol("quasiquote"), read_form(reader));
//      case "~":
//        reader.next();
//        return read_shorthand(new symbol("unquote"), read_form(reader));
//      case "@":
//        reader.next();
//        return read_shorthand(new symbol("deref"), read_form(reader));
//      case "~@":
//        reader.next();
//        return read_shorthand(new symbol("splice-unquote"), read_form(reader));
//      case "^":
//        reader.next();
//        mal meta = read_form(reader);
//        mal data = read_form(reader);
//        return read_with_meta(new symbol("with-meta"), meta, data);
      case "(":
//      case "[":
//      case "{":
        form = readList(reader);
        break;
      default:
        form = readAtom(reader);
    }
    return form;
  }

  private static ThNode readAtom(Reader reader) {
    String token = reader.next();

    try {
      return new NumberNode(Long.parseLong(token));
    } catch (NumberFormatException e) {
      // do nothing
    }

    return new SymbolNode(token);
  }

  private static ThNode readList(Reader reader) {
    reader.next();

    ThListNode list = new ThListNode();
    while (!reader.peek().equals(")")) {
      list.add(readForm(reader));

      if (reader.peek() == null) {
        throw new EOFException(")");
      }
    }

    reader.next();
    return list;
  }

  private static List<String> tokenizer(String code) {
    List<String> tokens = new ArrayList<>();
    Pattern pattern = Pattern.compile("[\\s,]*(~@|[\\[\\]{}()'`~^@]|\"(?:\\\\.|[^\\\\\"])*\"|;.*|[^\\s\\[\\]{}('\"`,;)]*)");
    Matcher matcher = pattern.matcher(code);

    while (matcher.find()) {
      String token = matcher.group(1);
      if (token != null &&
          !token.equals("") &&
          !(token.charAt(0) == ';')) {
        tokens.add(token);
      }
    }

    return tokens;
  }

  static class EOFException extends RuntimeException {
    final String msg;

    EOFException() {
      this("");
    }

    EOFException(String msg) {
      this.msg = msg;
    }
  }
}
