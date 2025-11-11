/*
 [The "BSD licence"]
 Copyright (c) 2013 Terence Parr, Sam Harwell
 Copyright (c) 2017 Ivan Kochurkin (upgrade to Java 8)
 Copyright (c) 2021 Michał Lorek (upgrade to Java 11)
 Copyright (c) 2022 Michał Lorek (upgrade to Java 17)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

// $antlr-format alignTrailingComments true, columnLimit 150, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine true, allowShortBlocksOnASingleLine true, minEmptyLines 0, alignSemicolons ownLine
// $antlr-format alignColons trailing, singleLineOverrulesHangingColon true, alignLexerCommands true, alignLabels true, alignTrailers true

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// Make sure all tokens have the same names in different .g4 files.
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

lexer grammar JavaLexer;

channels {COMMENT_CHANNEL}

//--------------------------------------------------- Primitive type keywords ---------------------------------------------------
BOOLEAN      : 'boolean';
BYTE         : 'byte';
CHAR         : 'char';
DOUBLE       : 'double';
FLOAT        : 'float';
INT          : 'int';
LONG         : 'long';
SHORT        : 'short';
VOID         : 'void';

//---------------------------------------------------  Control keywords ---------------------------------------------------
CATCH        : 'catch';
DO           : 'do';
ELSE         : 'else';
FINALLY      : 'finally';
FOR          : 'for';
IF           : 'if';
SWITCH       : 'switch';
TRY          : 'try';
WHILE        : 'while';
GOTO         : 'goto';
BREAK        : 'break';
CASE         : 'case';
CONTINUE     : 'continue';
RETURN       : 'return';

//---------------------------------------------------  Other keywords ---------------------------------------------------
ABSTRACT     : 'abstract';
ASSERT       : 'assert';
CLASS        : 'class';
CONST        : 'const';
DEFAULT      : 'default';
ENUM         : 'enum';
EXTENDS      : 'extends';
FINAL        : 'final';
IMPLEMENTS   : 'implements';
IMPORT       : 'import';
INSTANCEOF   : 'instanceof';
INTERFACE    : 'interface';
NATIVE       : 'native';
NEW          : 'new';
PACKAGE      : 'package';
PRIVATE      : 'private';
PROTECTED    : 'protected';
PUBLIC       : 'public';
STATIC       : 'static';
STRICTFP     : 'strictfp';
SUPER        : 'super';
SYNCHRONIZED : 'synchronized';
THIS         : 'this';
THROW        : 'throw';
THROWS       : 'throws';
TRANSIENT    : 'transient';
VOLATILE     : 'volatile';


// Module related keywords
MODULE     : 'module';
OPEN       : 'open';
REQUIRES   : 'requires';
EXPORTS    : 'exports';
OPENS      : 'opens';
TO         : 'to';
USES       : 'uses';
PROVIDES   : 'provides';
WITH       : 'with';
TRANSITIVE : 'transitive';

// Local Variable Type Inference
VAR: 'var';// reserved type name

// Switch Expressions
YIELD: 'yield'; // reserved type name from Java 14

// Records
RECORD: 'record';

// Sealed Classes
SEALED     : 'sealed';
PERMITS    : 'permits';
NON_SEALED : 'non-sealed';

//---------------------------------------------------  Literals ---------------------------------------------------

// Integer Literal !!! DECIMAL_LITERAL must be the first of integer literal while BINARY_LITERAL must be the last.!!!
DECIMAL_LITERAL : ('0' | [1-9] (Digits? | '_'+ Digits)) [lL]?;
HEX_LITERAL     : '0' [xX] [0-9a-fA-F] ([0-9a-fA-F_]* [0-9a-fA-F])? [lL]?;
OCT_LITERAL     : '0' '_'* [0-7] ([0-7_]* [0-7])? [lL]?;
BINARY_LITERAL  : '0' [bB] [01] ([01_]* [01])? [lL]?;

// Float Literal
FLOAT_LITERAL:
    ((Digits '.' Digits? | '.' Digits) ExponentPart? [fFdD]?
    | Digits (ExponentPart [fFdD]? | [fFdD]));
HEX_FLOAT_LITERAL: '0' [xX] (HexDigits '.'? | HexDigits? '.' HexDigits) [pP] [+-]? Digits [fFdD]?;

// String Literal
CHAR_LITERAL: '\'' (~['\\\r\n] | EscapeSequence) '\'';
STRING_LITERAL: '"' (~["\\\r\n] | EscapeSequence)* '"';
TEXT_BLOCK: '"""' [ \t]* [\r\n] (. | EscapeSequence)*? '"""';

BOOL_LITERAL: 'true' | 'false';

NULL_LITERAL: 'null';

//--------------------------------------------------- Binary operators ---------------------------------------------------

QUESTION : '?';
COLON    : ':';
//--------------------------------------------------- binary compare operators  ---------------------------------------------------
GT       : '>';
LT       : '<';
EQUAL    : '==';
LE       : '<=';
GE       : '>=';
NOTEQUAL : '!=';
//--------------------------------------------------- binary logical operators  ---------------------------------------------------
AND      : '&&';
OR       : '||';
//--------------------------------------------------- binary arithmetic operators ---------------------------------------------------
ADD      : '+';
SUB      : '-';
MUL      : '*';
DIV      : '/';
MOD      : '%';
//--------------------------------------------------- binary bit operators ---------------------------------------------------
BITAND   : '&';
BITOR    : '|';
CARET    : '^';

//--------------------------------------------------- binary assign operators ---------------------------------------------------
ASSIGN   : '=';
ADD_ASSIGN     : '+=';
SUB_ASSIGN     : '-=';
MUL_ASSIGN     : '*=';
DIV_ASSIGN     : '/=';
AND_ASSIGN     : '&=';
OR_ASSIGN      : '|=';
XOR_ASSIGN     : '^=';
MOD_ASSIGN     : '%=';
LSHIFT_ASSIGN  : '<<=';
RSHIFT_ASSIGN  : '>>=';
URSHIFT_ASSIGN : '>>>=';

//--------------------------------------------------- Unary operators ---------------------------------------------------

TILDE    : '~';
BANG     : '!';
INC      : '++';
DEC      : '--';

//--------------------------------------------------- Separators ---------------------------------------------------

LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
LBRACK : '[';
RBRACK : ']';
SEMI   : ';';
COMMA  : ',';
DOT    : '.';

//--------------------------------------------------- Whitespace ---------------------------------------------------

HWS          : [\t\u000C\u0020]+ -> channel(HIDDEN);
VWS          : [\r\n]+ -> channel(HIDDEN);

//--------------------------------------------------- Other cases ---------------------------------------------------
BLOCK_COMMENT: '/*' .*? '*/' -> channel(COMMENT_CHANNEL);
LINE_COMMENT: '//' ~[\r\n]* HwsLineBreak -> channel(COMMENT_CHANNEL);

// Identifiers
IDENTIFIER: Letter LetterOrDigit*;

// Java 8 tokens
ARROW      : '->';
COLONCOLON : '::';

// Additional symbols not defined in the lexical specification
AT       : '@';
ELLIPSIS : '...';

COVER   : [\u0000-\uFFFF] ; // covers all characters

//--------------------------------------------------- Fragment rules ---------------------------------------------------

fragment ExponentPart: [eE] [+-]? Digits;

fragment EscapeSequence:
    '\\' 'u005c'? [btnfr"'\\]
    | '\\' 'u005c'? ([0-3]? [0-7])? [0-7]
    | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
;

fragment HexDigits: HexDigit ((HexDigit | '_')* HexDigit)?;

fragment HexDigit: [0-9a-fA-F];

fragment Digits: [0-9] ([0-9_]* [0-9])?;

fragment LetterOrDigit: Letter | [0-9];

fragment Letter:
    [a-zA-Z$_]                        // these are the "java letters" below 0x7F
    /*| ~[\u0000-\u007F\uD800-\uDBFF]   // covers all characters above 0x7F which are not a surrogate
    | [\uD800-\uDBFF] [\uDC00-\uDFFF] // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF*/
;

fragment HwsLineBreak: ([\t\u000C\u0020]* [\r]?'\n')?;
