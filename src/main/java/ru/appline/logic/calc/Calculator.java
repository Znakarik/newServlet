package ru.appline.logic.calc;

public class Calculator {
    Double a;
    Double b;
    String operator;
    double result;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double div(double a, double b) {
        return a / b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public Calculator getResult(double a, double b, String operator) {
        switch (operator) {
            case "+":
                setResult(sum(a, b));
                break;
            case "-":
                setResult(subtract(a, b));
                break;
            case "*":
                setResult(multiply(a, b));
                break;
            case "/":
                setResult(div(a, b));
                break;
        }
        return this;
    }
}
