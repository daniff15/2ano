#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

/* SUGESTÂO: utilize as páginas do manual para conhecer mais sobre as funções usadas:
 man qsort
*/

#define LINEMAXSIZE 80

int compareInts(const void *px1, const void *px2)
{
    int x1 = *((int *)px1);
    int x2 = *((int *)px2);
    return (x1 < x2 ? -1 : x1 == x2 ? 0 : 1); // crescente
    //return (x1 < x2 ? -1 : x1 == x2 ? 0 : 1); //decrescente

}

int main(int argc, char *argv[])
{
    int i, numSize;
    int val;
    int *numbers;

    //numSize = argc - 1;
    //ler do terminal
    FILE *fp = NULL;
    //char line[LINEMAXSIZE];       only used for fgets()

    /* Memory allocation for all the numbers in the arguments */
    //numbers = (int *) malloc(sizeof(int) * numSize);

    /* Storing the arguments in the "array" numbers */
    /*for(i = 0 ; i < numSize ; i++)
    {
        numbers[i] = atoi(argv[i+1]);
    }*/
    //Ordenar os numeros q sao passados como argumentos

    //Ordenar os numeros, lendo o ficheiro com fgets()
    /*errno = 0;
    for (int i = 1; i < argc; i++)
    {
        fp = fopen(argv[i], "r");
        if (fp == NULL)
        {
            perror("Error opening file!");
            return EXIT_FAILURE;
        }
        numSize = 0;
        while (fgets(line, sizeof(line), fp) != NULL)
        {
            numSize++;

            //printf("%d-> %s", count,line);  not needed to add '\n' to printf because fgets will read the '\n' that ends each line in the file */
    //}
      //  fclose(fp);
        //allocate memory
        //numbers = (int *) malloc(sizeof(int) * numSize);

        /* Read all the lines of the file */
    /*fp = fopen(argv[i], "r");
        int count = 0;
        while (fgets(line, sizeof(line), fp) != NULL)
        {
            numbers[count] = atoi(line);
            count++;

            //printf("%d-> %s", count,line); not needed to add '\n' to printf because fgets will read the '\n' that ends each line in the file */
    /*}

        fclose(fp);

        printf("--------------Divisao------------\n");
    } LER DO FICHEIRO COM FGETS() */

    //LER DO FICHEIRO COM FSCANF
    //Ordenar os numeros, lendo o ficheiro com fgets()
    errno = 0;
    for (int i = 1; i < argc; i++)
    {
        fp = fopen(argv[i], "r");
        if (fp == NULL)
        {
            perror("Error opening file!");
            return EXIT_FAILURE;
        }
        numSize = 0;
        while (fscanf(fp , "%d" , &val) == 1)
        {
            numSize++;

            //printf("%d-> %s", count,line); /* not needed to add '\n' to printf because fgets will read the '\n' that ends each line in the file */
        }
        fclose(fp);
        //allocate memory
        numbers = (int *)malloc(sizeof(int) * numSize);

        /* Read all the lines of the file */
        fp = fopen(argv[i], "r");
        int count = 0;
        while (fscanf(fp , "%d" , &val) == 1)
        {
            numbers[count] = val;
            count++;

            //printf("%d-> %s", count,line); /* not needed to add '\n' to printf because fgets will read the '\n' that ends each line in the file */
        }

        fclose(fp);

        printf("--------------Divisao------------\n");
    }
    /*void qsort(void *base, size_t nmemb, size_t size, int (*compar)(const void *, const void *)); 
         The qsort() function sorts an array with nmemb elements of size size.*/
    //ize, sizeof(int), compareInts);
    qsort(numbers, numSize, sizeof(int), compareInts);

    /* Printing the sorted numbers */
    printf("Sorted numbers: \n");
    for (i = 0; i < numSize; i++)
    {
        printf("%d\n", numbers[i]);
    }

    return EXIT_SUCCESS;
}
