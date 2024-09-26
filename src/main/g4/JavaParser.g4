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

// $antlr-format alignTrailingComments true, columnLimit 150, minEmptyLines 1, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine false, allowShortBlocksOnASingleLine true, alignSEMI colons hanging, alignColons hanging

parser grammar JavaParser;

options {
    tokenVocab = JavaLexer;
    contextSuperClass = org.example.ExtendContext;
}

compilationUnit
    : packageDeclaration? (importDeclarationList? | SEMI* ) (typeDeclarationList? | SEMI* )
    | moduleDeclaration EOF
    ;

importDeclarationList: importDeclaration+;

typeDeclarationList: (typeDeclaration SEMI* )+;

packageDeclaration
    : annotationList PACKAGE qualifiedName
    SEMI
    ;

importDeclaration
    : IMPORT STATIC? qualifiedName (DOT MUL)? SEMI
    ;


modifierList
    : (
    annotation
    | PUBLIC
    | PROTECTED
    | PRIVATE
    | STATIC
    | ABSTRACT
    | FINAL // FINAL for class only -- does not apply to interfaces
    | STRICTFP
    | SEALED     // Java17
    | NON_SEALED // Java17
    | NATIVE
    | SYNCHRONIZED
    | TRANSIENT
    | VOLATILE
    | STRICTFP
    | DEFAULT
)*;

// Do not modifier this rule!
typeDeclaration
    :
    modifierList (
    classHead
    | interfaceHead
    | recordHead
    | enumHead
    | annotationTypeHead
    )
    body
    ;

classHead
    : CLASS identifier typeParameters? (EXTENDS typeType)? (IMPLEMENTS typeList)? (PERMITS typeList )?// Java17
    ;

interfaceHead
    : INTERFACE identifier typeParameters? (EXTENDS typeList)? (PERMITS typeList)?
    ;

recordHead
    : RECORD identifier typeParameters? recordHeader (IMPLEMENTS typeList)?
    ;

enumHead
    : ENUM identifier (IMPLEMENTS typeList)?
    ;

annotationTypeHead
    : AT INTERFACE identifier
    ;

body
    : LBRACE classBodyDeclaration* RBRACE
    | LBRACE enumConstants? COMMA? (SEMI  classBodyDeclaration*)? RBRACE
    | LBRACE annotationTypeElementDeclaration* RBRACE
    | LBRACE moduleDirective* RBRACE
    ;


typeParameters
    : LT typeParameter (COMMA typeParameter)* GT
    ;

typeParameter
    : annotationList identifier (EXTENDS annotationList typeBound)?
    ;

typeBound
    : typeType (BITAND typeType)*
    ;

enumConstants
    : enumConstant (COMMA enumConstant)*
    ;

enumConstant
    : annotationList identifier arguments? classBody = body?
    ;

classBodyDeclaration
    : SEMI
    | initializerList
    | fieldDeclarationList
    | constructorDeclarationList
    | methodDeclarationList
    | typeDeclarationList
    ;

initializer: modifierList block; // STATIC? block;

initializerList
    : (initializer SEMI* )+;

fieldDeclarationList
    : (fieldDeclaration SEMI* )+;

constructorDeclarationList
    :(constructorDeclaration SEMI* )+;

methodDeclarationList
    : (methodDeclaration SEMI* )+;

//memberDeclaration
//    : recordDeclaration //Java17
//    | methodDeclaration
//    | genericMethodDeclaration
//    | fieldDeclaration
//    | constructorDeclaration
//    | genericConstructorDeclaration
//    | interfaceDeclaration
//    | annotationTypeDeclaration
//    | classDeclaration
//    | enumDeclaration
//    ;

/* We use rule this even for void methods which cannot have [] after parameters.
   This simplifies grammar and we can consider void to be a type, which
   renders the [] matching as a writtenContext-sensitive issue or a semantic check
   for invalid return type after parsing.
 */
methodDeclaration
    : modifierList methodHead (SEMI  | block)
    ;

methodHead
    : typeParameters? typeType identifier formalParameters (LBRACK RBRACK)* (THROWS qualifiedNameList)? // method head
    ;


constructorDeclaration
    : modifierList constructorHead constructorBody = block
    ;

constructorHead
    : typeParameters? identifier formalParameters (THROWS qualifiedNameList)? // constructor head
    | identifier // compact constructor head
    ;

fieldDeclaration
    : modifierList typeType variableDeclarators SEMI
    ;


constDeclarationList: (constDeclaration SEMI* )+;

constDeclaration
    : modifierList typeType constantDeclarator (COMMA constantDeclarator)* SEMI
    ;

constantDeclarator
    : identifier (LBRACK RBRACK)* ASSIGN variableInitializer
    ;

variableDeclarators
    : variableDeclarator (COMMA variableDeclarator)*
    ;

variableDeclarator
    : variableDeclaratorId (ASSIGN variableInitializer)?
    ;

variableDeclaratorId
    : identifier (LBRACK RBRACK)*
    ;

variableInitializer
    : arrayInitializer
    | expression
    ;

arrayInitializer
    : LBRACE (variableInitializer (COMMA variableInitializer)* COMMA?)? RBRACE
    ;

classOrInterfaceType
    : (identifier typeArguments? DOT)* typeIdentifier typeArguments?
    ;

typeArgument
    : typeType
    | annotationList QUESTION ((EXTENDS | SUPER) typeType)?
    ;

qualifiedNameList
    : qualifiedName (COMMA qualifiedName)*
    ;

formalParameters
    : LPAREN (
        receiverParameter?
        | receiverParameter (COMMA formalParameterList)?
        | formalParameterList?
    ) RPAREN
    ;

receiverParameter
    : typeType (identifier DOT)* THIS
    ;

formalParameterList
    : formalParameter (COMMA formalParameter)* (COMMA lastFormalParameter)?
    | lastFormalParameter
    ;

formalParameter
    : modifierList typeType variableDeclaratorId
    ;

lastFormalParameter
    : modifierList typeType annotationList ELLIPSIS variableDeclaratorId
    ;

// local variable type inference
lambdaLVTIList
    : lambdaLVTIParameter (COMMA lambdaLVTIParameter)*
    ;

lambdaLVTIParameter
    : modifierList VAR identifier
    ;

qualifiedName
    : identifier (DOT identifier)*
    ;

literal
    : integerLiteral
    | floatLiteral
    | CHAR_LITERAL
    | STRING_LITERAL
    | BOOL_LITERAL
    | NULL_LITERAL
    | TEXT_BLOCK // Java17
    ;

integerLiteral
    : DECIMAL_LITERAL
    | HEX_LITERAL
    | OCT_LITERAL
    | BINARY_LITERAL
    ;

floatLiteral
    : FLOAT_LITERAL
    | HEX_FLOAT_LITERAL
    ;

// ANNOTATIONS
altAnnotationQualifiedName
    : (identifier DOT)* AT identifier
    ;

annotationList: annotation*;

annotation
    : (AT qualifiedName | altAnnotationQualifiedName) (
        LPAREN ( elementValuePairs | elementValue)? RPAREN
    )?
    ;

elementValuePairs
    : elementValuePair (COMMA elementValuePair)*
    ;

elementValuePair
    : identifier ASSIGN elementValue
    ;

elementValue
    : expression
    | annotation
    | elementValueArrayInitializer
    ;

elementValueArrayInitializer
    : LBRACE (elementValue (COMMA elementValue)*)? COMMA? RBRACE
    ;

annotationTypeElementDeclaration
    : modifierList annotationTypeElementRest
    | SEMI  // this is not allowed by the grammar, but apparently allowed by the actual compiler
    ;

annotationTypeElementRest
    : typeType annotationMethodOrConstantRest SEMI
    | typeDeclaration SEMI ?
    ;

annotationMethodOrConstantRest
    : annotationMethodRest
    | annotationConstantRest
    ;

annotationMethodRest
    : identifier LPAREN RPAREN defaultValue?
    ;

annotationConstantRest
    : variableDeclarators
    ;

defaultValue
    : DEFAULT elementValue
    ;

// MODULES - Java9

moduleDeclaration
    : OPEN? MODULE qualifiedName moduleBody = body
    ;


moduleDirective
    : REQUIRES requiresModifier* qualifiedName SEMI
    | EXPORTS qualifiedName (TO qualifiedName)? SEMI
    | OPENS qualifiedName (TO qualifiedName)? SEMI
    | USES qualifiedName SEMI
    | PROVIDES qualifiedName WITH qualifiedName SEMI
    ;

requiresModifier
    : TRANSITIVE
    | STATIC
    ;

// RECORDS - Java 17

recordHeader
    : LPAREN recordComponentList? RPAREN
    ;

recordComponentList
    : recordComponent (COMMA recordComponent)*
    ;

recordComponent
    : typeType identifier
    ;

// STATEMENTS / BLOCKS

block
    : LBRACE (typeDeclaration | statement)* RBRACE
    | LBRACE switchBlockStatementGroup* switchLabel* RBRACE
    | LBRACE switchLabeledRule* RBRACE // Java 17
    ;

switchBlockStatementGroup
    : switchLabel+ (typeDeclaration | statement)+
    ;

localVariableDeclarationStmt
    : localVariableDeclaration SEMI
    ;

localVariableDeclaration
    : modifierList (VAR identifier ASSIGN expression | typeType variableDeclarators)
    ;

identifier
    : IDENTIFIER
    | MODULE
    | OPEN
    | REQUIRES
    | EXPORTS
    | OPENS
    | TO
    | USES
    | PROVIDES
    | WITH
    | TRANSITIVE
    | YIELD
    | SEALED
    | PERMITS
    | RECORD
    | VAR
    ;

typeIdentifier // Identifiers that are not restricted for type declarations
    : IDENTIFIER
    | MODULE
    | OPEN
    | REQUIRES
    | EXPORTS
    | OPENS
    | TO
    | USES
    | PROVIDES
    | WITH
    | TRANSITIVE
    | SEALED
    | PERMITS
    | RECORD
    ;



statement
    : blockLabel = block
    | localVariableDeclarationStmt
    | assertStmt
    | ifStmt
    | ifElseStmt
    | forStmt
    | whileStmt
    | doWhileStmt
    | tryCatchStmt
    | tryResourceStmt
    | switchStmt
    | syncStmt
    | returnStmt
    | throwStmt
    | breakStmt
    | continueStmt
    | yieldStmt
    | SEMI
    | expressionStmt
    | labelStmt
    ;

assertStmt
    : ASSERT expression (COLON expression)? SEMI
    ;

ifStmt
    : IF parExpression statement
    ;

ifElseStmt
    : IF parExpression statement ELSE statement
    ;

forStmt
    : FOR LPAREN forControl RPAREN statement
    ;

whileStmt
    : WHILE parExpression statement
    ;

doWhileStmt
    : DO statement WHILE parExpression SEMI
    ;

tryCatchStmt
    : TRY block (catchClause+ finallyBlock? | finallyBlock)
    ;

tryResourceStmt
    : TRY resourceSpecification block catchClause* finallyBlock?
    ;

switchStmt
    : SWITCH parExpression block
    ;

syncStmt
    : SYNCHRONIZED parExpression block
    ;

returnStmt
    : RETURN expression? SEMI
    ;

throwStmt
    : THROW expression SEMI
    ;

breakStmt
    : BREAK identifier? SEMI
    ;

continueStmt
    : CONTINUE identifier? SEMI
    ;

yieldStmt
    : YIELD expression SEMI  // Java17
    ;

expressionStmt
    : statementExpression = expression SEMI
    ;

labelStmt
    : identifierLabel = identifier COLON statement
    ;


catchClause
    : CATCH LPAREN modifierList catchType identifier RPAREN block
    ;

catchType
    : qualifiedName (BITOR qualifiedName)*
    ;

finallyBlock
    : FINALLY block
    ;


resourceSpecification
    : LPAREN resources SEMI ? RPAREN
    ;

resources
    : resource (SEMI  resource)*
    ;

resource
    : modifierList (classOrInterfaceType variableDeclaratorId | VAR identifier) ASSIGN expression
    | qualifiedName
    ;

switchLabel
    : CASE (
        constantExpression = expression
        | enumConstantName = IDENTIFIER
        | typeType varName = identifier
    ) COLON
    | DEFAULT COLON
    ;

forControl
    : enhancedForControl
    | forInit? SEMI  expression? SEMI  forUpdate = expressionList?
    ;

forInit
    : localVariableDeclaration
    | expressionList
    ;

enhancedForControl
    : modifierList (typeType | VAR) variableDeclaratorId COLON expression
    ;

// EXPRESSIONS

parExpression
    : LPAREN expression RPAREN
    ;

expressionList
    : expression (COMMA expression)*
    ;

methodCall
    : (identifier | THIS | SUPER) arguments
    ;

expression
    // Expression order in accordance with https://introcs.cs.princeton.edu/java/11precedence/
    // Primary
    : LPAREN expression RPAREN
    | THIS
    | SUPER
    | literal
    | identifier
    | typeType DOT CLASS
    | nonWildcardTypeArguments (explicitGenericInvocationSuffix | THIS arguments)
    // Level 16, array and member access
    | expression LBRACK expression RBRACK
    | expression bop = DOT (
        identifier
        | methodCall
        | THIS
        | NEW nonWildcardTypeArguments? innerCreator
        | SUPER superSuffix
        | explicitGenericInvocation
    )
    // Method calls and method references are part of primary, and hence level 16 precedence
    | methodCall
    | expression COLONCOLON typeArguments? identifier
    | typeType COLONCOLON (typeArguments? identifier | NEW)
    | classType COLONCOLON typeArguments? NEW
    | SWITCH parExpression block // Java17

    // Level 15 Post-increment/decrement operators
    | expression postfix = (INC | DEC)

    // Level 14, Unary operators
    | prefix = (ADD | SUB | INC | DEC | TILDE | BANG) expression

    // Level 13 Cast and object creation
    | LPAREN annotationList typeType (BITAND typeType)* RPAREN expression
    | NEW creator

    // Level 12 to 1, Remaining operators
    | expression bop = (MUL | DIV | MOD) expression           // Level 12, Multiplicative operators
    | expression bop = (ADD | SUB) expression                 // Level 11, Additive operators
    | expression (LT LT| GT GT | GT GT GT) expression // Level 10, Shift operators
    | expression bop = (LE | GE | GT | LT) expression   // Level 9, Relational operators
    | expression bop = INSTANCEOF (typeType | pattern)
    | expression bop = (EQUAL | NOTEQUAL) expression                      // Level 8, Equality Operators
    | expression bop = BITAND expression                                // Level 7, Bitwise AND
    | expression bop = CARET expression                                // Level 6, Bitwise XOR
    | expression bop = BITOR expression                                // Level 5, Bitwise OR
    | expression bop = AND expression                               // Level 4, Logic AND
    | expression bop = OR expression                               // Level 3, Logic OR
    | <assoc = right> expression bop = QUESTION expression COLON expression // Level 2, Ternary
    // Level 1, Assignment
    | <assoc = right> expression bop = (
        ASSIGN
        | ADD_ASSIGN
        | SUB_ASSIGN
        | MUL_ASSIGN
        | DIV_ASSIGN
        | AND_ASSIGN
        | OR_ASSIGN
        | XOR_ASSIGN
        | RSHIFT_ASSIGN
        | URSHIFT_ASSIGN
        | LSHIFT_ASSIGN
        | MOD_ASSIGN
    ) expression

    // Level 0, Lambda Expression
    | lambdaExpression // Java8
    ;

// Java17
pattern
    : modifierList typeType annotationList identifier
    ;

// Java8
lambdaExpression
    : lambdaParameters ARROW lambdaBody
    ;

// Java8
lambdaParameters
    : identifier
    | LPAREN formalParameterList? RPAREN
    | LPAREN identifier (COMMA identifier)* RPAREN
    | LPAREN lambdaLVTIList? RPAREN
    ;

// Java8
lambdaBody
    : expression
    | block
    ;

// Java17
// Java17
switchLabeledRule
    : CASE (expressionList | NULL_LITERAL | guardedPattern) (ARROW | COLON) (typeDeclaration | statement)*
    | DEFAULT (ARROW | COLON) (typeDeclaration | statement)*
    ;

// Java17
guardedPattern
    : LPAREN guardedPattern RPAREN
    | modifierList typeType annotationList identifier (AND expression)*
    | guardedPattern AND expression
    ;

// Java17
classType
    : (classOrInterfaceType DOT)? annotationList identifier typeArguments?
    ;

creator
    : nonWildcardTypeArguments? createdName classCreatorRest
    | createdName arrayCreatorRest
    ;

createdName
    : identifier typeArgumentsOrDiamond? (DOT identifier typeArgumentsOrDiamond?)*
    | primitiveType
    ;

innerCreator
    : identifier (LT GT | nonWildcardTypeArguments)? classCreatorRest
    ;

arrayCreatorRest
    : (LBRACK RBRACK)+ arrayInitializer
    | (LBRACK expression RBRACK)+ (LBRACK RBRACK)*
    ;

classCreatorRest
    : arguments classBody = body?
    ;

explicitGenericInvocation
    : nonWildcardTypeArguments explicitGenericInvocationSuffix
    ;

typeArgumentsOrDiamond
    : LT GT
    | typeArguments
    ;

nonWildcardTypeArguments
    : LT typeList GT
    ;

typeList
    : typeType (COMMA typeType)*
    ;

typeType
    : annotationList (classOrInterfaceType | primitiveType) (annotationList LBRACK RBRACK)*
    ;

primitiveType
    : BOOLEAN
    | CHAR
    | BYTE
    | SHORT
    | INT
    | LONG
    | FLOAT
    | DOUBLE
    | VOID
    ;

typeArguments
    : LT typeArgument (COMMA typeArgument)* GT
    ;

superSuffix
    : arguments
    | DOT typeArguments? identifier arguments?
    ;

explicitGenericInvocationSuffix
    : SUPER superSuffix
    | identifier arguments
    ;

arguments
    : LPAREN expressionList? RPAREN
    ;