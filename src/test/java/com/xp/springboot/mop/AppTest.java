package com.xp.springboot.mop;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public static void main(String[] args){
        String str = "12s43sada5啊实打实的ddasd啥大大缩短佛挡杀佛艾斯德斯";
        System.out.println(str.hashCode());
        String[] array = {"abc", "123"};
        String desc = StringUtils.join(array, "-");
        System.out.println(desc);
    }
}
