#!bin/bash
#boa
function imprime_msg()
{
        echo "A minha primeira funcao"
        return 0
}

function data_pc()
{
        echo "Data - " $(date)
        echo "Nome do pc - " $(hostname)
        echo "Utilizador - " $(who)
        echo "Utilizador - " $(whoami)
        return 0
}

