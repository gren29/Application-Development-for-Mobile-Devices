#include <iostream>
using namespace std;

bool fibonacci(int num){
    int posX1 = 0;
    int posX2 = 1;
    int fib = 0;

    if(num == 0 || num == 1)return true;
    while(true){
        fib = posX1 + posX2;
        posX1 = posX2;
        posX2 = fib;
        if(fib == num)return true;
        if(fib > num) return false;
    }
    return false;
}

int main(){
    int num = 2;
    cout << fibonacci(num) << endl;

    return 0;
}