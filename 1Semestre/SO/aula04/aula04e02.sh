#!/bin/bash
function numeric_to_string()
{
     case $1 in
         1)
            num=1
             ;;
         2)
            num=2
             ;;
         3)
            num=3
             ;;
         *)
            num=$1

     esac
     return 0
}
numeric_to_string $1
echo $num 

#! antes dentro do case tinha com return e nao tinha nengum echo aqui em baixo