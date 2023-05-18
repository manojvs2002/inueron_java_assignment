package javaAssignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamApiExample {
    public static void main(String[] args) {
        List<String> names=new ArrayList<String>();
        names.add("karthik");
        names.add("saathvik");
        names.add("manoj");
        names.add("varshini");
        names.add("jayanth");
        
        
        List<String> filter = names.stream().filter(name->name.startsWith("a")).toList();
        
        
        System.out.println("FIltered name starting with A");
        
        filter.forEach(System.out::println);
        
        List<String> sorted = names.stream().sorted().toList();
        
        
        System.out.println("sorted names are  ");
        sorted.forEach(System.out::println);
    }
}

