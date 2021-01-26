#include <iostream>

using namespace std;
int matriz[8][8] = {
        {0,0,0,0,0,0,0,0},
        {0,0,1,1,0,0,0,0},
        {0,1,1,1,1,0,1,0},
        {0,1,1,1,1,1,1,0},
        {0,0,1,1,1,1,1,0},
        {0,0,1,1,1,1,1,0},
        {0,0,0,0,1,0,1,0},
        {0,0,0,0,0,0,0,0}
    }

void Imprimir(){
    for(int x = 0; x < 8;x++){
        for(int y = 0; y < 8;y++){
            cout << matriz[x][y];
        }
        cout << endl;
    }
}
int main(){
    Imprimir();
}