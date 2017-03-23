package com.veinthrough.test;

import java.util.ArrayList;
import java.util.List;

import com.veinthrough.test.env.GetEnv;

/**
 * @author veinthrough
 *
 */
public class Tester {

    List<UnitTester> unitTesters= new ArrayList<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        Tester tester= new Tester();

        tester.add( new GetEnv());

        tester.test();
    }

    public Tester add( UnitTester unitTester) {
        this.unitTesters.add(unitTester);
        return this;
    }
    public void test() {
        if(!this.unitTesters.isEmpty()) {
            for( UnitTester unitTester: unitTesters) {
                System.out.println(unitTester.getClass().getSimpleName()+"----------");
                unitTester.test();
                System.out.println("-----------------------------------------------------------\n");
            }
        }
    }
}