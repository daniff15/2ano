#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    int i;

    if(argc != 3){
        printf("Numero de args errado, colocou %d argumentos.\n" , argc);
        return EXIT_FAILURE;
    } 

    for(i = 0 ; i < argc ; i++)
    {
        printf("Argument %02d: \"%s\"\n", i, argv[i]);        
    }

    return EXIT_SUCCESS;
}
