package ru.employee_account_system.utils;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class ListUtils {

    public static <E> void printList(List<E> list, PrintStream out){
        for(E element: list){
            out.print(element + " ");
        }
    }
    public static class CustomPrint extends PrintStream {
        StringBuilder text = new StringBuilder();

        public CustomPrint(OutputStream out) {
            super(out);
        }
    }
    public static<K,V> void printMap(Map<K,V> map, PrintStream out){
        for(Map.Entry<K, V> element: map.entrySet()){
            K key = element.getKey();
            V value = element.getValue();
            out.println(value);
        }
    }
}
