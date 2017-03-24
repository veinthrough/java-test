package com.veinthrough.test;

import java.util.ArrayList;
import java.util.List;

import com.veinthrough.test.env.GetEnv;

/**
 * @author veinthrough
 */
public class Tester {

    /**
     * a list of all testers to be executed.
     */
    List<UnitTester> unitTesters= new ArrayList<>();

    public static void main(String[] args) {
        Tester tester= new Tester();

        tester.add( new GetEnv());

        tester.test();
    }

    /**
     * Add a tester to the list which will be executed.
     *
     * @param unitTester tester to add
     * @return           always this to provide a sequence calling
     */
    public Tester add( UnitTester unitTester) {
        this.unitTesters.add(unitTester);
        return this;
    }

    /**
     * Execute all testers added to the list.
     *
     * Use {@link #add(UnitTester)} to add a tester to the list
     */
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