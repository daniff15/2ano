#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char const *argv[])
{
    /*printf("Diga a frase: \n");
    
    //alternativa pelo fgets (mt mais simples)
    char frase[50];
    fgets(frase, sizeof(frase) / sizeof(frase[0]), stdin); // os 3 arg sao: 1- local onde é guardado o conteudo, 2- qts carateres le, 3- stdin para ler do teclado

    printf("%s\n", frase);
    //mas nao ta funcional xD - Maneira do sobral
*/


    char arg[100] , sentence[100];
    int idx = 0;

    for ( int i = 1; i < argc; i++)
    {
        strcpy(arg , argv[i]);

        for (int j = 0; j < strlen(arg); j++)
        {
            sentence[idx] =  arg[j];
            idx++;
        }
        
    }
    
    printf("FRASE: %s\n", sentence);

    return 0;   
}