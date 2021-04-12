#!/bin/bash

cd ../helm-chart-copy
touch tempLogs.txt
date >> bashLogs.txt 
helm upgrade kube-prometheus-stack prometheus-community/kube-prometheus-stack -f values.yaml >> tempLogs.txt
cat tempLogs.txt
cat tempLogs.txt >> bashLogs.txt
rm tempLogs.txt
echo ' ' >> bashLogs.txt

# This script allows you to update the helm chart if you make any changes to the values.yaml