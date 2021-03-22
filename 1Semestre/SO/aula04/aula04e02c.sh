#!/bin/bash 
function maior(){
	if (( $1 < $2 )) ; then
		echo "Maior - " $2
	elif (( $1 > $2 )) ; then
		echo "Maior - " $1
	else
		echo "Iguais"

	fi
	return 0
}
maior $1 $2
