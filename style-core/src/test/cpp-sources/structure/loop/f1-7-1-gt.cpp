#include <iostream>
using namespace std;

int main() {
    int i = 0;
    int sum = 0;

    // id=7 (loop1): "for ( ; E ; ) S"  ->  "while ( E ) S"
    for (; i < 3; ) {
        sum += i;
        ++i;
    }

    cout << sum << "\n";
    return 0;
}

