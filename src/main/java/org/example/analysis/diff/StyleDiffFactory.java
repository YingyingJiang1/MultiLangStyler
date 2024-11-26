package org.example.analysis.diff;

import org.example.analysis.diff.impl.*;
import org.example.style.CommonStyle;
import org.example.styler.arrangement.style.ArrangementStyle;
import org.example.styler.format.indention.style.IndentionCommonStyle;
import org.example.styler.format.linewrapping.style.LineWrappingCommonStyle;
import org.example.styler.format.newline.style.NewlineCommonStyle;
import org.example.styler.format.space.style.SpaceCommonStyle;
import org.example.styler.structure.style.StructPreferenceCommonStyle;

import java.util.Map;


public class StyleDiffFactory {
    private static Map<Class<? extends CommonStyle>, DiffCreator> diffCreatorMap = Map.of(
            ArrangementStyle.class, new ArrangementStyleDiffCreator(),
            BodyLayoutCommonStyle.class, new BodyLayoutStyleDiffCreator(),
            IndentionCommonStyle.class, new IndentionStyleDiffCreator(),
            LineWrappingCommonStyle.class, new LineWrappingStyleDiffCreator(),
            NewlineCommonStyle.class, new NewlineStyleDiffCreator(),
            OptionalBraceCommonStyle.class, new OptionalBraceStyleDiffCreator(),
            SpaceCommonStyle.class, new SpaceStyleDiffCreator(),
            StructPreferenceCommonStyle.class, new StructPreferenceStyleDiffCreator()
    );
    public static StyleFeature createStyleDiff(Class<? extends CommonStyle> styleClass) {
        return diffCreatorMap.get(styleClass).create();
    }
    
    private static class DiffCreator {
        public StyleFeature create() {
            return null;
        }
    }
    
    private static class ArrangementStyleDiffCreator extends DiffCreator {
        @Override
        public StyleFeature create() {
            return new ArrangementStyleFeature();
        }
    }
    
    private static class BodyLayoutStyleDiffCreator extends DiffCreator {
        @Override
        public StyleFeature create() {
            return new BodyLayoutStyleFeature();
        }
    }
    
    private static class IndentionStyleDiffCreator extends DiffCreator {
        @Override
        public StyleFeature create() {
            return new IndentionStyleFeature();
        }
    }
    
    private static class LineWrappingStyleDiffCreator extends DiffCreator {
        @Override
        public StyleFeature create() {
            return new LineWrappingStyleFeature();
        }
    }
    
    private static class NewlineStyleDiffCreator extends DiffCreator {
        @Override
        public StyleFeature create() {
            return new NewlineStyleFeature();
        }
    }
    
    private static class OptionalBraceStyleDiffCreator extends DiffCreator {
        @Override
        public StyleFeature create() {
            return new OptionalBraceStyleFeature();
        }
    }
    
    private static class SpaceStyleDiffCreator extends DiffCreator {
        @Override
        public StyleFeature create() {
            return new SpaceStyleFeature();
        }
    }
    
    private static class StructPreferenceStyleDiffCreator extends DiffCreator {
        @Override
        public StyleFeature create() {
            return new StructPreferenceStyleFeature();
        }
    }
    
    
    
}
