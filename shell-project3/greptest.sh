#!/bin/sh
# Uzzul Hussain
# Professor Sohn
# CS288 - Homework 3 on Using Grep
wget -O index.html youtube.com 
echo "Views" >> Views.txt
echo "Name" >> Name.txt
echo "Time" >> Time.txt
echo "Title" >> Title.txt
echo "ID" >> Id.txt
grep "yt-lockup-content" index.html | while read x; do
	views=`expr "$x" : ".*info\"><li>\(.*\) views</li>"`
	echo ${views//,/} >> Views.txt
done 
grep "video-time" index.html | while read x; do
	Time=`expr "$x" : ".*aria.hidden=\"true\">\(.*\)</span>"`
	echo ${Time//<\/span>/} >> Time.txt
done
grep -o "a href=\"/user.*\" >[a-zA-Z0-9]\(.*\).*<\/a>\|a href=\"/channel.*\" >[a-zA-Z0-9]\(.*\).*<\/a>" index.html | grep -v "Popular on YouTube\|- Topic" | while read x; do
	Name=`expr "$x" : ".*\" >\(.*\).*<\/a>"`
	echo ${Name} >> Name.txt
done
grep "yt-lockup-content" index.html | while read x; do
	title=`expr "$x" : ".*\"ltr\">\(.*\)</a><span"`
	echo ${title} >> Title.txt
done
grep -o "a href=\"/watch?v=[-a-zA-Z0-9\_ ]*" index.html | while read x; do
	Id=`expr "$x" : '.*?v=\([-a-zA-Z0-9|_ ]*\)'`
	echo $Id >> Id.txt
done
paste -d, Views.txt Name.txt Time.txt Title.txt Id.txt > tbl2.csv
