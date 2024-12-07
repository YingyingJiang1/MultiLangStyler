package org.example.semantic.intf;

import java.util.Objects;

public interface Reference {
    Symbol getDefSymbol();
    Object getAstNode();
}
