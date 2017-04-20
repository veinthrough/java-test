package com.veinthrough.test.string;

import java.util.StringTokenizer;

import com.veinthrough.test.AbstractUnitTester;

/**
 *
 * @author veinthrough
 *
 */
public class StringBuilderDemo extends AbstractUnitTester {

    @Override
    public void test() {
        System.out.println( "Simple test---------------------------------------");
        simpleTest();
        System.out.println( "Split then combine test---------------------------");
        splitThenCombineTest();
    }

    private void simpleTest() {
        System.out.println( new StringBuilder().append("Hello")
                .append( ",")
                .append("world")
                .append("!")
                .toString());
    }

    /**
     * Do split and combination together is more complicated.
     * You can first split it into parts then combine them.
     * @see com.veinthrough.test.string.SplitString#useTrueToken(String, String)
     * @see com.veinthrough.test.string.SplitString#printResult(String, String[])
     */
    public void splitThenCombineTest() {
        String str= "A|||D|E||";
        String delim= "|";
        StringTokenizer st= new StringTokenizer( str, delim, true);
        boolean preIsDelim= false;
        StringBuilder strBuilder= new StringBuilder();
        while( st.hasMoreTokens()) {
            String token= st.nextToken();
            if( delim.equals( token)) {
                //(1) ...||    --> ..., null, null
                //(2) ...||... --> ..., null, ...
                if( preIsDelim) {
                    strBuilder.append( "null");
                    strBuilder.append( ", ");
                    if( !st.hasMoreElements()) {
                        strBuilder.append( "null");
                    }
                //(3) ...|    --> ..., null
                //(4) ...|... --> ..., ...
                } else {
                    if( !st.hasMoreTokens()) {
                        strBuilder.append( "null");
                    }
                }
                preIsDelim= true;
            } else {
                //(5) ...E    --> ..., E
                //(6) ...E... --> ..., E, ...
                strBuilder.append( token);
                if( st.hasMoreElements()) {
                    strBuilder.append( ", ");
                }
                preIsDelim= false;
            }
        }
        System.out.println( strBuilder.toString());
    }

    public static void main(String[] args) {
        new StringBuilderDemo().test();
    }

}
