package com.jteso.poc.hazelcast;

/**
 * User: Javi
 * Date: 4/08/11
 * Time: 4:05 PM
 */
public class Node {

    public static void main(String args[]){
        int nThreadsForCollector = 5;
        int nThreadsForProcessor = 5;

        if (args.length >1){
            nThreadsForCollector = Integer.parseInt(args[0]);
            nThreadsForProcessor = Integer.parseInt(args[1]);
        }
        new Producer(nThreadsForCollector);
        new Consumer(nThreadsForProcessor);
    }
}
