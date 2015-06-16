#!/bin/bash

if (($# < 1))
then
	echo "Usage: ./automate [API]  ...  open this bash file for more info"
	exit 1
fi

python dumpgenerator.py --xml --curonly --api=$1 --path dump/ --resume

exit $?