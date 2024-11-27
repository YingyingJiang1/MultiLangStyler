package org.example.analysis.feature;

import org.example.analysis.feature.impl.*;
import org.example.style.Style;

import java.util.Map;


public class StyleFeatureFactory {
    private static Map<String, DiffCreator> diffCreatorMap = Map.of(
            "arrangement", new ArrangementStyleDiffCreator(),
            "body_layout", new BodyLayoutStyleDiffCreator(),
            "indention", new IndentionStyleDiffCreator(),
            "optional_brace", new OptionalBraceStyleDiffCreator(),
            "space", new SpaceStyleDiffCreator(),
            "struct_preference", new StructPreferenceStyleDiffCreator()
    );
    public static StyleFeature createStyleDiff(String styleName) {
        return diffCreatorMap.get(styleName).create();
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
