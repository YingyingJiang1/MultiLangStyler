#include <iostream>
#include <vector>

namespace T {
    class A{
        public:
        A(int v):x(v)
        {}
        int f(const std::vector<int>& v){
            int r=0;
            for(auto i:v)
                if(i>x)
                    r += i;
            return r;
        }
        private: int x;
    };
}

int g(int n){
    switch(n){
        case 0:
            return 1;
        default:
        {
            int k=n;
            if(k<5)
                return k+1;
            return k*2;
        }
    }
}

int main(){
    using namespace T;
    A a(1);
    auto L=
    [&](int x){
        return x + a.f({1,
            2,3});
    };
    int r=0;
    do{
        r=L(g(r));
        if(r>10)
            break;
    }while(true);
    std::cout<<r;
}
