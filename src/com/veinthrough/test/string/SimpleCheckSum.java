package com.veinthrough.test.string;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.veinthrough.test.AbstractUnitTester;

/**
 * <pre>print a checksum of a file with new line character considered:</pre>
 * <p>
 * - read a file by line via readLine(), which will not read new line characters
 * <p>
 * - read a file by char via read(), which will read new line characters
 *
 * @author veinthrough
 *
 */
public class SimpleCheckSum extends AbstractUnitTester {

    @Override
    public void test() {
        long sumByLine= 0L;
        if( 0== args.length) {
            sumByLine = checkSumByLine( new BufferedReader(
                    new InputStreamReader( System.in)));
        } else for ( String arg: this.args) {
            try {
                sumByLine+= checkSumByLine( new BufferedReader( new FileReader( arg)));
            } catch ( FileNotFoundException e) {
                throw new RuntimeException( "File not found: "+ arg, e);
            }
        }
        System.out.println( "Check sum by line:"+ String.valueOf( sumByLine));

        /*
        long sumByChar= 0L;
        if( 0== args.length) {
            sumByChar = checkSumByChar( new BufferedReader(
                    new InputStreamReader( System.in)));
        } else for ( String arg: this.args) {
            try {
                sumByChar+= checkSumByChar( new BufferedReader( new FileReader( arg)));
            } catch ( FileNotFoundException e) {
                throw new RuntimeException( "File not found: "+ arg, e);
            }
        }
        System.out.println( "Check sum by char:"+ String.valueOf( sumByChar));
        */
    }

    private long checkSumByLine( BufferedReader is) {
        long sum= 0L;
        try {
            String inputLine;
            //readLine() will not read new line characters.
            while( null!= ( inputLine= is.readLine())) {
                int i;
                for( i=0; i< inputLine.length(); i++) {
                    sum+= inputLine.charAt( i);
                }
                //add check sum of new line
                sum+= checkSumOfNewLine();
            }
        } catch( IOException e) {
            throw new RuntimeException( "IOException: "+ e);
        }
        return sum;
    }
    //(1) final will get rid of override
    //(2) final can also suggest inline
    //private will automatic be final
    private long checkSumOfNewLine() {
        long sum= 0L;
        String newLine= System.getProperty("line.separator");
        for( char ch: newLine.toCharArray()) {
            sum+= ch;
        }
        return sum;
    }

    private long checkSumByChar( BufferedReader is) {
        long sum= 0L;
        try {
            int inputChar;
            //The character read, as an integer in the range 0 to 65535 (0x00-0xffff),
            //or -1 if the end of the stream has been reached
            while( -1!= ( inputChar= is.read())) {
                sum+= inputChar;
            }
        } catch( IOException e) {
            throw new RuntimeException( "IOException: "+ e);
        }
        return sum;
    }

    public static void main(String[] args) {
        SimpleCheckSum tester= new SimpleCheckSum();
        tester.setArgs( args).test();
    }

}
