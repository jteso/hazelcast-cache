package com.jteso.poc.superaudit;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.Transaction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * User: Javi
 * Date: 4/08/11
 * Time: 12:39 PM
 */
public class Processor {
    private volatile boolean running = true;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public Processor(int nThreads) {
       final ExecutorService executors = Executors.newFixedThreadPool(nThreads);
        final IMap<Long,AuditReport> mapReport = Hazelcast.getMap(Constants.AUDIT__REPORT__MAP);
        //final IMap<Long,Long> mapInfo = Hazelcast.getMap(Constants.AUDIT__PROCESSED__MAP);
        final IQueue<Long> queue = Hazelcast.getQueue(Constants.AUDIT__REPORT__QUEUE);
        for (int i=0; i < nThreads; i++){
            executors.execute(new Runnable() {
                public void run() {
                    while (running){
                        try{
                            Long reportId = queue.take();
                            AuditReport report = mapReport.get(reportId);
                            process(report);
                            mapReport.removeAsync(reportId);


                        }catch (Exception e){
                             // Oh Lord, this is just a POC, forgive me for catching Exception classes
                             e.printStackTrace();
                        }

                    }
                }
            });
        }
        logger.info("Processor started with " + nThreads + " threads.");
    }

    private void process(AuditReport report){
         logger.info("Report Id = " + report.getId() + "has been processed["+ report.toString() +"].");
    }

    public static void main(String args[]){
        Processor processor = new Processor(Integer.parseInt(args[0]));
    }
}
