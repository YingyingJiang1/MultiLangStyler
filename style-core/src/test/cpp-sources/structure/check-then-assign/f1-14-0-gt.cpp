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
    if (s.counter++ % 2 == 0) {
        t = s.counter;
    }

    long u = t;
    if (u > 0) {
        u = -t;
    }

    int x = 0;
    if (x > 0) { x = 1; }

    int a = 1;
    if (x > 0) { a = 2; }
}

void pointers(MyStruct s) {
    int v = 10;
    int* p = &v;
    if (*p > 5) { *p = 77; }

    int* q = &v;
    if (*p < v) { *q = 88; }

    MyStruct* r = &s;
    if (s.v == 0) { r = nullptr; }

    int* p1 = nullptr;
    if (r->counter == 1) { p1 = &r->v;  }

}

void arrayAndRefs() {
    vector<int> arr = {1,2,3};
    int v = arr[0];
    int idx = 1;
    if (idx < 2) { v = arr[idx]; }

    int& r1 = arr[0];
    if (idx == 1) { r1 = arr[idx]; }

    int tmp = 5;
    int& r2 = tmp;
    if (arr[1] > 1) { r2 = arr[2]; }

     int a = 0, b = 1;
     vector<vector<int>> mat = {{1,2},{3,4}};
     if (arr[a] == 2) { mat[b][a] = a; }

     int& ref = a;
     int t = side_effect_f(ref);
     if (ref > 1) { t = b; }

}

void complexType() {
    Color c = Color::Red;
    if (c == Color::Red) { c = Color::Green; }

    BitField bf{1, 2};
    if (c == Color::Red) { bf.b = 7; }

    Obj a(5);
    Obj b(1);
    if (a.v == 5) { b = a; }
}


