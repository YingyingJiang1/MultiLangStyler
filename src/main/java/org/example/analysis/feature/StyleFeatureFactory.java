package org.example.analysis.feature;

import org.example.analysis.feature.impl.*;

import java.util.Map;


public class StyleFeatureFactory {
    private static Map<String, DiffCreator> diffCreatorMap = Map.of(
            "arrangement", new ArrangementStyleDiffCreator(),
            "brace_format", new BodyLayoutStyleDiffCreator(),
            "indention", new IndentionStyleDiffCreator(),
            "optional_brace", new OptionalBraceStyleDiffCreator(),
            "space", new SpaceStyleDiffCreator(),
            "struct_preference", new StructPreferenceStyleDiffCreator()
    );

    public static FeatureExtractor createStyleDiff(String styleName) {
        DiffCreator creator = diffCreatorMap.get(styleName);
        return creator == null ? null : creator.create();
    }
    
    private static class DiffCreator {
        public FeatureExtractor create() {
            return null;
        }
    }
    
    private static class ArrangementStyleDiffCreator extends DiffCreator {
        @Override
        public FeatureExtractor create() {
            return new ArrangementFeatureExtractor();
        }
    }
    
    private static class BodyLayoutStyleDiffCreator extends DiffCreator {
        @Override
        public FeatureExtractor create() {
            return new BraceFormatFeatureExtractor();
        }
    }
    
    private static class IndentionStyleDiffCreator extends DiffCreator {
        @Override
        public FeatureExtractor create() {
            return new IndentionFeatureExtractor();
        }
    }
    
    private static class LineWrappingStyleDiffCreator extends DiffCreator {
        @Override
        public FeatureExtractor create() {
            return new LineWrappingFeatureExtractor();
        }
    }

    
    private static class OptionalBraceStyleDiffCreator extends DiffCreator {
        @Override
        public FeatureExtractor create() {
            return new OptionalBraceFeatureExtractor();
        }
    }
    
    private static class SpaceStyleDiffCreator extends DiffCreator {
        @Override
        public FeatureExtractor create() {
            return new SpaceFeatureExtractor();
        }
    }
    
    private static class StructPreferenceStyleDiffCreator extends DiffCreator {
        @Override
        public FeatureExtractor create() {
            return new StructPreferenceFeatureExtractor();
        }
    }
    
    
    
}
