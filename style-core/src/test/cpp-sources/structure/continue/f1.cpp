#include <iostream>
using namespace std;

int main() {
    int acc = 0;

    // id=22 (continue_jump1):
    // "$^ if ( E ) { continue ; }  S+"  <-> "if ( E ) { continue ; } else { S+ }" <-> "if ( E ) { S+ }"
    for (int i = 0; i < 5; ++i) {
        if (i % 2 == 0) {
            continue;
        }
        acc += i;
    }

    cout << acc << "\n";
    return 0;
}

