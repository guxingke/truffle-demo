package com.gxk.demo.th.truffle.node;

import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;

public class SymbolNode extends ThNode {

  public final String val;

  public SymbolNode(String val) {
    this.val = val;
  }

  @Override
  public Object eval(VirtualFrame frame) {
    try {
      return frame.getObject(frame.getFrameDescriptor().findFrameSlot(val));
    } catch (FrameSlotTypeException e) {
      e.printStackTrace();
    }
    return null;
  }
}
