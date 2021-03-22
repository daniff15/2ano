#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

typedef struct
{
    int age;
    double height;
    char name[64];
} Person;


int main (int argc, char *argv[])
{
    FILE *fp = NULL;
    int i;
    Person p = {35, 1.65, "xpto"}; //tava assim para o exercicio 1
    //scanf("%[^\n]" , n1) -> n1 = char[10] , este scanf le ate encontrar um \n
    //scanf("%[^\n]" , n2) -> n2 = char[10] , ele vai ver o q tem para ler e se tiverem seguidos nao vai esperar e ler outra coisa, pois na parte de cima jae
    //encontrou um \n, tem de se colocar entre estes dois um scanf("%*c); e ao fazer desta maneira nao tem de se por endereco atras de struct.nome, pk struct.nome aponta 
    //ja para um apontador para char.
    /* Validate number of arguments */
    if(argc != 2)
    {
        printf("USAGE: %s fileName\n", argv[0]);
        return EXIT_FAILURE;
    }

    /* Open the file provided as argument */
    errno = 0;
    fp = fopen(argv[1], "wb");
    if(fp == NULL)
    {
        perror ("Error opening file!");
        return EXIT_FAILURE;
    }

    int numP = 0;

    printf("Numero de pessoas q quer guardar?");
    scanf("%d" , &numP);

    for (i = 0; i < numP; i++)
    {
        printf("Nome:\n");
        scanf(" %63[^\n]" , p.name);
        printf("Idade:\n");
        scanf("%d" , &p.age);
        printf("Altura:\n");
        scanf("%lf" , &p.height);//meti lf pk dava warninh e mete endereco para tirar o warning tambem
        fwrite(&p, sizeof(Person), 1, fp);
        if (i < numP-1)
        {
            printf("-----------Outra Pessoa----------\n");
        }
        
    }
    

    /* Write 10 itens on a file */
    /*for(i = 0 ; i < 10 ; i++)
    {    
        p.age = p.age+1;
        p.height = p.height+0.03;
        fwrite(&p, sizeof(Person), 1, fp);
    }*/

    fclose(fp);

    return EXIT_SUCCESS;
}
