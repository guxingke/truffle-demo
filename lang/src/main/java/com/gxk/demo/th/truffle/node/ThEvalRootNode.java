package com.gxk.demo.th.truffle.node;

import com.gxk.demo.th.truffle.node.builtin.AddFunction;
import com.gxk.demo.th.truffle.node.builtin.DivFunction;
import com.gxk.demo.th.truffle.node.builtin.MultiFunction;
import com.gxk.demo.th.truffle.node.builtin.NowFunction;
import com.gxk.demo.th.truffle.node.builtin.PrintlnFunction;
import com.gxk.demo.th.truffle.node.builtin.SubFunction;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

import java.util.List;

public class ThEvalRootNode extends RootNode {
  private final List<ThNode> bodyNodes;

  private boolean init;

  public ThEvalRootNode(TruffleLanguage<?> language, List<ThNode> bodies) {
    super(language);
    this.bodyNodes = bodies;
  }

  @Override
  public Object execute(VirtualFrame frame) {
    if (!init) {
      FrameDescriptor descriptor = frame.getFrameDescriptor();
      frame.setObject(descriptor.addFrameSlot("+"), new AddFunction());
      frame.setObject(descriptor.addFrameSlot("-"), new SubFunction());
      frame.setObject(descriptor.addFrameSlot("*"), new MultiFunction());
      frame.setObject(descriptor.addFrameSlot("/"), new DivFunction());
      frame.setObject(descriptor.addFrameSlot("now"), new NowFunction());
      frame.setObject(descriptor.addFrameSlot("println"), new PrintlnFunction());

      init = true;
    }

    for (int i = 0; i < bodyNodes.size() - 1; i++) {
      bodyNodes.get(i).eval(frame);
    }
    return bodyNodes.get(bodyNodes.size() - 1).eval(frame);
  }
}

