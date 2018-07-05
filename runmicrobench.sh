#!/bin/bash
COUNTER=0
while [ $COUNTER -lt 10 ]; do
    java -cp bin com.microbenchmark.MicrobenchFibonacci 10;
    let COUNTER=COUNTER+1
done;
