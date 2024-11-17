package org.example.style;

import org.antlr.v4.runtime.Parser;
import org.dom4j.Element;
import org.example.io.DomIO;

import java.util.*;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/8 22:27
 */
public class ProgramStyle implements DomIO {
    List<Style> styles = new ArrayList<Style>();
    public static final int FORMAT = 0;
    public static final int LITERAL = 1;
    public static final int ARRANGEMENT = 2;
    public static final int NAMING = 3;
    public static final int COMMENT = 4;
    public static final int EQUIVALENCES = 5;


    @Override
    public void addElement(Element root, Parser parser) {
        for (Style style : styles) {
            style.addElement(root, parser);
        }
    }

    @Override
    public Object parseElement(Element root, Parser parser) {
        for (Style style : styles) {
            style.parseElement(root, parser);
        }
        return this;
    }

    public void add(Style style) {
        styles.add(style);
    }

    public List<Style> getStyles() {
        return styles;
    }
}
