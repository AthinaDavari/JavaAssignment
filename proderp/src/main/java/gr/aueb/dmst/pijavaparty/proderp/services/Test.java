/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aueb.dmst.pijavaparty.proderp.main;

import java.util.Arrays;
import java.util.List;
import sun.awt.AWTSecurityManager;

/**
 *
 * @author Natalia
 */
public class Test {

    static void printHello() {
        System.out.println("Hello World!");
    }
    /**
     * Print "hello from the other side"
     */   
    public static void printHelloFromTheOtherSide() {
        System.out.println("Hello From The Other Side!");
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        List<StackTraceElement> list = Arrays.asList(stackTraceElements);
        for (StackTraceElement stackTraceElement : list) {
            System.out.println(stackTraceElement);
        }

    }
    


}
