package com.example.calculadora;

import java.util.Stack;

public class eval_expr {

    public static String calc(String exp)
    {
        //Entrada (Expresión en Postfija)
        String expr = exp; // equivale a 2*(23+6)-1
        String[] post = expr.split(" ");

        //Declaración de las pilas
        Stack < String > E = new Stack <  > (); //Pila entrada
        Stack < String > P = new Stack <  > (); //Pila de operandos

        //Añadir post (array) a la Pila de entrada (E)
        for (int i = post.length - 1; i >= 0; i--) {
            E.push(post[i]);
        }

        //Algoritmo de Evaluación Postfija
        String operadores = "+-*/%";
        while (!E.isEmpty()) {
            if (operadores.contains("" + E.peek())) {
                P.push(evaluar(E.pop(), P.pop(), P.pop()) + "");
            }else {
                P.push(E.pop());
            }
        }

        //Mostrar resultados:
//    System.out.println("Expresion: " + expr);
//    System.out.println("Resultado: " + P.peek());
        return P.peek();
    }

    private static double evaluar(String op, String n2, String n1) {
        double num1 = Double.parseDouble(n1);
        double num2 = Double.parseDouble(n2);
        if (op.equals("+")) return (num1 + num2);
        if (op.equals("-")) return (num1 - num2);
        if (op.equals("*")) return (num1 * num2);
        if (op.equals("/")) return (num1 / num2);
        if (op.equals("%")) return (num1 % num2);
        return 0;
    }

}
