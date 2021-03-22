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
    char *array[argc - 1];

    for (int i = 0; i < size(array); i++)
    {
        array[i] = (char *)malloc(10);
        strcpy(array[i] , argv[i+1]);
    }
    
    printf("----- Nao ordenados ---\n");

    for (int i = 0; i < argc -1; i++)   //ou podia ser ate size(array)
    {
        printf("Palavra nº %d- %s\n" , i+1, array[i]);
    }
    
    qsort( array, size(array), sizeof(array[0]), myCompare);

    printf("----- Ordenadas -----\n");

    for (int i = 0; i < argc -1; i++)   //ou podia ser ate size(array)
    {
        printf("Palavra nº %d- %s\n" , i+1, array[i]);
    }

    return 0;
}