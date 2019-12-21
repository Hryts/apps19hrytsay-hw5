package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;

import java.util.ArrayList;
import java.util.Arrays;

public class AsIntStream implements IntStream {
    private int[] values;
    private ArrayList<Action> actions = new ArrayList<>();


    private AsIntStream(int... values) {
        this.values = values;
    }

    public static IntStream of(int... values) {
        return new AsIntStream(values);
    }

    @Override
    public Double average() {
        isEmpty();
        terminate();
        double res = 0;
        for (int val : values){
            res += val;
        }
        return res / values.length;
    }

    @Override
    public Integer max() {
        return max_min(true);
    }

    @Override
    public Integer min() {
        return max_min(false);
    }

    private int max_min(boolean predicate){
        isEmpty();
        terminate();
        int res = 0;
        for (int val : values){
            if (res > val ^ predicate){
                res = val;
            }
        }
        return res;
    }

    @Override
    public long count() {
        terminate();
        return values.length;
    }

    @Override
    public Integer sum() {
        isEmpty();
        terminate();
        int res = 0;
        for (int val : values){
            res += val;
        }
        return res;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        actions.add(new Predicate(predicate));
        return this;
    }

    @Override
    public void forEach(IntConsumer action) {
        terminate();
        for (int val : values){
            action.accept(val);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        actions.add(new UnaryOperator(mapper));
        return this;
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        actions.add(new ToIntStreamFunction(func));
        return this;
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        terminate();
        return  new BinaryOperation(op).applyAction(identity, values);
    }

    @Override
    public int[] toArray() {
    terminate();
    return Arrays.copyOf(values, values.length);
    }

    private void terminate(){
        for (Action action : actions){
            values = action.applyAction(values);
        }
    }

    private void isEmpty(){
        if (values.length == 0){
            throw new IllegalArgumentException();
        }
    }
}
