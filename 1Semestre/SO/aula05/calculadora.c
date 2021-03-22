#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(int argc, char **argv){
    float arg1 , arg2;
    if(argc != 4){
        printf("Numero de argumentos errado, meta 3 args.");
        return EXIT_FAILURE;
    }
    else
    {
        arg1 = atof(argv[1]);
        char *notconverted;
        arg2 = strtod(argv[3] , &notconverted);
        char op = *argv[2];
        
        switch (op)
        {
        case '+':
            printf("Resultado da soma : %.1f\n" , arg1+arg2);
            break;
        case '-':
            printf("Resultado da subtracao : %.1f\n" , arg1-arg2);
            break;
        case 'x':
            printf("Resultado da multiplicacao : %.1f\n" , arg1*arg2);
            break;
        case '/':
            printf("Resultado da divisao : %.1f\n" , arg1/arg2);
            break;
        case 'p':
            printf("Resultado da potencia : %.1f\n" , pow(arg1,arg2));
            break;
        default:
            printf("Coloca uma operacao que esteja definida\n");
            break;
        }
    }
    
    return 0;
}