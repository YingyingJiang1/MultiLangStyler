package org.example.styler.arrangement.style;

public class ArrangementRule {
    ArrangementContext arrangementContext = new ArrangementContext();
    ArrangementProperty arrangementProperty = new ArrangementProperty();

    public ArrangementRule(ArrangementContext context, ArrangementProperty property) {
        this.arrangementContext = context;
        this.arrangementProperty = property;
    }

}
