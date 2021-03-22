#!/bin/bash
#parte de pedir os numeros para dentro do array
echo "Tamanho do array: "
read arrL

echo "Numeros dentro do array: "
for((i=0 ; i < $arrL ; i++)); do
	read arr[$i]
done

#parte do selectionSort

for((i = 0; i < arrL - 1 ; i++)); do
	menor=${arr[$i]}
	index=$i
	for((j = i + 1; j < arrL ; j++)); do
		if((arr[j]<menor)); then
			menor=${arr[j]}
			index=$j
		fi
	done
	temp=${arr[$i]}
	arr[$i]=${arr[$index]}
	arr[$index]=$temp
done

#printing sorted array
echo "printing sorted array"
for((i=0;i<arrL;i++)); do
	echo ${arr[$i]}
done


