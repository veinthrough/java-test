package com.veinthrough.test.env;

import java.util.Properties;

import com.veinthrough.test.UnitTester;

/**
 * List one or more item(s) from System Properties
 * <p>
 * For environment, you can use {java -D"KEY=VALUE" com.veinthrough.test.env.SysProp}
 * <p>
 * or
 * <p>
 * Use argument: {java com.veinthrough.test.env.SysProp KEY=VALUE}
 *
 * @author veinthrough
 */
public class SysProp implements UnitTester {
    private String[] args= new String[0];
    private Properties properties= System.getProperties();

    @Override
    public UnitTester setArgs( String[] args) {
        this.args= args;
        return this;
    }

    @Override
    public void test() {
        if( 0== this.args.length) {
            properties.list( System.out);
        } else {
            String s= this.args[0];
            if( s.contains( "=")) {
                int index= s.indexOf("=");
                String key= s.substring( 0, index);
                String value= s.substring( index+1);
                properties.setProperty(key, value);
                properties.list( System.out);
                properties.remove(key);
            } else {
                //use System.getProperty()
                System.out.println(s+ " = " + System.getProperty( s));
            }
        }
    }

    public static void main(String[] args) {
        SysProp tester= new SysProp();
        tester.setArgs( args).test();
    }
}
