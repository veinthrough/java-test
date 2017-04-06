package com.veinthrough.test.env;

import com.veinthrough.test.AbstractUnitTester;

public class CheckForClass extends AbstractUnitTester {
    @Override
    public void test() {
        if( 1!= this.args.length) {
            System.err.println("Usage: TestForClass className");
            System.exit( 2);
        } else {
            String className= this.args[0];
            try {
                Class.forName( className);
                System.out.println("Class: "+ className+ " is existed!");
                System.exit( 0);
            } catch( ClassNotFoundException e) {
                System.err.println("Class: "+ className+ " isn't existed!");
                System.exit( 1);
            }
        }
    }

    public static void main(String[] args) {
        CheckForClass tester= new CheckForClass();
        tester.setArgs( args).test();
    }
}