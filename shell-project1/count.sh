function main() {

local arr=( `ls /bin` )

locla count=8 temp="a"

for i in ${arr[@]}; do
    curr=${i:0:1}    
    if [ "$temp" != "$curr" ]; then 
        echo "$temp $count"
        count=1  
    fi
    #echo "$temp"
    count=$(( $count + 1 ))    
    temp="${i:0:1}"
    
done

echo "$temp $count"

}

main