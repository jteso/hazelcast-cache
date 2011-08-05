package com.jteso.poc.hazelcast;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * User: Javi
 * Date: 4/08/11
 * Time: 11:23 AM
 */
public class AuditReport implements Serializable{
    private Long id;
    private Long timestamp;
    private Long transactId;
    private Long responseTimeMs;
    private String serviceName;
    private boolean succeededFlag;


    private static final Random random = new Random();

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransactId() {
        return transactId;
    }

    public void setTransactId(Long transactId) {
        this.transactId = transactId;
    }

    public Long getResponseTimeMs() {
        return responseTimeMs;
    }

    public void setResponseTimeMs(Long responseTimeMs) {
        this.responseTimeMs = responseTimeMs;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    public boolean isSucceededFlag() {
        return succeededFlag;
    }

    public void setSucceededFlag(boolean succeededFlag) {
        this.succeededFlag = succeededFlag;
    }

    @Override
    public String toString() {
        return "AuditReport{" +
                "id=" + id +
                ", timestamp=" + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS").format(timestamp) +
                ", transactId=" + transactId +
                ", responseTimeMs=" + responseTimeMs +
                ", serviceName='" + serviceName + '\'' +
                ", succeededFlag=" + succeededFlag +
                '}';
    }

    public static AuditReport generateAMockOfMe(){
        AuditReport ar = new AuditReport();
        ar.setTransactId(new Date().getTime());
        ar.setTimestamp(new Date().getTime());
        ar.setResponseTimeMs(random.nextLong());
        ar.setServiceName("service#" + random.nextInt());
        ar.setSucceededFlag(random.nextBoolean());

        return ar;
    }
}
