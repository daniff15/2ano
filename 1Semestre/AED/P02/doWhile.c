#include <stdio.h>

int main(void)
{
    int x, cont = 0;
    int ret;
    do{
            printf("Please enter a positive value: ");
            ret = scanf("%d", &x); 
            if(ret == 1)        // there was a conversion error   ENTRA SEMPRE WTF    
                scanf("%*[^\n]"); // read everything until newline   
                cont++;
    }
    while(ret != 1 || x <= 0);
    printf("Value %d read in %d attempt%s\n",x,cont,(cont == 1) ? "" : "s");

    int n;

    do{
        printf("Please enter a number in [1-10] - ");
        scanf("%d" , &n);
    }
    while(n < 1 || n > 10);

    int i;

    for (i = 1; i <= 10; i++)
    {
        printf("%2d x %2d = %2d\n" , n , i , n*i);
    }


    int d, contaa = 0;
    do{
        printf("Introduza um valor inteiro positivo: ");
        scanf("%d", &d);
        contaa++;
        if(contaa >= 10)  // after 10 attempts, terminate the loop        
            break;
    }
    while(d <= 0);
    if(d > 0)  
        printf("Value %d read in %d attempts\n",d,contaa); 
    else 
        printf("Unable to read a value in ten attempts\n");
    return 0;
    
}