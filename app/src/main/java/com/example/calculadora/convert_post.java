package com.example.calculadora;

import java.util.Scanner;
import java.util.Stack;

public class convert_post {

    public String convert(String exp)
    {
        String expr = depurar(exp);
        String[] arrayInfix = expr.split(" ");
        //Declaracion de las pilas
        Stack < String > E = new Stack <  > (); //Pila entrada
        Stack < String > P = new Stack <  > (); //Pila temporal para operadores
        Stack < String > S = new Stack <  > (); //Pila salida

        //Añadir la array a la Pila de entrada (E)
        for (int i = arrayInfix.length - 1; i >= 0; i--)
        {
            E.push(arrayInfix[i]);
        }

        try
        {
            //Algoritmo Infijo a Postfijo
            while (!E.isEmpty())
            {
                switch (pref(E.peek()))
                {
                    case 1:
                        P.push(E.pop());
                        break;
                    case 3:
                    case 4:
                        while(pref(P.peek()) >= pref(E.peek()))
                        {
                            S.push(P.pop());
                        }
                        P.push(E.pop());
                        break;
                    case 2:
                        while(!P.peek().equals("("))
                        {
                            S.push(P.pop());
                        }
                        P.pop();
                        E.pop();
                        break;
                    default:
                        S.push(E.pop());
                }
            }

            //Eliminacion de `impurezas´ en la expresiones algebraicas
            String infix = expr.replace(" ", "");
            String postfix = S.toString().replaceAll("[\\]\\[,]", "");

            //Mostrar resultados:
            return("" + eval_expr.calc(postfix));

        }catch(Exception ex) {
            return  "";
        }
    }
    private static String depurar(String s)
    {
        System.out.println("" + s);
        s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
        System.out.println("" + s);
        s = "(" + s + ")";
        String simbols = "+-*/()";
        String str = "";

        //Deja espacios entre operadores
        for (int i = 0; i < s.length(); i++)
        {
            if (simbols.contains("" + s.charAt(i)))
            {
                str += " " + s.charAt(i) + " ";
            }else
            {
                str += s.charAt(i);
            }
        }
        return str.replaceAll("\\s+", " ").trim();
    }

    //Jerarquia de los operadores
    private static int pref(String op)
    {
        int prf = 99;
        if (op.equals("^")) prf = 5;
        if (op.equals("*") || op.equals("/")) prf = 4;
        if (op.equals("+") || op.equals("-")) prf = 3;
        if (op.equals(")")) prf = 2;
        if (op.equals("(")) prf = 1;
        return prf;
    }

}
