package com.veinthrough.test.env;

import com.veinthrough.test.AbstractUnitTester;
import java.io.File;
import java.io.IOException;

/**
 * Display separator and path separator in different os,
 * and create a file named test.txt based on the directory of class.
 *
 * @author veinthrough
 */
public class Separator extends AbstractUnitTester {
    private static String FILE_NAME= "test.txt";

    @Override
    public void test() {
        System.out.printf( "Seperator:%s\n", File.separator);
        System.out.printf( "Separator char:%s\n", File.separatorChar);
        System.out.printf( "Path separator:%s\n", File.pathSeparator);
        System.out.printf( "Path separator char:%s\n", File.pathSeparatorChar);
        String fileName= "";
        String className= this.getClass().getName();
        //className.split(".") is not right
        for( String part: className.split("\\.")) {
            fileName+= File.separator+ part;
        }
        fileName+= File.separator+ FILE_NAME;
        try {
            //[WINDOWS]only when directory "\com\veinthrough\test\env\Separator" exists, it will succeed.
            //[LINUX]only when directory "/com/veinthrough/test/env/Separator" exists, it will succeed.
            new File( fileName).createNewFile();
            System.out.println( "Creating file: "+ fileName+ " succeeded!");
        } catch( IOException e) {
            System.err.println( "Creating file: "+ fileName+ " failed!");
        }
    }

    public static void main(String[] args) {
        new Separator().test();
    }
}