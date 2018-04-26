public class Calculator implements BasicOperations, java.io.Serializable {
    private double results, operandOne, operandTwo;
    private String operation;

    public Calculator () {
        results = 0;
        operandOne = 0;
        operandTwo = 0;
        operation = "";
    }

    public double getResults () {
        System.out.println (results);
        return results;
    }

    public void setOperation (String operator) {
        System.out.println ("Operator entered: " + operator);
        if (operator != "+" && operator != "-") {
            System.out.println ("Invalid operator, please use either + or -");
        }
        else {
            operation = operator;
        }
    }

    public void setOperandOne (double operand) {
        operandOne = operand;
    }

    public void setOperandTwo (double operand) {
        operandTwo = operand;
    }

    public void performOperation () {
        if (operation == "+") {
            results = operandOne + operandTwo;
        }
        else {
            results = operandOne - operandTwo;
        }
    }
}