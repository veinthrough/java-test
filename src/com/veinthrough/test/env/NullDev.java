package com.veinthrough.test.env;

import java.io.File;
import com.veinthrough.test.AbstractUnitTester;

/**
 * Get null dev of different OS.
 * <p>
 * Linux: /dev/null
 * <p>
 * Windows: NUL:
 * <p>
 * Others: jnk
 *
 * @author veinthrough
 */
public class NullDev extends AbstractUnitTester {
    final static String UNIX_NULL_DEV= "/dev/null";
    final static String WINDOWS_NULL_DEV= "NUL:";
    final static String FAKE_NULL_DEV= "jnk";

    @Override
    public void test() {
        System.out.println("Null dev: "+ getNullDev());
    }

    private static String getNullDev() {
        String osName= System.getProperty("os.name");
        System.out.println("OS name: "+ osName);
        if( new File(UNIX_NULL_DEV).exists()) {
            return UNIX_NULL_DEV;
        } else if( osName.startsWith("Windows")) {
            return WINDOWS_NULL_DEV;
        }
        return FAKE_NULL_DEV;
    }

    public static void main(String[] args) {
        new NullDev().test();
    }
}