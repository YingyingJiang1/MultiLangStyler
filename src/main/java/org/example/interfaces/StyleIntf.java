package org.example.interfaces;

public interface StyleIntf {
    void addRule(StyleContext styleContext, StyleProperty styleProperty);
    StyleProperty getProperty(StyleContext styleContext);
}
