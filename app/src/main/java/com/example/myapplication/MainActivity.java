package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    ImageButton b[]=new ImageButton[18];
    static  String s="";
    static char a[]={'a','b','/','*','1','2','3','4','5','6','7','8','9','e','0','.','+','-'};
    static EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b[0]=findViewById(R.id.tAc);
        b[1]=findViewById(R.id.tb);
        b[2]=findViewById(R.id.td);
        b[3]=findViewById(R.id.tm);
        b[4]=findViewById(R.id.t1);
        b[5]=findViewById(R.id.t2);
        b[6]=findViewById(R.id.t3);
        b[7]=findViewById(R.id.t4);
        b[8]=findViewById(R.id.t5);
        b[9]=findViewById(R.id.t6);
        b[10]=findViewById(R.id.t7);
        b[11]=findViewById(R.id.t8);
        b[12]=findViewById(R.id.t9);
        b[13]=findViewById(R.id.teq);
        b[14]=findViewById(R.id.t0);
        b[15]=findViewById(R.id.t00);
        b[16]=findViewById(R.id.tp);
        b[17]=findViewById(R.id.ts);
        ed1=findViewById(R.id.tf1);
    }
    public void add(View view)
    {
        for(int i=0;i<18;i++)
        {
            if(b[i].getId()==view.getId())
            {
                s=s+a[i];
                ed1.setText(s);
            }
        }
    }
    public void remove(View view)
    {
        s=s.substring(0,s.length()-2);
        ed1.setText(s);
    }
    public void removeall(View view)
    {
        s="";
        ed1.setText(s);
    }
    public void result(View view)
    {
         ed1.setText(calculateExpression(s)+"");
    }
        private static String calculateExpression(String input) {
            StringTokenizer str=new StringTokenizer(input,"+ / * -");
            double operand1 = Double.parseDouble(str.nextToken());
            double operand2 = Double.parseDouble(str.nextToken());
            char operator = input.replaceAll("[^+\\-*/]", "").charAt(0);

            switch (operator) {
                case '+':
                    return (operand1 + operand2)+"";
                case '-':
                    return (operand1 - operand2)+"";
                case '*':
                    return (operand1 * operand2)+"";
                case '/':
                    if (operand2 != 0) {
                        return (operand1 / operand2)+"";
                    } else {
                        return "Cannot divide by zero.";
                        //System.exit(1);
                    }
            }

            System.out.println("Invalid expression");
            //System.exit(1);
            return ""; // Unreachable code, added to satisfy compiler
        }

}