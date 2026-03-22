package org.example.style;

public enum InconsistencyType {
    INDENTATION,           // 缩进
    SPACING,               // 空格
    NEWLINE,               // 换行
    MODIFIER_ORDER,        // 修饰符顺序
    NAMING,         // 命名格式
    DECLARATION_LAYOUT,    // 声明布局
    BRACE_STYLE,           // 大括号风格
    PARAMETER_LAYOUT,      // 参数布局
    STATEMENT_ORDER,       // 语句顺序
    IF_ELSE_ORDER,         // if-else分支顺序
    IMPORT_ORDER,          // import顺序
    ANNOTATION_LAYOUT,     // 注解布局
    COMMENT_STYLE,         // 注释风格
    VARIABLE_INITIALIZATION, // 变量初始化方式
    FUNCTION_LAYOUT,       // 函数布局
    CLASS_LAYOUT,          // 类布局
    ACCESSIBILITY,         // 可访问性修饰符
    SEMICOLON_USAGE,       // 分号使用
    TYPE_ANNOTATION,       // 类型注解
    OTHER                  // 其他未归类类型
}