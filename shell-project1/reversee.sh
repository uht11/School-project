#!/bin/bash

function reverse() {
    local arr=("$@")
    echo ${arr[@]}
}

function main() {
    local destination=$1
    local arr2=()
    cd $destination

    local arr=( $(ls) )  

    for ((i=${#arr[@]}; i>0; i--)); do
        arr2+="${arr[$i]} "
    done
    
    reverse ${arr2[@]}
}

main $1
