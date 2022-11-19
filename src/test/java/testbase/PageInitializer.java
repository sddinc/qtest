package testbase;

import pages.testPage;

public class PageInitializer extends BaseClass {


    public static testPage testPage;

    public static void initialize(){

        testPage =new testPage();
    }
}