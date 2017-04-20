package com.veinthrough.test.env;

import com.veinthrough.test.AbstractUnitTester;
import com.veinthrough.lang.GetOpt;
import com.veinthrough.lang.GetOptDesc;
import java.util.*;

/** Demonstrate the modern way of using GetOpt. This allows a subset of
 * <pre>UNIX sort options: sort -n -o outfile infile1 infile2</pre>
 * which means: sort numerically (-n), writing to file "outfile" (-o
 * outfile), sort from infile1 and infile2.
 * <p>
 * tests:
 * <p>
 * java environ.GetOptDemo -M
 * <p>
 * java environ.GetOptDemo -n a b c
 * <p>
 * java environ.GetOptDemo -numeric a b c
 * <p>
 * java environ.GetOptDemo -numeric -output-file /tmp/foo a b c
 * <p>
 *
 * @author veinthrough
 */
public class GetOptDemo extends AbstractUnitTester {

    @Override
    public void test() {
        boolean numeric_option = false;
        boolean errs = false;
        String outputFileName = null;

        GetOptDesc[] options = {
                new GetOptDesc('n', "numeric", false),
                new GetOptDesc('o', "output-file", true),
        };
        GetOpt parser = new GetOpt(options);
        Map<String,String> optionsFound = parser.parseArguments( this.args);
        for (String key : optionsFound.keySet()) {
                char c = key.charAt(0);
                switch (c) {
                        case 'n':
                                numeric_option = true;
                                break;
                        case 'o':
                                outputFileName = (String)optionsFound.get(key);
                                break;
                        case '?':
                                errs = true;
                                break;
                        default:
                                throw new IllegalStateException(
                                "Unexpected option character: " + c);
                }
        }
        if (errs) {
                System.err.println("Usage: GetOptDemo [-n][-o file][file...]");
        }
        System.out.print("Options: ");
        System.out.print("Numeric: " + numeric_option + ' ');
        System.out.print("Output: " + outputFileName + "; ");
        System.out.print("Input files: ");
        for (String fileName : parser.getFilenameList()) {
                System.out.print(fileName);
                System.out.print(' ');
        }
        System.out.println();

    }

    public static void main(String[] args) {
        GetOptDemo tester= new GetOptDemo();
        tester.setArgs( args).test();
    }

}