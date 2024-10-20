# Array Filtering Utility

Этот проект предоставляет утилиту для фильтрации массивов любого типа с помощью пользовательских фильтров. Основной функционал реализован в классе `ArrayMod`, который поддерживает два метода для фильтрации:

- `filter(Object[] array, Filter filter)`: принимает массив объектов и фильтр, реализующий интерфейс `Filter`, и возвращает новый массив, к элементам которого применена функция `apply`.
- `filterWithGeneric(T[] array, Filter filter)`: обобщенный метод, принимающий массив любого типа и фильтр, и возвращающий новый массив того же типа с применением фильтра.

## Использование

### Интерфейс Filter
Для создания своего фильтра необходимо реализовать интерфейс `Filter` с методом `apply`:

```
public interface Filter {
    Object apply(Object o);
}
```
## Пример фильтра:

```
public class SquareFilter implements Filter {
    @Override
    public Object apply(Object o) {
        if (o instanceof Integer) {
            return (Integer) o * (Integer) o;
        }
        return o;
    }
}
```
## Пример использования
```
ArrayMod arrayMod = new ArrayMod();
Integer[] numbers = {1, 2, 3, 4, 5};

// Применяем фильтр для возведения чисел в квадрат
Filter squareFilter = new SquareFilter();
Integer[] result = arrayMod.filterWithGeneric(numbers, squareFilter);

System.out.println(Arrays.toString(result)); // Выведет: [1, 4, 9, 16, 25]
```
## Тестирование
Для проекта написаны тесты с использованием JUnit 5, которые проверяют корректность работы методов фильтрации.