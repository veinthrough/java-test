package com.veinthrough.test.string;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.veinthrough.test.AbstractUnitTester;

public class DateFormatDemo extends AbstractUnitTester {

    @Override
    public void test() {
        SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS z" );
        //format.setTimeZone( TimeZone.getDefault());
        //format.setTimeZone( TimeZone.getTimeZone("Asia/Chongqing"));
        format.setTimeZone( TimeZone.getTimeZone("Asia/Shanghai"));
        String time= format.format( new Date(System.currentTimeMillis()));
        System.out.println("Current time is :"+ time);
    }

    public static void main(String[] args) {
        new DateFormatDemo().test();
    }

}
