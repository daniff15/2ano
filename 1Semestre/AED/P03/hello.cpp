/*
** Tomás Oliveira e Silva, AED, September 2020
**
** my first C++ program (compare with hello.c)
*/

#include <iostream>

int main(void)
{
  std::cout << "Hello world!\n"; // "same" as printf("Hello world\n");
  //  return 0;  // main() returns 0 if no return value is given

  int i;

  for (i = 1; i < 11; i++)
  {
    std::cout << i << "\n";
  }
  

}
