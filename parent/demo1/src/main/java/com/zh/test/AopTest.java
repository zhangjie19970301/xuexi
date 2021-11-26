package com.zh.test;

import com.zh.annotation.AopAnnotation;

public class AopTest {
    public static void main(String[] args) {
        testThread();
    }
    @AopAnnotation
    public static void   testThread(){

    }
}
