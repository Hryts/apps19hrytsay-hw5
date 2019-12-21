package ua.edu.ucu.function;

public class UnaryOperator implements IntUnaryOperator, Action {
    private IntUnaryOperator operator;

    public UnaryOperator(IntUnaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public int[] applyAction(int[] values) {
        for (int i = 0; i < values.length; ++i){
            values[i] = apply(values[i]);
        }
        return values;
    }

    @Override
    public int apply(int operand) {
        return operator.apply(operand);
    }
}
