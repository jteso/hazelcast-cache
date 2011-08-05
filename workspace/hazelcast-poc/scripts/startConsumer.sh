#!/bin/sh

java -Dhazelcast.config=../src/hazelcast.xml -cp ../lib/hazelcast-1.9.3.1.jar:../bin com.jteso.poc.hazelcast.Consumer 1
