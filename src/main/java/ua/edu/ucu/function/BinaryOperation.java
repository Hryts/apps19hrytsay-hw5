package ua.edu.ucu.function;

public class BinaryOperation implements IntBinaryOperator {
    private IntBinaryOperator operator;

    public BinaryOperation(IntBinaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public int apply(int left, int right) {
        return operator.apply(left, right);
    }

    public int applyAction(int identity, int[] values) {
        for (int val : values) {
            identity = apply(identity, val);
        }
        return identity;
    }
}
