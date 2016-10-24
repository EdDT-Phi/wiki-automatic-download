#!/bin/bash

python WikiExtractor.py -o temphtml/ -b 1G --no-templates --html --threads 4 dump/*.xml

# The results are non-deterministic. Every run produces different results
# suggesting that there are race conditions not being taken into consideration
# in the main python code.
