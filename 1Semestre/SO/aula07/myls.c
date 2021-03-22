#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <dirent.h>
#include <string.h>
#include <getopt.h>

struct option long_options[] =
        {
            {"file", no_argument, 0, 'f'},
            {"dir", no_argument, 0, 'd'},
            {"ext", required_argument, 0, 'e'}
        };

int option_index = 0;

void list(char dirname[], int type_list) // type_list: 1->-f; 0->-d; -1->-e
{
    //while ((opt = getopt(argc, argv, "dfe:")) != -1)

    DIR *dp;
    struct dirent *dent;
    char *point;

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
            switch (type_list)
            {
            case 1:
                if (dent->d_type == DT_REG)
                {
                    printf("%s/%s\n", dirname, dent->d_name);
                }
                break;
            case 0:
                if (dent->d_type == DT_DIR)
                {
                    printf("%s/%s\n", dirname, dent->d_name);
                }
                break;
            case -1:
                if (dent->d_type == DT_REG)
                {
                    if ((point = strrchr(dent->d_name, '.')) != NULL)
                    {
                        if (strcmp(point, ".ext") == 0)
                        {
                            printf("%s/%s\n", dirname, dent->d_name);
                        }
                    }
                }
                break;
            }
        }

        dent = readdir(dp);
    }
}

int main(int argc, char *argv[])
{
    int opt, e_val;
    char cwd[PATH_MAX];
    char str[] = "Falam mal de mim porque tenho sauce";
    int i = 0 , count = 0;

    while (str[i] != '\0')
    {
        if (str[i] != ' ')
            ++count;
        ++i;
    }

    printf("Numero de caracteres sem espaços - %d\n", count);

    while ((opt = getopt_long(argc, argv, "dfe:",
                            long_options, &option_index)) != -1)
    {
        switch (opt)
        {
        case 'f':
            if (getcwd(cwd, sizeof(cwd)) != NULL)
            {
                list(cwd, 1);
                break;
            }
        case 'd':
            if (getcwd(cwd, sizeof(cwd)) != NULL)
            {
                list(cwd, 0);
                break;
            }
        case 'e':
            e_val = 1;
            break;
        }
    }

    if (e_val == 1)
    {
        if (optind < argc)
        {
            for (int i = optind; i < argc; i++)
            {
                list(argv[i], -1);
            }
        }
        else
        {
            if (getcwd(cwd, sizeof(cwd)) != NULL)
            {
                list(cwd, -1);
            }
        }
    }
}

/* OR

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <dirent.h>
#include <string.h>

void list(char dirname[],int type_list) // type_list: 1->-f; 0->-d; -1->-e
{
    
    DIR *dp; 
    struct dirent *dent;
    char * point;

    dp = opendir(dirname); 
    if(dp == NULL)
    {
        perror("Error opening directory");
        return;
    }

    dent = readdir(dp);
    while(dent!=NULL) 
    {
        if(dent->d_name[0] != '.') // do not list hidden dirs/files
        {
            switch (type_list)
            {
            case 1:
                if (dent->d_type == DT_REG)
                {
                    printf("%s/%s\n", dirname, dent->d_name);
                }
                break;
            case 0:
                if (dent->d_type == DT_DIR)
                {
                    printf("%s/%s\n", dirname, dent->d_name);
                }
                break;
            case -1:
                if (dent->d_type == DT_REG)
                {
                    if ((point = strrchr(dent->d_name, '.')) != NULL)
                    {
                        if (strcmp(point, ".ext") == 0)
                        {
                            printf("%s/%s\n", dirname, dent->d_name);
                        }
                    }
                }
                break;
            }
        }

        dent = readdir(dp);
    }
}

int main(int argc, char **argv)
{
    int opt, e_val;
    char cwd[PATH_MAX];

    while ((opt = getopt(argc, argv, "fde:")) != -1)
    {
        switch (opt)
        {
        case 'f':
            if (getcwd(cwd, sizeof(cwd)) != NULL)
            {
                list(cwd, 1);
                break;
            }
        case 'd':
           if (getcwd(cwd, sizeof(cwd)) != NULL)
            {
                list(cwd, 0);
                break;
            }
        case 'e':
            list(optarg,-1);
            while (optind < argc)
            {
                list(argv[optind], -1);
                optind++;
            }

            break;
        default:
            if (getcwd(cwd, sizeof(cwd)) != NULL)
            {
                list(cwd, -1);
            }
        }
    }
    
}
*/
/*

int main(int argc, char const *argv[])
{
    int opt;
    char *extension;
    int option_index = 0;

    struct option long_options[] =
        {
            {"file", no_argument, 0, 'f'},
            {"dir", no_argument, 0, 'd'},
            {"ext", required_argument, 0, 'e'}
        };
    DIR *dp;
    struct dirent *dent;

    //while ((opt = getopt(argc, argv, "dfe:")) != -1)
    while ((opt = getopt_long(argc, argv, "dfe:",
                            long_options, &option_index)) != -1)
    {
        dp = opendir(argv[1]);
        if (dp == NULL)
        {
            perror("Error opening directory");
            return EXIT_FAILURE;
        }

        dent = readdir(dp);
        while (dent != NULL)
        {
            if (dent->d_name[0] != '.') // do not list hidden dirs/files             {
                
                switch (opt)
                {
                case 'd':
                    if (dent->d_type == DT_DIR)
                    {
                        printf("%s/%s\n", argv[1], dent->d_name);
                    }

                    break;
                case 'f':
                    if (dent->d_type == DT_REG)
                    {
                        printf("%s/%s\n", argv[1], dent->d_name);
                    }
                    break;
                case 'e':
                    if (dent->d_type == 10)
                    {
                        printf("%s/%s\n", argv[1], dent->d_name);
                    }
                    extension = optarg; //NAO ESTA BEM Q NEM USO A EXTENSION (==10 DONT KNOW WHY SOBRAL)
                    break;
                default: // '?'
                    fprintf(stderr, "Usage: %s \n",
                            argv[0]);
                    exit(EXIT_FAILURE);
                }
            }
            dent = readdir(dp);
        }

        if (optind >= argc + 1)
        {
            fprintf(stderr, "Expected argument after options\n");
            return EXIT_FAILURE;
        }
    }
    return 0;
}

*/