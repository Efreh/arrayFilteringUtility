package org.efr.filters;

import org.efr.interfaces.Filter;

import java.util.Arrays;

public class ArrayMod {

    public Object[] filter(Object[] array, Filter filter) {
        return Arrays.stream(array)
                .map(filter::apply)
                .toArray();
    }


    public <T> Object[] filterWithGeneric(T[] array, Filter filter) {
        return Arrays.stream(array)
                .map(filter::apply)
                .toArray();
    }
}
