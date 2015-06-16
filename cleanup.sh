#!/bin/bash

cat temphtml/AA/* > output.html
mkdir temp
java seperate
zip  FinalOutput temp/*
rm -rf temp/