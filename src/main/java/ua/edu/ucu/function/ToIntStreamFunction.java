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
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int val : values) {
            for (int resVal : applyAsIntStream(val).toArray()) {
                tmp.add(resVal);
            }
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); ++i) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    @Override
    public IntStream applyAsIntStream(int value) {
        return function.applyAsIntStream(value);
    }
}
