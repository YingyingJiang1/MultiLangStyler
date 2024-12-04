1. space style中添加的默认规则在filterRule之前消失了？？
```java
 public SpaceStyler() {
    style.setStyleName("space");
    // There's always a space between keywords and identifiers.
    String identifier = TokenGroup.IDENTIFIER.name(), keyword = TokenGroup.KEYWORD.name();
    style.addRule(new SpaceContext(keyword, identifier), new SpaceProperty(true));
    style.addRule(new SpaceContext(identifier, keyword), new SpaceProperty(true));
    style.addRule(new SpaceContext(keyword, keyword), new SpaceProperty(true));
    style.addRule(new SpaceContext(identifier, identifier), new SpaceProperty(true));
}

```
