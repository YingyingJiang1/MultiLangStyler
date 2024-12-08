package org.example.analysis.feature;

import org.example.analysis.feature.impl.*;

import java.util.HashMap;
import java.util.Map;


public class StyleFeatureFactory {
    private static Map<String, DiffCreator> diffCreatorMap = new HashMap<>(){{
        put("line_wrapping", new LineWrappingExtractorCreator());
        put("line_statement", new LineStatementExtractorCreator());
        put("literal_usage", new LiteralUsageExtractorCreator());
        put("naming_format", new NamingFormatExtractorCreator());
        put("comment_density", new CommentDensityExtractorCreator());
        put("comment_syntax", new CommentSyntaxExtractorCreator());
        put("structure_preference", new StructPreferenceExtractorCreator());
        put("arrangement", new ArrangementExtractorCreator());
        put("brace_format", new BodyLayoutExtractorCreator());
        put("indention", new IndentionExtractorCreator());
        put("optional_brace", new OptionalBraceExtractorCreator());
        put("space", new SpaceExtractorCreator());
    }};

    private static class LiteralUsageExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new LiteralUsageFeatureExtractor();
        }
    }

    private static class NamingFormatExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new NamingFormatExtractor();
        }
    }

    private static class CommentSyntaxExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new CommentSyntaxExtractor();
        }
    }

    public static StyleFeatureExtractor createExtractor(String styleName) {
        DiffCreator creator = diffCreatorMap.get(styleName);
        return creator == null ? null : creator.create();
    }

    private static class CommentDensityExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new CommentDensityExtractor();
        }
    }
    
    private static class DiffCreator {
        public StyleFeatureExtractor create() {
            return null;
        }
    }
    
    private static class ArrangementExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new ArrangementFeatureExtractor();
        }
    }
    
    private static class BodyLayoutExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new BraceFormatFeatureExtractor();
        }
    }
    
    private static class IndentionExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new IndentionFeatureExtractor();
        }
    }
    
    private static class LineWrappingExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new LineWrappingFeatureExtractor();
        }
    }

    
    private static class OptionalBraceExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new OptionalBraceFeatureExtractor();
        }
    }
    
    private static class SpaceExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new SpaceFeatureExtractor();
        }
    }
    
    private static class StructPreferenceExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new StructPreferenceFeatureExtractor();
        }
    }

    private static class LineStatementExtractorCreator extends DiffCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new LineStmtFeatureExtractor();
        }
    }
    
    
    
}
