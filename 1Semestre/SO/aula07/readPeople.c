#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>

typedef struct
{
    int age;
    double height;
    char name[64];
} Person;

void printPersonInfo(Person *p)
{
    printf("Person: %s, %d, %f\n", p->name, p->age, p->height);
}

int main(int argc, char *argv[])
{
    //Person vals[100];
    //int np; - numero de pessoas.
    FILE *fp = NULL;
    Person p;

    //COMANDO INTERNO DA BASH -- getopts

    /* Validate number of arguments */
    if (argc != 2)
    {
        printf("USAGE: %s fileName\n", argv[0]);
        return EXIT_FAILURE;
    }

    /* Open the file provided as argument */
    errno = 0;
    fp = fopen(argv[1], "rb");
    if (fp == NULL)
    {
        perror("Error opening file!");
        return EXIT_FAILURE;
    }
    int numP = 0;
    printf("Quantas mais pessoas quer ler para alem das do write?\n");
    scanf("%d", &numP);

    Person people[numP];
    char array[numP][30];
    int nPessoas = 0;

    for (int i = 0; i < numP; i++)
    {
        printf("Nome:\n");
        scanf(" %63[^\n]", array[i]);
        strcpy(p.name, array[i]);
        printf("Idade:\n");
        scanf("%d", &p.age);
        printf("Altura:\n");
        scanf("%lf", &p.height);

        people[nPessoas] = p;
        nPessoas++;
    }

    while (fread(&p, sizeof(Person), 1, fp) == 1)
    {
        //adiciona ao array as pessoas que estao no ficheiro binario
        people[nPessoas] = p;
        nPessoas++;
    }

    /* read all the itens of the file */
    while (fread(&p, sizeof(Person), 1, fp) == 1) //&p[np] == p + np
        //sem usar o while podia ser logo fread(&p, sizeof(Person), 100, fp) -> retorna o numero de pessoas - podiamos logo ler o fizheiro todo pk sabemos q o ficheiro vai
        // ter menos de 100 pessooas segundo o enunciado.
    {
        printPersonInfo(&p);
    }

    for (int i = 0; i < nPessoas; i++)
    {
        printPersonInfo(&people[i]);
    }

    fclose(fp);

    return EXIT_SUCCESS;
}
