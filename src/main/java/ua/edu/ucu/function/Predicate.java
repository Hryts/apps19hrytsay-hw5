package ua.edu.ucu.function;

import java.util.Arrays;

public class Predicate implements IntPredicate, Action {
    private IntPredicate predicate;

    public Predicate(IntPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public void applyAction(int[] values) {
        int counter = 0;
        for (int i = 0; i < values.length; ++i){
            if (test(values[i])){
                values[counter++] = values[i];
            }
        }
        values = Arrays.copyOf(values, counter);
    }

    @Override
    public boolean test(int value) {
        return this.predicate.test(value);
    }
}
