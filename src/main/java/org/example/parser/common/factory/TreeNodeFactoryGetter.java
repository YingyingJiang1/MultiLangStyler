package org.example.parser.common.factory;

import org.example.parser.common.MyParser;
import org.example.parser.common.factory.context.TreeNodeFactory;
import org.example.parser.common.factory.context.JavaTreeNodeFactory;

public class TreeNodeFactoryGetter {
    public static TreeNodeFactory getFactory(MyParser parser) {
        String name = parser.getClass().getSimpleName();
        TreeNodeFactory ret =  switch (name) {
            case "MyJavaParser" -> JavaTreeNodeFactory.getInstance();
            default -> null;
        };
        if (ret == null) {
            throw new RuntimeException("No factory for " + name);
        }
        return ret;
    }
}
