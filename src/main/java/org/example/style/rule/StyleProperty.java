package org.example.style.rule;

import org.example.style.DomIO;

public abstract class StyleProperty implements DomIO, Comparable<StyleProperty> {
    void fillStyle() {}

    @Override
    public int compareTo(StyleProperty o) {
        return 0;
    }
}
