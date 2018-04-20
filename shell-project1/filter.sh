#!/bin/bash

function filter() {
    local directory=$1 average=$2
    local arr=( `ls -l $directory | awk '{print $9}'` )
    local count=0
 
    for i in `ls -l $directory | awk '{print $5}'`; do
        count=$(($count + 1)) 
        if [ $i -ge $avg ]; then
            echo "${arr[$count]} ($i)"
        fi        
    done
}

function average(){
    local directory=$1

    arr=(`ls -l $directory | awk '{print $5}'`)
    avg=0
    for i in ${arr[@]}; do
        avg=$(( $avg + $i ))
    done

    avg=$((`expr $avg / ${#arr[@]}`))

    filter $avg
}

function main() {
    average $1
    filter $1
}

input=$1
main $input