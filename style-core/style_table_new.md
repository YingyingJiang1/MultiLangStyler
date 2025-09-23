| Category  | Style                                                 | Descirption and Example                                      | Granularity   | Source            |
| --------- | :---------------------------------------------------- | :----------------------------------------------------------- | :------------ | :---------------- |
| Format    | **Indention**                                         | 缩进的类型（空格或者tab健），每一级的缩进长度                | token         | oracle,google     |
|           | **Space**                                             | 词法单元之间使用或省略空格的习惯                             | token         | oracle,google     |
|           | **Newline**                                           | 语法单元间换行的使用习惯，包括换行的位置，数量和换行后的缩进规则 | token         | oracle,google     |
| Structure | **Optional brace**                                    | 是否显示使用{}包裹单个语句                                   | statement     | 2,oracle,google,8 |
|           | **Modifiers order**                                   | Order of all modifiers                                       | token         | google convention |
|           | ~~**Local variable placement**~~                      | ~~变量的声明位置，偏好放在作用域开头还是接近第一次使用~~     | ~~statement~~ | ~~1,oracle~~      |
|           | **Local variable declaration layout**                 | 是否合并同类型变量的声明                                     | statement     | 1,3,oracle,google |
|           | **Preference of operator **                           | Alternative operators preferences: (a>b,b<a),(a<=b,b>=a),(a==false, !a),(a=\=true,a) | expression    | 3                 |
|           | **Preference of literal position in bool expression** | 是否有literal常量优先的习惯                                  | expression    |                   |
|           | **Preference of increment or decrement**              | +1或-1操作的写法偏好                                         | statement     | 1                 |
|           | **Preference of assignment statement**                | 赋值操作的写法偏好                                           | statement     |                   |
|           | **Preference of array declaration**                   | C style和Java style的数组声明偏好                            | statement     | google convention |
|           | **Preference of  loop**                               | 循环结构的写法偏好(for, while)                               | statement     | 1,2,3,8           |
| Semantic  | **Order of if-else bodies**                           | if-else语句中，是否有先写较短逻辑的习惯                      | block         | 3                 |
|           | **Naming**                                            | 本地变量的命名习惯，包括长度限制和格式约定                   | token         | 1,oracle,google   |
|           | ~~**Expression Complexity**~~                         | ~~表达式复杂度超过目标值时，拆分为更小的子表达式~~           | ~~statement~~ |                   |
|           | **Preference of Compound if statements**              | "Use a logical operator in an if condition(e.g., if(a && b)) or use multiple if conditions(e.g., if(a){if(b){...}})" | block         | 1,2,3,8(Semantic) |
|           | **Preference of loop branch control**                 | 循环中，处理两个条件分支时是使用 if-else还是使用 continue    | block         |                   |
|           | **Preference of redundant code**                      | if (bool) {a++;b++} b++;<br />if (bool) {a++;}b++;           | block         |                   |
|           | **Preference of  check then return**                  | 检查后立即返回的模式的写法偏好(使用if-else分支或者三元表达式）。 | block         | oracle            |
|           | **Preference of  check then assign**                  | 检查后立即赋值的模式的写法偏好                               | block         | 3                 |
