#include<iostream>
#include<vector>
#include<string>

class Point{
public:
    int x,y;
    Point(int x,int y):x(x),y(y){}
    void move(int dx,int dy){
        x+=dx;
        y+=dy;
    }
};

template<typename T>
T add(T a,T b){
    return a+b;
}

int main(){
    int a=10,b=20;
    auto sum=add(a,b);

    Point p(1,2);
    p.move(3,4);

    std::vector<int> nums={1,2,3,4};
    for(int i=0;i<nums.size();i++){
        std::cout<<nums[i]<<" ";
    }

    if(sum>20){
        std::cout<<"big"<<std::endl;
    }else{
        std::cout<<"small"<<std::endl;
    }

    return 0;
}
