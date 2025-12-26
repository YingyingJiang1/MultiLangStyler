#include <iostream>
#include <vector>
#include <memory>
#include <stdexcept>
using namespace std;

// ================================================================
//  Case 1: $M $T $I = $E2 ; if ( $E ) { $E3 = $E1 ; }
// ================================================================

struct MyStruct {
    int counter = 0;
    int v;
    int& ref;
    unsigned a : 3;
    unsigned b : 5;
};

struct Obj {
    int v;
    Obj(int v) : v(v) {}
    Obj(const Obj& other) : v(other.v + 10) {}
};

enum class Color { Red, Green, Blue };

int primitiveTypes(const MyStruct& s) {
    static int t = 0;
     t = (s.counter++ % 2 == 0) ? s.counter : 0;

    long u = (t > 0) ? -t : t;

    int x = (0 > 0) ? 1 : 0;

    int a = (x > 0) ? 2 : 1;
}

void pointers(MyStruct s) {
    int v = 10;

    int* p = &v;
    *p = (*p > 5) ? 77 : *p;

    int* q = &v;
    *q = (*p < v) ? 88 : *q;

    MyStruct* r = &s;
    r = (s.v == 0) ? nullptr : r;

    int* p1 = nullptr;
    p1 = (r->counter == 1) ? &r->v : p1;
}

void arrayAndRefs() {
    vector<int> arr = {1,2,3};

    int v = (1 < 2) ? arr[1] : arr[0];

    int idx = 1;

    int& r1 = arr[0];
    r1 = (idx == 1) ? arr[idx] : r1;

    int tmp = 5;
    int& r2 = tmp;
    r2 = (arr[1] > 1) ? arr[2] : r2;

    int a = 0, b = 1;
    vector<vector<int>> mat = {{1,2},{3,4}};
    mat[b][a] = (arr[a] == 2) ? a : mat[b][a];

    int& ref = a;
    int t = side_effect_f(ref);
    t = (ref > 1) ? b : t;
}

void complexType() {
    Color c = (Color::Red == Color::Red) ? Color::Green : Color::Red;

    BitField bf{1, 2};
    bf.b = (c == Color::Red) ? 7 : bf.b;

    Obj a(5);
    Obj b(1);
    b = (a.v == 5) ? a : b;
}
