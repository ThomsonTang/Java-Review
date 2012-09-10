package com.thomsontang.learnpractice;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String str = new String("abc");
        String str1 = "abc";

        System.out.println(str == str1);

        String hello = "Hello唐贵科";
        System.out.println("length:" + hello.length());
        System.out.println("code point count:" + hello.codePointCount(0, hello.length()));
    }
}
