# Wiki Automatic Download

This project is an application that automatically downloads any wiki site and seperates it into seperate HTML pages.

## How to Run

To run this (on Linux, haven't tested other environments), run
'''
./automate.sh (API url)
'''
To find the api.php url, open a browser window and go to the wiki's Main Page. Click on the "View history" tab. You will see a URL such as this:
http://wikitravel.org/wiki/en/index.php?title=Wikitravel:Project&action=history/
Now edit the URL: remove everything after /w/ or /wiki/en/, and replace it with api.php. In the example, the result would be:
http://wikitravel.org/wiki/en/api.php
If it doesn't have API, or for more info, look at the github page
https://github.com/WikiTeam/wikiteam