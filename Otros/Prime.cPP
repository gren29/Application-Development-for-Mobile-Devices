#include <iostream>
#include <math.h>
using namespace std;

bool Prime(int n){
    if(n < 2)return false;
    int sqrtN = (int) sqrt(n);
    for(int i = 2;i <= sqrtN; i++){
        if(n % i == 0) return false;
    }
    return true;
}

int main(){
    cout << Prime(4) << endl;
    return 0;
}

