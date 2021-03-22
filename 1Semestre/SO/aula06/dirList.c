#include <dirent.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* SUGESTÂO: utilize as páginas do manual para conhecer mais sobre as funções usadas:
  man opendir
  man readdir
*/

void listDir(char dirname[])
{
    DIR *dp;
    struct dirent *dent;

    dp = opendir(dirname);
    if (dp == NULL)
    {
        perror("Error opening directory");
        return;
    }

    dent = readdir(dp);
    while (dent != NULL)
    {
        if (dent->d_name[0] != '.') /* do not list hidden dirs/files */
        {
            if (dent->d_type == DT_DIR)
            {
                printf("d %s/%s\n", dirname, dent->d_name);
                char sentence[150];
                //? Não sei como por isto a dar com a recursividade
                /*char str1[150];
                char str2[150];
                char sentence[150];
                int countMarinhs = 0;
                strcpy(str1, dirname);
                //printf("FRASE: %s\n", str1);
                strcpy(str2, dent->d_name);

                int i;
                for (i = 0; i < strlen(str1); i++)
                {
                    sentence[countMarinhs] = str1[i];
                    countMarinhs++;
                }

                sentence[countMarinhs++] = '/';
                for (i = 0; i < strlen(str2); i++)
                {
                    sentence[countMarinhs] = str2[i];
                    countMarinhs++;
                }
                sentence[countMarinhs] = '\0';*/
                
                //maneira stor

                strcpy(sentence, dirname);
                strcat(sentence, "/");
                strcat(sentence, dent->d_name);
                
                listDir(sentence);
            }
            //! se for so um else e depois o print, dá na mesma
            else //if (dent->d_type == DT_REG) //ver se é ficheiro
            {
                printf("  %s/%s\n", dirname, dent->d_name);
            }
        }
        dent = readdir(dp);
    }
}

int main(int argc, char *argv[])
{
    if (argc != 2)
    {
        fprintf(stderr, "Usage: %s base_directory\n", argv[0]);
        return EXIT_FAILURE;
    }

    listDir(argv[1]);

    return EXIT_SUCCESS;
}
