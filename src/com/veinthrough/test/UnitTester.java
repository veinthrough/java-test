package com.veinthrough.test;

/**
 * All unit testers will implement this interface.
 *
 * @author veinthrough
 */
public interface UnitTester {
    UnitTester setArgs( String[] args);

    /**
     * all unit testers should implement this interface.
     */
    void test();
}
