package org.unittest;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

final class ListUtil {
    /**
     * Create and return a LinkedList with the following Strings: "This", "will", "be", "tested", "with", "JUnit".
     */
    static List<String> createLinkedList() {
        return new LinkedList<>(List.of("This", "will", "be", "tested", "with", "JUnit"));
    }

    /**
     * Get the element from the given List, that is in it most frequently.
     *
     * @throws NoSuchElementException if the given List is empty.
     */
    static Integer getMostFrequentElement(List<Integer> integerList) {
        Map<Integer, Long> elementToFrequency = integerList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return elementToFrequency
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Provided List was empty!")).getKey();
    }
}