Continuing on Homework 3 but this time using C structures, design and implement a C program that handles what you did in Homework 3. Use the skeleton code attached. Fill the structure with all four values: views, user, times, titles.

1. Prepare a CSV file (comma sepearated value file) containing all the values. Each line of the CSV file will consist of views, user, id, titles. Use the same commands you used to create a table, except now that you have to put in "," (commas) in between the four values as delimiter. Note however that before you put in commas, you need to convert those pre-existing commas (some titles have commas unfortunately) to something else such as MY_COMMA or something of that sort. Later on you can revert MY_COMMA back to real commas when everything is said and done.

2. Use strtok() function to split a line into four fields with "," as the delimiter. As cautioned above, you need to convert commas to something else which can then be reverted back to commas after you have built a list.
insert_at_end(char *s) will insert not just user but all the remaining values as well.
