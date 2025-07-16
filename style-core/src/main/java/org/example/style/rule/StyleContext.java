package org.example.style.rule;

import org.example.style.DomIO;

public abstract class StyleContext implements DomIO {
    public int INIT_DISTANCE = Integer.MAX_VALUE;
    public int INVALID_DISTANCE = -1;
    public int DEC_WHEN_EQUAL = 1000;
    public int DEC_WHEN_HIGH_SIMILAR = 100;
    public int DEC_WHEN_MIDDLE_SIMILAR = 10;
    public int DEC_WHEN_LOW_SIMILAR = 1;

    public void fillStyle() {}
    public double calculateDistance(StyleContext targetContext) { return Double.MAX_VALUE; }
}
