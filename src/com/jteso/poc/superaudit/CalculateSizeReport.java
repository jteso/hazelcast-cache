package com.jteso.poc.superaudit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * User: Javi
 * Date: 4/08/11
 * Time: 2:57 PM
 */
public class CalculateSizeReport {

    public static void main(String args[]){
       System.out.println("Now =" + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS").format(new Date().getTime()));
       /*
        System.gc();
        long startMem = getMemory();
        System.out.println("Start Mem=" + startMem);
        StringBuffer sb1 = new StringBuffer();
        for (int i =0; i<4000; i++){
            sb1.append("a");
        }
        String request = sb1.toString();
         System.out.println("request=" + request);
        StringBuffer sb2 = new StringBuffer();
        for (int i =0; i<4000; i++){
            sb1.append("a");
        }
        String request2 = sb2.toString();
        sb1 = null;
        sb2 = null;

        long endMem = getMemory();
        System.out.println("End Mem=" + endMem);
        System.out.println("Memory consumed=" + (endMem - startMem));
        */

    }
    private static long getMemory(){
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
