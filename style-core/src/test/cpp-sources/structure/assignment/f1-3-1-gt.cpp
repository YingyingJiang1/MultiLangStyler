#include <iostream>
using namespace std;

int main() {
    int x = 1;
    int y = 2;

    // id=3 (assignment1): "$E = $E1 $HOMO_BOP $E2 ;"  ->  "$E $HOMO_BOP_ASSIGN $E2 ;"
    x += y;
    x -= y;

    cout << x << "\n";
    return 0;
}

