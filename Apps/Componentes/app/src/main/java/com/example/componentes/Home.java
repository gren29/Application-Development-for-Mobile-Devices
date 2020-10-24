package com.example.componentes;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class Home extends Activity {
    TextView lblnum;
    TextView lblPrimo;
    TextView lblFibonacci;
    TextView lblMaravilloso;
    TextView lblPalindromo;
    String numS;
    int num;
    Bundle bdl;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bdl = getIntent().getExtras();
        numS = bdl.getString("NUMERO");
        num = Integer.parseInt(numS);
        lblnum = (TextView)findViewById(R.id.lblnumero);
        lblPrimo = (TextView)findViewById(R.id.lblPrimo);
        lblFibonacci = (TextView)findViewById(R.id.lblFibonacci);
        lblMaravilloso = (TextView)findViewById(R.id.lblMaravilloso);
        lblPalindromo = (TextView)findViewById(R.id.lblPalindromo);

        lblnum.setText("NUMERO : "+ num);
        
        if(Primo(num))lblPrimo.setText("El "+num+" es Primo");
        else lblPrimo.setText("El "+num+" NO es Primo");

        if(Fibonacci(num))lblFibonacci.setText("El "+num+" es Fibonacci");
        else lblFibonacci.setText("El "+num+" NO es Fibonacci");

        if(Palindromo(Integer.toString(num)))lblPalindromo.setText("El "+num+ " es Palindromo");
        else lblPalindromo.setText("El "+num+ " NO es Palindromo");

        if (Maravilloso(num))lblMaravilloso.append("El "+num+" es Maravilloso");
        else lblMaravilloso.setText("El "+num+" NO es Maravilloso");
    }

    public boolean  Primo(int n){
        if(n < 2)return false;
        int sqrtN = (int) Math.sqrt(n);
        for(int i = 2;i <= sqrtN; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public boolean Fibonacci(int n){
        int posX1 = 0;
        int posX2 = 1;
        int fib = 0;

        if(n == 0 || n == 1)return true;
        while(true){
            fib = posX1 + posX2;
            posX1 = posX2;
            posX2 = fib;
            if(fib == n)return true;
            if(fib > n) return false;
        }
    }
    public boolean Maravilloso(int n){
        boolean isMara = false;
        if(n % 2 == 0){
            n /= 2;
            lblMaravilloso.append(" "+ n +"\n");
            if(n == 1)return true;
            else return Maravilloso(n);
        }
        else {
            n = n * 3 + 1;
            lblMaravilloso.append(" "+ n +"\n");
            if(n == 1)return true;
            else return Maravilloso(n);
        }
    }

    public boolean Palindromo(String s){
        int ini = 0;
        int fin = s.length()-1;
        boolean error = false;

        while ((ini<fin) && (!error)){

            if (s.charAt(ini)==s.charAt(fin)){
                ini++;
                fin--;
            } else {
                error = true;
            }
        }
        if(!error)return  true;
        else return  false;
    }
}
