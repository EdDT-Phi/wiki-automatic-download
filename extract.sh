#!/bin/bash

python WikiExtractor.py -o temphtml/ -b 1G --no-templates --html --threads 4 dump/*.xml

# 5 threads produces 43074 pages
# 6 threads produces 47937 pages
# 7 threads produces 46232 pages
# jk it's not consistent
# there should be max 44k pages Q_Q
# 20 produces like 28000