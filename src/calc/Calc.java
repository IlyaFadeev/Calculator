package calc;

import exception.EmptyNumricalStackException;
import exception.EmptyOperationStackException;

import java.lang.Character;import java.lang.Double;import java.lang.String;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Ilya on 02.03.2015.
 */
public class Calc {
    public double getResultOfExpression(char[] expression) throws EmptyNumricalStackException, EmptyOperationStackException
    {
        Stack<Double> numericalStack = new Stack<Double>();
        Stack<Character> charStack = new Stack<Character>();
        double result = 0;
        double bufResult = 0;
        double[] numberAndNumberOfDigits = new double[2];

        for (int i = 0; i < expression.length; i++) {
            if (!isChar(expression[i]))
            {
                numberAndNumberOfDigits = getNumberFromExpression(expression,i);
                numericalStack.push(numberAndNumberOfDigits[0]);
                i += numberAndNumberOfDigits[1]- 1;
                continue;
            }
            else {
                if (!charStack.isEmpty() && expression[i] == ')') {

                    while (charStack.peek() != '(')
                    {
                        bufResult = getResultOfElementaryOperation(numericalStack.pop(),numericalStack.pop(), charStack.pop());
                        numericalStack.push(bufResult);
                    }
                    charStack.pop();

                }
                else {
                    if (!charStack.isEmpty() && getPriorityOperation(charStack.peek()) <= getPriorityOperation(expression[i]) && charStack.peek() != '(') {
                        bufResult = getResultOfElementaryOperation(numericalStack.pop(), numericalStack.pop(), charStack.pop());
                        numericalStack.push(bufResult);
                        charStack.push(expression[i]);
                    }
                    else {
                        charStack.push(expression[i]);
                    }
                }
            }
        }
        int sizeCharStack = charStack.size();
        if (sizeCharStack > 0)
        {
            for (int i = 0; i < sizeCharStack; i++) {
                if (numericalStack.isEmpty()) throw new EmptyNumricalStackException("Number not found!");
                if (charStack.isEmpty()) throw new EmptyOperationStackException("Operation not Found!");
                    bufResult = getResultOfElementaryOperation(numericalStack.pop(), numericalStack.pop(), charStack.pop());
                    numericalStack.push(bufResult);
            }
        }

        result = numericalStack.pop();

        return result;
    }


    private boolean isChar(char currChar)
    {
        if (currChar == '*') return true;
        if (currChar == '/') return true;
        if (currChar == '+') return true;
        if (currChar == '-') return true;
        if (currChar == '(') return true;
        if (currChar == ')') return true;

        return false;
    }

    private int getPriorityOperation(char currChar)
    {
        if (currChar == '*' || currChar == '/') return 1;
        else  if (currChar == '(') return -1;
        else if (currChar == '+' || currChar == '-') return 2;
        else return 3;
    }


    public double getResultOfElementaryOperation(double a, double b, char operator)
    {
        if (operator == '*') return b * a;
        if (operator == '/') return b / a;
        if (operator == '+') return b + a;
        if (operator == '-') return b - a;
        return -1;
    }

    public double[] getNumberFromExpression(char[] expression, int startIndex)
    {
        String number = "";
        double[] numberAndNumberOFDigits = new double[2];
        int indexOfDigit = startIndex;
        while (indexOfDigit <= expression.length - 1 && !isChar(expression[indexOfDigit]))
        {
            number += expression[indexOfDigit];
            indexOfDigit++;
        }
        numberAndNumberOFDigits[0] = Double.parseDouble(number);
        numberAndNumberOFDigits[1] = (double)(indexOfDigit - startIndex);

        return numberAndNumberOFDigits;
    }
}
