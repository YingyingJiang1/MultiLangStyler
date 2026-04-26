#include <iostream>
using namespace std;

int main() {
    int a = 1;
    int b = 2;
    int v = 0;

    // id=4 (nesting if): "if ( E && E1 ) S"  ->  "if ( E ) { if ( E1 ) S }"
    if (a > 0 && b > 0) {
        v = 1;
    }

    cout << v << "\n";
    return 0;
}

