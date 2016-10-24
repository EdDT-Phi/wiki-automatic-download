#!/bin/bash

# API:
# To find out if the wiki you want to back up has api.php or not,
# open a browser window and go to the wiki's Main Page.
# Click on the "View history" tab.
# You will see a URL such as this: http://wikitravel.org/wiki/en/index.php?title=Wikitravel:Project&action=history
# Now edit the URL: remove everything after /w/ or /wiki/en/, and replace it with api.php
# (In the example, the result would be: http://wikitravel.org/wiki/en/api.php). 

# If it doesn't have API, or for more info, check out this github page:
# https://github.com/WikiTeam/wikiteam

if (($# < 1))
then
	echo "Usage: ./automate [API]  ...  open this bash file for more info"
	exit 1
fi

rm -rf dump/

python dumpgenerator.py --xml --curonly --api=$1 --path dump/

while (($? > 0))
do
	echo "sleeping 30 seconds, will try again after this nap"
	sleep 30
	./resume.sh $1
done

./extract.sh

./cleanup.sh

exit 0
