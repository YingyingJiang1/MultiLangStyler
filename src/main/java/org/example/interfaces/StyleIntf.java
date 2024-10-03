package org.example.interfaces;

import java.util.List;

public interface StyleIntf {
    void addRule(StyleContext styleContext, StyleProperty styleProperty);
    StyleProperty getProperty(StyleContext styleContext);
}
