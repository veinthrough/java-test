/**
 *
 */
package com.veinthrough.test.env;

import java.util.Map;
import com.veinthrough.test.AbstractUnitTester;

/**
 * Demo of System.getenv().
 * <p>
 * This very basic OS-dependent method worked in 1.1 (and 1.2?), was
 * deprecated in 1.3, throws an exception in 1.4, and WORKS AGAIN in 1.5.
 * <p>
 * case-insensitive in Windows.
 * <p>
 * case-sensitive in Linux.
 *
 * @author veinthrough
 */
public class GetEnv extends AbstractUnitTester{

    public static void main(String[] args) {
        new GetEnv().test();
    }

    /**
     * test implementation for this tester
     *
     * @see com.veinthrough.test.UnitTester#test()
     */
    @Override
    public void test() {
        //all envs
        Map<String,String> envsMap = System.getenv();
        if( null!= envsMap && !envsMap.isEmpty()) {
            for( String key: envsMap.keySet()) {
                System.out.println(key + " = \"" + System.getenv(key) + "\"");
            }
        }

        //PATH
        System.out.println( "Path = \"" + System.getenv("Path") + "\"");
        System.out.println( "PATH = \"" + System.getenv("PATH") + "\"");
    }
}
