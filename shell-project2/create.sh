#Name: Uzzul Hussain
#CS 288-002
#HomeWork 2

#!/bin/bash

function creat()
{
local d=$1 b=$2 seed=$3
open=()
open=$seed

#depth
for((a=0;a<$d;a++)); do
    temOpen=()
    #open
    for i in ${open[@]}; do
	#breath
	tem=()
	for((j=0;j<$b;j++)); do

	    mkdir $i$j"/"
	    
	    tem=(${tem[@]} $i""$j"/")
	    #echo ${temOpen[@]}
	    
        done
	temOpen=(${temOpen[@]} ${tem[@]})
    done
    
    open=(${temOpen[@]})
    echo ${open[@]}
    
done
}
creat 3 4 "./"     #this will make the dir starting from the current folder the .sh is in.
