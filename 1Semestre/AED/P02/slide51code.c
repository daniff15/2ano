#include <stdio.h>


int main(void)
{
    union
    {
        double d;
        unsigned char c[8];
    }
    t;
    
    t.d = 20.0; // store a double
    for(int i = 0;i < 8;i++)
    {
        printf(" %02X",t.c[i]); // print its individual bytes
        if (i == 7)
        {
            printf("\n");
        }
        
    }
    return 0;
}