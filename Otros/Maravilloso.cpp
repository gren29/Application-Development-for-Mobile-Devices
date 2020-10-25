#include <iostream>
using namespace std;

bool Maravilloso(int num){
   bool isMara = false;
   if(num % 2 == 0){
       num /= 2;
       if(num == 1)return true;
       else return Maravilloso(num);
   }  
   else {
       num = num * 3 + 1;
       if(num == 1)return true;
       else return Maravilloso(num);
   }
   return false;
}

int main(){
    int num = 7;
     cout << Maravilloso(num) << endl;
    return 0;
}