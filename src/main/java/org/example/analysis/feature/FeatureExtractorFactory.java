package org.example.analysis.feature;

import org.example.analysis.feature.impl.style.*;

import java.util.HashMap;
import java.util.Map;


public class FeatureExtractorFactory {
    private static Map<String, ExtractorCreator> diffCreatorMap = new HashMap<>(){{
        put("line_wrapping", new LineWrappingCreator());
        put("line_statement", new LineStatementCreator());
        put("literal_usage", new LiteralUsageCreator());
        put("naming_format", new NamingFormatCreator());
        put("comment_density", new CommentDensityCreator());
        put("comment_syntax", new CommentSyntaxCreator());
        put("structure_preference", new StructPreferenceCreator());
        put("arrangement", new ArrangementCreator());
        put("brace_format", new BodyLayoutCreator());
        put("indention", new IndentionCreator());
        put("optional_brace", new OptionalBraceCreator());
        put("space", new SpaceCreator());
        put("modifier_order", new ModifierOrderFeatureCreator());
        put("declaration_number", new DeclarationNumberFeatureCreator());
        put("function_complexity", new FunctionComplexityFeatureCreator());
        put("parameter_order", new ParameterOrderFeatureCreator());
        put("multi_branch", new MultiBranchFeatureCreator());
    }};


    private static class MultiBranchFeatureCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new MultiBranchFeature();
        }
    }

    private static class ParameterOrderFeatureCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new ParameterOrderFeature();
        }
    }

    private static class FunctionComplexityFeatureCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new FunctionComplexityFeature();
        }
    }

    private static class DeclarationNumberFeatureCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new DeclarationNumberFeature();
        }
    }


    private static class ModifierOrderFeatureCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new ModifierOrderFeature();
        }
    }


    private static class LiteralUsageCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new LiteralUsageFeature();
        }
    }

    private static class NamingFormatCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new NamingFormat();
        }
    }

    private static class CommentSyntaxCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new CommentSyntax();
        }
    }

    public static StyleFeatureExtractor createExtractor(String styleName) {
        ExtractorCreator creator = diffCreatorMap.get(styleName);
        return creator == null ? null : creator.create();
    }

    private static class CommentDensityCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new CommentDensity();
        }
    }
    
    private static class ExtractorCreator {
        public StyleFeatureExtractor create() {
            return null;
        }
    }
    
    private static class ArrangementCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new ArrangementFeature();
        }
    }
    
    private static class BodyLayoutCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new BraceFormatFeature();
        }
    }
    
    private static class IndentionCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new IndentionFeature();
        }
    }
    
    private static class LineWrappingCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new LineWrappingFeature();
        }
    }

    
    private static class OptionalBraceCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new OptionalBraceFeature();
        }
    }
    
    private static class SpaceCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new SpaceFeature();
        }
    }
    
    private static class StructPreferenceCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new StructPreferenceFeature();
        }
    }

    private static class LineStatementCreator extends ExtractorCreator {
        @Override
        public StyleFeatureExtractor create() {
            return new LineStmtFeature();
        }
    }
    
    
    
}
