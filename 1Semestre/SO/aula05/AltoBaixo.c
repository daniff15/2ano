#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <ctype.h>
#include <time.h>

int main(int argc, char const *argv[])
{
    int min, max , count = 0, tentativa;

    if(argc != 3){
        printf("Coloque 2 argumentos (min, max)\n");
        return EXIT_FAILURE;
    }

    min = atoi(argv[1]);
    max = atoi(argv[2]);
    
    
    if (min == max)
    {
        printf("Mínimo == Máximo: %d = %d\n", min, max);
        return EXIT_FAILURE;
    }
    else if (min > max)
    {
        printf("Min > Max: %d > %d\n", min, max);
        return EXIT_FAILURE;
    }
    else
    {
        srand((unsigned)time(NULL));
        int randNum = min + rand() % (max - min);
        //printf("NRANDOM: %d\n", randNum);

        do
        {
            printf("Tentativa- ");
            scanf("%d", &tentativa);
            count++;
            if (tentativa > randNum)
            {
                printf("A tentativa foi demasiado alta, tenta mais baixo.\n");
            }
            else if (tentativa < randNum)
            {
                printf("A tentativa foi demasiado baixa, tenta mais alto.\n ");
            }
            else
            {
                printf("Tentativa = Segredo. Apenas em %d tentativas.\n" , count);
            }
            
            
            
        } while (tentativa != randNum);
        
    }
    
    return 0;
}