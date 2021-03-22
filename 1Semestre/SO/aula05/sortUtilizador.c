#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <ctype.h>
#include <time.h>
#define size(x) sizeof(x) / sizeof(x[0]) 



int myCompare( const void *a, const void *b )
{
  return strcmp( *(char**)a, *(char**)b );
}

int main(int argc, char const *argv[])
{
    int num;

    /*array[0] = (char*)malloc(10);  // allocate space for a string of maximum 9 chars
    array[1] = (char*)malloc(10);
    array[2] = (char*)malloc(10);  // allocate space for a string of maximum 9 chars
    array[3] = (char*)malloc(10);
    array[4] = (char*)malloc(10);  // allocate space for a string of maximum 9 chars
    array[5] = (char*)malloc(10);*/
    // fazer a parte de nao definir ja o tamanho do arr
    printf("Quantas palavras quer colocar no array? ");
    scanf("%d", &num);
    char *array[num];
    char *outro[num];
    int idx = 0;
    printf("-------PAlavras nao ordenadas------\n");   
    for (int i = 0; i < size(array); i++)
    {
        array[i] = (char *)malloc(10);
        printf("Palavra nº %d- " , i+1);
        scanf("%s", array[i]);
        if (isalpha(array[i][0]))
        {
            outro[idx] = (char *)malloc(10);
            outro[idx] = *(array + i);
            idx++;
            printf("---------------------------------");
        }
        
    }

    //printf("-------PAlavras nao ordenadas------\n");
    /*for (int i = 0; i < 6; i++)
    {
        printf("Palavra nº %d- " , i+1);
        scanf("%s", array[i]);
    }*/

    qsort( array, size(array), sizeof(array[0]), myCompare);


    printf("-------Palavras Ordenadas------\n");


    for (int i = 0; i < size(array); i++)
    {
        printf("Palavra nº %d- %s\n" , i+1, array[i]);
    }
    
    
    return 0;
}