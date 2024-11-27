package org.example.styler.format.linewrapping.style;

import org.antlr.v4.runtime.Token;
import org.dom4j.Element;
import org.example.parser.common.MyParser;
import org.example.style.rule.StyleProperty;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineWrappingProperty extends StyleProperty {
    static LineWrappingProperty CODE_PROPERTY = new LineWrappingProperty();
    static LineWrappingProperty COMMENT_PROPERTY = new LineWrappingProperty();

    public double variance; // Make the `variance` more similar when choosing a location to break a line.
    public int maxLen;
    public int maxLenBefore; // Max length before line wrapping.
    public List<BreakLoc> breakLocs = new ArrayList<BreakLoc>(0);
    public SucceedLoc succeedLoc = new SucceedLoc(0);

    static {
        Collections.addAll(CODE_PROPERTY.breakLocs,
                new BreakLoc(","),
                new BreakLoc("[?:]"),
                new BreakLoc("[.]", false),
                new BreakLoc("[&]{2}"),
                new BreakLoc("[|]{2}"),
                new BreakLoc("[-+*/%&|^]"),
                new BreakLoc("[=]{2,3}"),
                new BreakLoc("[-+*/%&|^]=|<<=|>>=|>>>="),
                new BreakLoc("<|<=|>|>=|==|!="),
                new BreakLoc("[(]")
                );
        Collections.addAll(COMMENT_PROPERTY.breakLocs,
                new BreakLoc("\s+|[,.]")
                );
    }


    public LineWrappingProperty() {

    }

    public LineWrappingProperty(double variance, int maxLen, int maxLenBefore, List<BreakLoc> breakLocs, SucceedLoc succeedLoc) {
        this.variance = variance;
        this.maxLen = maxLen;
        this.maxLenBefore = maxLenBefore;
        this.breakLocs = breakLocs;
        this.succeedLoc = succeedLoc;
    }

    public LineWrappingProperty(SucceedLoc succeedLoc) {
        this.succeedLoc = succeedLoc;
    }

    @Override
    public void addElement(Element parent, MyParser parser) {

    }

    /**
     *
     * @param token
     * @return Priority of break location. -1 is returned when breaking around the token is prohibited.
     */
    public int getPriority(Token token) {
        for (int i = 0; i < breakLocs.size(); i++) {
            BreakLoc breakLoc = breakLocs.get(i);
            Matcher matcher = breakLoc.reg.matcher(token.getText());
            if (matcher.find()) {
                return i;
            }
        }
        return -1;
    }

    public boolean isLineWrapping(int len) {
        return maxLenBefore != maxLen && len >= maxLenBefore;
    }

    @Override
    public void parseElement(Element parent, MyParser parser) {
    }

    public Boolean getLocation(Token token) {
        for(BreakLoc breakLoc : breakLocs) {
            Matcher matcher = breakLoc.reg.matcher(token.getText());
            if (matcher.find()) {
                return breakLoc.after;
            }
        }
        return null;
    }

    public static class BreakLoc {
        // Indentation rule
        // Where to add newline, before or after the specific token ?
        Pattern reg;
        boolean after = true;

        public BreakLoc(String reg) {
            this.reg = Pattern.compile(reg);
        }

        public BreakLoc(String reg, boolean after) {
            this.reg = Pattern.compile(reg);
            this.after = after;
        }
    }

    public static class SucceedLoc {
        // Where to start the successive lines, align with the specific token or indent fixed length?
        public int relativeIndention = 0; // Fix indention relative to the beginning of the first line.

        public SucceedLoc(int relativeIndention) {
            this.relativeIndention = relativeIndention;
        }
    }
}
