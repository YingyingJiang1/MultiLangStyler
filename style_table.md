| Granularity | Style                                            | Definition                                                   | Example | Source            | Progress           |
| :---------- | :----------------------------------------------- | :----------------------------------------------------------- | :------ | :---------------- | ------------------ |
| token       | Indention                                        | Indention type and unit                                      |         |                   | :bug:              |
| token       | Space                                            | Whether there're spaces around operators and seperators.     |         | oracle,google     | :bug:              |
| token       | One statement in one line                        | One statement or multiple statements in one line.            |         | oracle,google     | :bug:              |
| token       | Blank line                                       | Blank line density and the average distance between adjacent blank lines. |         | oracle,google     | :bug:              |
| token       | Line wrapping                                    | Whether to divide a long line into multiple lines.           |         | oracle,google     | :bug:              |
| token       | Brace format                                     | Whether there's a newline before and after {} of body of method and control structures. |         | oracle,google     | :bug:              |
| token       | Layout of control statement without braces       |                                                              |         |                   | :bug:              |
| token       | Mutliple-line comment syntax                     |                                                              |         |                   | :bug:              |
| token       | Comment density                                  | Comment lines as a percentage of total rows                  |         |                   | :bug:              |
| token       | Operator preferences                             | Alternative operators preferences: (>,<),(<=,>=),(==False, !),(=\=True,$\empty$) |         | 3                 | :bug:              |
| token       | Numerical literals                               | Use hard-code literals(except -1,0,1) or  constant declarations. |         | oracle            | :question:         |
| token       | **Naming convention**                            | format,genders(nouns/verbs...) and length of name of packages,classes, interfaces, methods, variables and constants. |         | 1,oracle,google   |                    |
| token       | Modifiers order                                  | Order of all modifiers                                       |         | google convention | :white_check_mark: |
| statement   | Optional brace                                   | Whether use {} in control statement with only one simple statement in body. |         | 2,oracle,google,8 | :bug:              |
| statement   | Number of variables in one declaration statement | One variable or multiple variables are declared in one statement. |         | 1,3,oracle,google |                    |
| statement   | Assignment statement preferences                 | Assignment statement or compound assignment statement.       |         |                   | :bug:              |
| statement   | Increment/decrement preferences                  | prefix or suffix, assignment or inc/dec                      |         | 1                 | :bug:              |
| statement   | Continuous logic and conditions preferences      | Nested if                                                    |         | 1,2,3,8           | :bug:              |
| statement   | Continuous logic or conditions preferences       |                                                              |         | 1,2,3,8           | :bug:              |
| statement   | Mutlibranch                                      | Cascading if-else or switch.                                 |         | 1,3               |                    |
| statement   | Continuous assignments or calls preferences      |                                                              |         | oracle            |                    |
| statement   | Contain complex bool expression                  |                                                              |         |                   |                    |
| statement   | Array declaration style                          |                                                              |         | google convention |                    |
| statement   | Update multiple variables in one statement       |                                                              |         | 1,oracle          |                    |
| statement   | Location of looping variable                     |                                                              |         | 2,8               |                    |
| statement   | Location of variabe declaration                  |                                                              |         | 1,oracle          |                    |
| statement   | Location of variable initialization              |                                                              |         | 1,oracle          |                    |
| statement   | Loops                                            |                                                              |         | 1,2,3,8           |                    |
| statement   | Return statements                                | Whether a `return` statement with a value uses parentheses   |         | oracle            | :bug:              |
| block       | Check then return preferences                    |                                                              |         | oracle            | :bug:              |
| block       | Check then assign preferences                    |                                                              |         | 3                 | :bug:              |
| block       | Continue preferences                             |                                                              |         |                   |                    |
| block       | Presence of the `default` label                  |                                                              |         | google convention |                    |
| block       | Create a variable for multiple uses              |                                                              |         |                   |                    |
| block       | Redundant code                                   |                                                              |         |                   |                    |
| block       | Contain unused code                              |                                                              |         | 2,3,8             |                    |
| block       | Order of if-else bodies                          |                                                              |         | 3                 |                    |
| expression  | Literal position in bool expression              |                                                              |         |                   | :bug:              |
| expression  | Field access in class                            |                                                              |         |                   |                    |
| expression  | Static members access                            |                                                              |         | oracle,google     |                    |
| expression  | Parentheses in expressions                       | Focus on parentheses in two places:expressions involving mixed operators,expression containing a binary operator appears before the `?` in the ternary `?:` operator |         | oracle,google     |                    |
| function    | Order of function parameters                     |                                                              |         | 3                 |                    |
| function    | Function complexity                              | Nested depth and lines of code in function                   |         | 1,8               |                    |
| class       | Ordering of class contents                       |                                                              |         | google convention | :bug:              |