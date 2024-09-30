package org.example.style.format;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.styler.brace.style.BraceFormatProperty;
import org.example.styler.brace.style.TypeEnum;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/1/31 22:29
 */
public class BraceInfo {

  private TypeEnum blockType;
  private int stmtNumInBlock; // 0:empty block, 1: only one single statement in block, 2: one single block statement or exceed one statement.
  private BraceFormatProperty lineBreakInfo;


  public BraceInfo() {}

  public BraceInfo(TypeEnum blockType, int stmtNumInBlock,
                   boolean beforeLB, boolean afterLB, boolean beforeRB, boolean afterRB) {
    this.blockType = blockType;
    this.stmtNumInBlock = stmtNumInBlock;
    this.lineBreakInfo = new BraceFormatProperty(beforeRB, afterLB, beforeRB, afterRB);
    this.map = new HashMap<>();
  }

  public BraceInfo(TypeEnum blockType, int stmtNumInBlock) {
    this.blockType = blockType;
    this.stmtNumInBlock = stmtNumInBlock;
    this.lineBreakInfo = new BraceFormatProperty();
    this.map = new HashMap<>();
  }

  public void addElement(Element parent, Parser parser) {


  }

  public static BraceInfo parseElement(Element parent, Parser parser) {
    BraceInfo braceInfo = new BraceInfo();
    return braceInfo;
  }






  public BraceFormatProperty getLineBreakInfo() {
    return lineBreakInfo;
  }



}