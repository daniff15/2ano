#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <getopt.h>

int main(int argc, char *argv[])
{
    int i;
    int op;
    int minimo, maximo;

    while ((op = getopt(argc, argv, "n:x:")) != -1)
    {
        switch (op)
        {
        case 'n':
            minimo = atoi(optarg);
            printf("Minimo - %d\n", minimo);
            break;

        case 'x':
            maximo = atoi(optarg);
            printf("Máximo - %d\n", maximo);
            break;

        default:
            break;
        }
    }

    if (optind > 4) // Caso tenham sido passado as duas opções
    {
        for (i = optind; i < argc; i++)
        {

            if (atoi(argv[i]) > minimo && atoi(argv[i]) < maximo)
            {
                printf("%d\n", atoi(argv[i]));
            }
        }
    }

    if (optind > 2 && optind < 4) // Caso só tenha sido passada uma das opções
    {
        for (int c = 1; c < optind; c++)
        {
            if (strcmp(argv[c], "-x") == 0)
            {
                for (i = optind; i < argc; i++)
                {
                    if (atoi(argv[i]) < maximo)
                    {
                        printf("%d\n", atoi(argv[i]));
                    }
                }
            }
        }

        for (int c = 1; c < optind; c++)
        {
            if (strcmp(argv[c], "-n") == 0)
            {
                for (i = optind; i < argc; i++)
                {

                    if (atoi(argv[i]) > minimo)
                    {
                        printf("%d\n", atoi(argv[i]));
                    }
                }
            }
        }
    }

    /*for (int i = 1; i < argc; i++)
    {
        if (atoi(argv[i]) % 2 == 0 )
        {
            printf("É par - %s\n" , argv[i]);
        }
        
    }*/
    //  Ver se os numeros com q chama o programa sao pares

    /*int *numbers;
    int tamanho = argc - 1; 
    numbers = (int *)malloc(sizeof(int) * tamanho);
    for (int i = 0; i < tamanho; i++)
    {
        numbers[i] = atoi(argv[i+1]);
        if (numbers[i] % 2 == 0)
        {
            printf("É par - %d\n" , numbers[i]);
        }
        
    }*/

    return 0;
}
