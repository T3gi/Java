import java.util.*;

/**
 * Параметризована колекція (список), що зберігає об'єкти типу Car та його підкласів.
 * Реалізує інтерфейс {@link List} на основі масиву з динамічним розширенням.
 */
public class CarPark<E extends Car> implements List<E> {
    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;

    private Object[] elementData;
    private int size;

    /**
     * Конструктор за замовчуванням. Створює порожній автопарк.
     */
    public CarPark() {
        this.elementData = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Конструктор, що створює автопарк з одним початковим елементом.
     *
     * @param element елемент для додавання.
     */
    public CarPark(E element) {
        this();
        add(element);
    }

    /**
     * Конструктор, що створює автопарк на основі іншої колекції.
     *
     * @param c колекція, елементи якої будуть додані.
     */
    public CarPark(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    /**
     * Обчислює загальну вартість усіх автомобілів у парку.
     *
     * @return сума цін усіх автомобілів.
     */
    public double calculateTotalValue() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += ((Car) elementData[i]).getPrice();
        }
        return total;
    }

    /**
     * Знаходить автомобілі, швидкість яких знаходиться в заданому діапазоні.
     *
     * @param minSpeed мінімальна швидкість (включно).
     * @param maxSpeed максимальна швидкість (включно).
     * @return список знайдених автомобілів.
     */
    public List<E> findCarsBySpeedRange(int minSpeed, int maxSpeed) {
        CarPark<E> foundCars = new CarPark<>();
        for (int i = 0; i < size; i++) {
            E car = (E) elementData[i];
            if (car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed) {
                foundCars.add(car);
            }
        }
        return foundCars;
    }

    /**
     * Збільшує ємність масиву, якщо це необхідно для розміщення нових елементів.
     *
     * @param minCapacity необхідна мінімальна ємність.
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            int oldCapacity = elementData.length;
            int newCapacity = Math.max((int) (oldCapacity * GROWTH_FACTOR), oldCapacity + 1);
            
            while (newCapacity < minCapacity) {
                newCapacity = Math.max((int) (newCapacity * GROWTH_FACTOR), newCapacity + 1);
            }
            
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size)
            return (E[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);

        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew, numMoved);

        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            while (contains(e)) {
                remove(e);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elementData[i])) {
                remove(i);
                i--; 
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            elementData[i] = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null; 
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null) return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i])) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (elementData[i] == null) return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(elementData[i])) return i;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        rangeCheckForAdd(index);
        return new ListItr(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size);
        CarPark<E> sub = new CarPark<>();
        for(int i = fromIndex; i < toIndex; i++) {
            sub.add(get(i));
        }
        return sub;
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
    }

    private class Itr implements Iterator<E> {
        int cursor;       
        int lastRet = -1; 

        public boolean hasNext() {
            return cursor != size;
        }

        public E next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = CarPark.this.elementData;
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            CarPark.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }
    }

    private class ListItr extends Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            cursor = index;
        }
        public boolean hasPrevious() { return cursor != 0; }
        public int nextIndex() { return cursor; }
        public int previousIndex() { return cursor - 1; }
        public E previous() {
            int i = cursor - 1;
            if (i < 0) throw new NoSuchElementException();
            Object[] elementData = CarPark.this.elementData;
            cursor = i;
            return (E) elementData[lastRet = i];
        }
        public void set(E e) {
            if (lastRet < 0) throw new IllegalStateException();
            CarPark.this.set(lastRet, e);
        }
        public void add(E e) {
            CarPark.this.add(cursor++, e);
            lastRet = -1;
        }
    }
}