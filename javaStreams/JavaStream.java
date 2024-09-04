package javaStreams;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {
    
    public static void main(String[] args) {
       System.out.println(

           Stream.of(1.3, 4.5, 6.7)
           .reduce(0.0, (a, b) -> a+b)
           
       ); 

    }
    
}
