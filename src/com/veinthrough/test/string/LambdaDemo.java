package com.veinthrough.test.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.veinthrough.test.AbstractUnitTester;

public class LambdaDemo extends AbstractUnitTester {

    @Override
    public void test() {
        List<String> strList= new ArrayList<>();
        strList.add("abc");
        strList.add("def");

        //case 1
        strList.stream().forEach( str -> System.out.println( str.length()>3 ? "a" : "b") );
        //The method forEach(Consumer<? super String>) in the type Stream<String> is not applicable for the arguments ((<no type> str) -> {})
        //strList.stream().forEach( str -> str.length()>3 ? System.out.println("a") : System.out.println("b") );

        //case 2
        strList = strList.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
        //Stream<String> map(Function<? super String, ? extends String> mapper)
        //Collector<Object, ?, ArrayList<Object>> toCollection(Supplier<ArrayList<Object>> collectionFactory)
        strList = strList.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        new LambdaDemo().test();
    }

}
