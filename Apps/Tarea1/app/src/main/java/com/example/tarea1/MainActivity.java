package com.example.tarea1;

import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView lblNumero;
    TextView lblPrimo;
    TextView lblFibonacci;
    TextView lblMaravilloso;
    TextView lblPalindromo;
    TextView lblString;

    String palindromo = "oso";
    int numero = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblNumero = (TextView)findViewById(R.id.lblnumero);
        lblPrimo = (TextView)findViewById(R.id.lblPrimo);
        lblFibonacci = (TextView)findViewById(R.id.lblFibonacci);
        lblMaravilloso = (TextView)findViewById(R.id.lblMaravilloso);
        lblPalindromo = (TextView)findViewById(R.id.lblPalindromo);
        lblString = (TextView)findViewById(R.id.lblString);

        lblNumero.setText("Numero : "+ numero);
        lblPrimo.setText("Primo : " + Primo(numero));
        lblFibonacci.setText("Fibonacci : "+Fibonacci(numero));
        lblMaravilloso.setText("Maravilloso : "+Maravilloso(numero));

        lblString.setText("String : "+palindromo);
        lblPalindromo.setText("Palindormo : "+Palindromo(palindromo));
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
            if(n == 1)return true;
            else return Maravilloso(n);
        }
        else {
            n = n * 3 + 1;
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