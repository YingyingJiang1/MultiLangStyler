package org.example.style;

import org.dom4j.Element;
import org.example.io.DomIO;
import org.example.parser.common.MyParser;

import java.util.*;

/*
 * @description:
 * @author     : Jiang Yingying
 * @create     : 2024/1/8 22:27
 */
public class ProgramStyle implements DomIO {
    Map<Class<? extends Style>, Style> styleMap = new HashMap<>();


    @Override
    public void addElement(Element root, MyParser parser) {
        for (Style style : styleMap.values()) {
            if (style instanceof CommonStyle commonStyle) {
                commonStyle.addElement(root, parser);
            }

        }
    }

    @Override
    public void parseElement(Element root, MyParser parser) {
        for (Style style : styleMap.values()) {
            if (style instanceof CommonStyle commonStyle) {
                commonStyle.parseElement(root, parser);
            }
        }
        
    }

    public void add(Style style) {
        styleMap.put(style.getClass(), style);
    }

    public List<Style> getStyles() {
        return styleMap.values().stream().toList();
    }

    public Style getStyle(Class<? extends Style> stylerClass) {
        return styleMap.get(stylerClass);
    }
}
