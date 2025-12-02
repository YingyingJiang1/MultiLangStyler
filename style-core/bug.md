## Space
### 问题
1. 无法处理文件的Directive相关的空格，因为词法文件中把Directive视为字符串。
   ```cpp
   #include <iostream>
   #include <vector>
    ```
   上面的内容被视为如下的词法单元流：`Directive("#include <iostream>") newline Directive("#include <vector>") newline`

2. 若干连续的token，逻辑上为一个整体，但是在词法单元流中被拆分为独立的token，这些需要特殊处理
   ```cpp
   int main() {
    std::vector<int> nums = { 1, 2, 3, 4 };
    for ( int i = 0; i < nums.size(); i++ ) {
        std::cout << nums[ i ] << " ";
    }
   }
    ```
其中的`<<`逻辑上为一个二元操作符，但是在token单元流中为：`less("<") less("<")`

### 解决方案
+ [ ] 1-2：实现一个Iterator用来封装对token流的访问细节，内部可以自由对任何token进行特殊处理。