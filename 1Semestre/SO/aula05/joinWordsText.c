#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main(int argc, char const *argv[])
{    
    char arg[100] , sentence[100];
    int idx = 0;

    for ( int i = 1; i < argc; i++)
    {
        strcpy(arg , argv[i]);

        for (int j = 0; j < strlen(arg); j++)
        {   
            if(isalpha(arg[0])){
                sentence[idx] =  arg[j];
                idx++;
            }
            
        }
        
    }
    
    printf("FRASE: %s\n", sentence);
 
    return 0;   
}