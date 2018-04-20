#!/bin/bash

function main() {

local arr=("$@")

for ((i=0;i<${#arr[@]};i++)); do
    curr=${arr[$i]}
    index=$i
    # echo "$i -> $curr"

    for((j=i+1;j<${#arr[@]};j++)); do
        if (( arr[j] < curr )); then
            curr=${arr[$j]}
            index=$j        
        fi  
    done
        
    temp=${arr[$i]}
    arr[i]=${arr[$index]}
    arr[index]=$temp

done

echo "${arr[@]}"

}

userInput=($@)
main "${userInput[@]}" 