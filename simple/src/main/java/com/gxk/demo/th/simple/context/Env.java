package com.gxk.demo.th.simple.context;

import com.gxk.demo.th.simple.node.ThNode;

import java.util.HashMap;
import java.util.Map;

public class Env {
  public final Env outer;

  public final Map<String, ThNode> slots;

  public Env() {
    this.outer = null;
    this.slots = new HashMap<>();
  }

  public Env(Env outer) {
    this.outer = outer;
    this.slots = new HashMap<>();
  }

  public Env(Env outer, Map<String, ThNode> slots) {
    this.outer = outer;
    this.slots = slots;
  }

  public final boolean exsits(String key) {
    if (key == null) {
      return false;
    }

    if (slots.containsKey(key)) {
      return true;
    }

    if (this.outer == null) {
      return false;
    }
    return this.outer.exsits(key);
  }

  public final ThNode get(String key) {
    if (!this.exsits(key)) {
      return null;
    }
    ThNode ret = this.slots.get(key);
    if (ret != null) {
      return ret;
    }
    return this.outer.get(key);
  }

  public final ThNode set(String key, ThNode value) {
    this.slots.put(key, value);
    return value;
  }
}
