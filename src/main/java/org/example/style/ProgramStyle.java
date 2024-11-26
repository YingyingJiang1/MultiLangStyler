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
    List<CommonStyle> commonStyles = new ArrayList<CommonStyle>();
    public static final int FORMAT = 0;
    public static final int LITERAL = 1;
    public static final int ARRANGEMENT = 2;
    public static final int NAMING = 3;
    public static final int COMMENT = 4;
    public static final int EQUIVALENCES = 5;


    @Override
    public void addElement(Element root, MyParser parser) {
        for (CommonStyle commonStyle : commonStyles) {
            commonStyle.addElement(root, parser);
        }
    }

    @Override
    public Object parseElement(Element root, MyParser parser) {
        for (CommonStyle commonStyle : commonStyles) {
            commonStyle.parseElement(root, parser);
        }
        return this;
    }

    public void add(CommonStyle commonStyle) {
        commonStyles.add(commonStyle);
    }

    public List<CommonStyle> getStyles() {
        return commonStyles;
    }
}
