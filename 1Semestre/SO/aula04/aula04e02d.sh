#!/bin/bash 

echo "Primeiro argumento:"
read arg1
echo "Segundo argumento:"
read arg2

function maior_Uti()
{
	if (( $arg1 < $arg2 )) ; then
		echo "Maior - " $arg2
	elif (( $arg1 > $arg2 )) ; then
		echo "Maior - " $arg1
	else
		echo "Iguais"

	fi
	return 0
}
maior_Uti $arg1 $arg2
