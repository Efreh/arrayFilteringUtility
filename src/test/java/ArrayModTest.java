import org.efr.filters.ArrayMod;
import org.efr.interfaces.Filter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class ArrayModTest {

    // Тест для метода filter (Object[] array, Filter filter)
    @Test
    public void testFilterObjectArray() {
        ArrayMod arrayMod = new ArrayMod();
        Integer[] numbers = {1, 2, 3, 4, 5};
        Filter filter = o -> (Integer) o * 2;

        Object[] result = arrayMod.filter(numbers, filter);

        assertArrayEquals(new Object[]{2, 4, 6, 8, 10}, result);
    }

    // Тест для метода filterWithGeneric с корректным результатом
    @Test
    public void testFilterWithGenericIntegers() {
        ArrayMod arrayMod = new ArrayMod();
        Integer[] numbers = {1, 2, 3, 4, 5};
        Filter filter = o -> (Integer) o * 2;

        Object[] result = arrayMod.filterWithGeneric(numbers, filter);

        // Приведение к массиву Integer[]
        Integer[] typedResult = Arrays.copyOf(result, result.length, Integer[].class);

        assertArrayEquals(new Integer[]{2, 4, 6, 8, 10}, typedResult);
    }

    // Тест для метода filterWithGeneric с типом String
    @Test
    public void testFilterWithGenericStrings() {
        ArrayMod arrayMod = new ArrayMod();
        String[] strings = {"apple", "banana", "cherry"};
        Filter filter = o -> ((String) o).toUpperCase();

        Object[] result = arrayMod.filterWithGeneric(strings, filter);

        // Приведение к массиву String[]
        String[] typedResult = Arrays.copyOf(result, result.length, String[].class);

        assertArrayEquals(new String[]{"APPLE", "BANANA", "CHERRY"}, typedResult);
    }

    // Тест для проверки пустого массива
    @Test
    public void testFilterWithEmptyArray() {
        ArrayMod arrayMod = new ArrayMod();
        Integer[] emptyArray = {};
        Filter filter = o -> (Integer) o * 2;

        Object[] result = arrayMod.filterWithGeneric(emptyArray, filter);

        assertArrayEquals(new Object[]{}, result);
    }

    // Тест для метода filter (Object[] array, Filter filter) с пустым массивом
    @Test
    public void testFilterWithEmptyObjectArray() {
        ArrayMod arrayMod = new ArrayMod();
        Object[] emptyArray = {};
        Filter filter = o -> o;

        Object[] result = arrayMod.filter(emptyArray, filter);

        assertArrayEquals(new Object[]{}, result);
    }

    // Тест для метода filter (Object[] array, Filter filter) с null
    @Test
    public void testFilterWithNullArray() {
        ArrayMod arrayMod = new ArrayMod();
        Object[] nullArray = {null, null, null};
        Filter filter = o -> o == null ? "nullValue" : o;

        Object[] result = arrayMod.filter(nullArray, filter);

        assertArrayEquals(new Object[]{"nullValue", "nullValue", "nullValue"}, result);
    }

    // Тест для метода filterWithGeneric с массивом null
    @Test
    public void testFilterWithGenericNullArray() {
        ArrayMod arrayMod = new ArrayMod();
        Object[] nullArray = {null, null, null};
        Filter filter = o -> o == null ? "nullValue" : o;

        Object[] result = arrayMod.filterWithGeneric(nullArray, filter);

        // Приведение к массиву Object[]
        Object[] typedResult = Arrays.copyOf(result, result.length, Object[].class);

        assertArrayEquals(new Object[]{"nullValue", "nullValue", "nullValue"}, typedResult);
    }
}
