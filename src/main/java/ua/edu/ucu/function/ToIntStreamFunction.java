package ua.edu.ucu.function;

import ua.edu.ucu.stream.IntStream;

import java.util.ArrayList;

public class ToIntStreamFunction implements IntToIntStreamFunction, Action {
    private IntToIntStreamFunction function;

    public ToIntStreamFunction(IntToIntStreamFunction function) {
        this.function = function;
    }

    @Override
    public int[] applyAction(int[] values) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int val : values){
            for (int resVal: applyAsIntStream(val).toArray()){
                res.add(resVal);
            }
        }
        values = new int[res.size()];
        for (int i = 0; i < res.size(); ++i){
            values[i] = res.get(i);
        }
        return values;
    }

    @Override
    public IntStream applyAsIntStream(int value) {
        return function.applyAsIntStream(value);
    }
}
