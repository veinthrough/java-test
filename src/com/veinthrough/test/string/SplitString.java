package com.veinthrough.test.string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.veinthrough.test.AbstractUnitTester;

/**
 * The parameter is regex expression rather than common string
 * Use String.split("\\.") instead of String.split(".")
 * Use String.split("\\|") instead of String.split("|")
 * Use String.split("\\") instead of String.split("\")
 * For ¡°acount=? and uu =? or n=?¡± use String.split("and|or")
 * Use "*"/"+" will throw PatternSyntaxException, instead, use "\\*"/"\\+"
 *
 * @author veinthrough
 */
public class SplitString extends AbstractUnitTester {

    @Override
    public void test() {
        String str= "A|||D|E||";

        String[] useSplitResult= useSplit( str, "|");
        printResult( "Result of using split:", useSplitResult);
        String[] useTrueTokenResult= useTrueToken( str, "|");
        printResult( "Result of using true token:", useTrueTokenResult);
        String[] useFalseTokenResult= useFalseToken( str, "|");
        printResult( "Result of using false token:", useFalseTokenResult);
    }

    public String[] useSplit( String str, String delim) {
        if( null!= str && null!= delim) {
            return str.split( delim);
        }
        return null;
    }

    public String[] useTrueToken( String str, String delim) {
        if( null!= str && null!= delim) {
            List<String> strList= new ArrayList<>();
            // Unless you ask StringTokenizer to give you the tokens,
            // it silently discards multiple null tokens.
            StringTokenizer st= new StringTokenizer( str, delim, true);
            int i= 0;
            while( st.hasMoreTokens()) {
                String token= st.nextToken();
                if( token.equals( delim)) {
                    //(1) consecutive delimiters
                    //(2) the last is delim
                    if( strList.size()< ++i) {
                        strList.add( null);
                    }
                    if( !st.hasMoreTokens()) {
                        strList.add( null);
                    }
                } else {
                    strList.add( token);
                }
            }
            return strList.toArray( new String[0]);
        }
        return null;
    }

    private String[] useFalseToken( String str, String delim) {
        if( null!= str && null!= delim) {
            List<String> strList= new ArrayList<>();
            //StringTokenizer( str, delim, false) is the same as StringTokenizer( str, delim);
            StringTokenizer st= new StringTokenizer( str, delim, false);
            while( st.hasMoreTokens()) {
                String token= st.nextToken();
                strList.add( token);
            }
            return strList.toArray( new String[0]);
        }
        return null;
    }

    public void printResult( String header, String[] strs) {
        if( null!= header) {
            System.out.println( header);
        }
        if( null!= strs) {
            //use 2 methods to get rid of the last " ,"
            //method 1: use flag
            boolean isFirstTime= true;
            for( String str: strs) {
                if( isFirstTime) {
                    System.out.print( str);
                    isFirstTime= false;
                } else {
                    System.out.print( ", "+str);
                }
            }
            System.out.println( "");

            //method 2: use counter
            /*
            int i= 0;
            for( String str: strs) {
                System.out.print( str);
                if( ++i< strs.length) {
                    System.out.print( ", ");
                }
            }
            System.out.println( "");
            */
        }
    }

    public static void main(String[] args) {
        new SplitString().test();
    }
}