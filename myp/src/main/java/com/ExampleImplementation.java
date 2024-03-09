package com;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ExampleImplementation implements Example {  // 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

    @Override
    public <T extends Comparable<? super T>> T max(Collection<? extends T> col) { //sts
        if (col.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty");
        }

        Iterator<? extends T> iterator = col.iterator();
        T maxElement = iterator.next();

        while (iterator.hasNext()) {
            T currentElement = iterator.next();
            if (currentElement.compareTo(maxElement) > 0) {
                maxElement = currentElement;
            }
        }

        return maxElement; // 여기머즈한다
    }

    public static void main(String[] args) {
        // Example usage
        ExampleImplementation exampleImplementation = new ExampleImplementation();

        // Creating a collection of integers
        // You can replace Integer with any type that implements Comparable
        // and use ExampleImplementation with that type
        Collection<Integer> integerCollection = List.of(3, 7, 1, 9, 4);

        // Finding the maximum element in the collection
        Integer maxInteger = exampleImplementation.max(integerCollection);

        // Displaying the result
        System.out.println("Max Integer: " + maxInteger);
    }
    
    // 머즈 헌당.
    // mst 에 머지 한다.
    // mst에 ...
    // mst에만 머즈한다.2222222
    // 웹에서 고쳣당 
    // test11111
    //2222222
}
