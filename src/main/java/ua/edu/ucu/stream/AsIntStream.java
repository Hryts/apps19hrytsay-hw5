package ua.edu.ucu.stream;

import com.sun.java.util.jar.pack.ConstantPool;
import ua.edu.ucu.function.*;

import java.util.ArrayList;
import java.util.Arrays;

public class AsIntStream implements IntStream {
    private int[] values;
    private ArrayList<Action> actions;


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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] toArray() {
    terminate();
    return Arrays.copyOf(values, values.length);
    }

    private void terminate(){
        for (Action action : actions){
            action.applyAction(values);
        }
    }

    private void isEmpty(){
        if (values.length == 0){
            throw new IllegalArgumentException();
        }
    }
}
