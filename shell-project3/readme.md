1. Download the index page from you tube using "wget -O index.html url_here"

2. Construct a text table with five columns: user, views, time (duration), id, title

Use only grep, expr, cut and paste commands with loops, as discussed in class. For example, "grep views index.html" will find a list of lines that contain views. But then there are unwanted lines among them. You need to filter these lines out by using "grep -v". These successive commands through pipe "|" will give you lines with "123,456 views". Get rid of the word "views" and also remove "," (commas). Suppose s=123,456,789; "${s//,/}" will remove ALL the commas (global replacement).

Now you have a list of views in numbers. You need to extract the rest: usernames, time and titles.

The expr command will be helpful to extract a substing from a string. For example, given s='href="http://www.some-url.com/myname/youraccount/250,4211/acct-name">Lastname, Firstname'

number=`expr "$s" : ".*\/\([0-9,]*\)\/"`; echo $number # will print 250,4211

Note that the latest index.html file has some lines split into multiple lines. You will have to write more than one liner to extract values for each column names, where column names are views, name, time, title, and key. Essentially you will have to write a bash script to do this, not as simple as we did in class due to split lines in the original html file. We'll discuss a formal/systematic approach to extract values pages regardless of their broken/clean status starting week 11.
