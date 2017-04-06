package com.veinthrough.test.env;

import com.veinthrough.test.AbstractUnitTester;

/**
 * Test for presence of class named in argv[0] on classpath at runtime.
 * This uses Reflection (see chapter "Introspection, or a Class named Class")
 * to find out if the given class (named on the command line) is present
 * in the user's classpath at runtime. The class should not be "import"ed
 * because we don't want to check it at compile time, only at runtime.
 *
 * @author veinthrough
 */
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