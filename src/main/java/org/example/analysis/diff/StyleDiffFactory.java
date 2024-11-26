package org.example.analysis.diff;

import org.example.style.Style;

public class StyleDiffFactory {
    public static StyleDiff createStyleDiff(Class<? extends Style> styleClass) {
        return switch (styleClass.getSimpleName()) {
            case "" -> new StyleDiffImpl();
            default -> null;
        };
    }
}
