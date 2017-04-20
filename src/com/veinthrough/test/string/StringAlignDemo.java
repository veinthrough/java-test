package com.veinthrough.test.string;

import com.veinthrough.test.AbstractUnitTester;
import com.veinthrough.lang.StringAlign;

/**
 *
 * @author veinthrough
 *
 */
public class StringAlignDemo extends AbstractUnitTester {

    @Override
    public void test() {
        String[] mesg = {"JavaFun", "JavaFun!" };
        for (int i=0; i<mesg.length; i++) {
            System.out.println("Input String \"" + mesg[i] + "\"");
            dump(StringAlign.Justify.LEFT, 50,
                new StringAlign(50, StringAlign.Justify.LEFT).format(mesg[i]));
            dump(StringAlign.Justify.LEFT, 100,
                new StringAlign(100, StringAlign.Justify.LEFT).format(mesg[i]));
            dump(StringAlign.Justify.CENTER, 50,
                new StringAlign(50, StringAlign.Justify.CENTER).format(mesg[i]));
            dump(StringAlign.Justify.CENTER, 100,
                new StringAlign(100, StringAlign.Justify.CENTER).format(mesg[i]));
            dump(StringAlign.Justify.RIGHT, 50,
                new StringAlign(50, StringAlign.Justify.RIGHT).format(mesg[i]));
            dump(StringAlign.Justify.RIGHT, 100,
                new StringAlign(100, StringAlign.Justify.RIGHT).format(mesg[i]));
        }
    }

    private static void dump(StringAlign.Justify format, int len, String s) {
        String lenStr= String.format("%03d", len);
        System.out.print(format.name().charAt(0) + "[" + lenStr + "]");
        System.out.print(" ==> \"");
        System.out.print(s);
        System.out.print('\"');
        System.out.println();
    }

    public static void main(String[] args) {
        new StringAlignDemo().test();
    }

}
