package org.example.style.rule;

import org.example.io.DomIO;

public abstract class StyleContext implements DomIO {
    public void fillStyle() {}
    public double calculateDistance(StyleContext targetContext) { return Double.MAX_VALUE; }
}
