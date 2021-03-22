//
// Tomás Oliveira e Silva, AED, September 2020
//
// example of function overloading (same function name, different argument numbers and/or data types)
//

#include <iostream>

using std::cout; // make this symbol from the std namespace directly visible

void show(const int i)
{
  cout << "int: "
       << i
       << std::endl;
}

void show(const double d)
{
  cout << "double: "
       << d
       << std::endl;
}

void show(const char c)
{
  cout << "Char: "
       << c
       << std::endl;
}

void show(const char *s,const char *h = "string: ") // second argument with default value
{
  cout << h
       << s
       << std::endl;
}

void show(const int arr[]){
  cout << "Array: [" ;
  for (int i = 0; i < 2; i++)
  {
      cout << arr[i] << "," ;
  }
      cout << arr[2] << "]" << std::endl;
  
}

int main(void)
{
  show(1.0);
  show("hello");
  show(-3);
  show("John","name: ");
  show('a');
  int a[3] = { 2,7,-1 };
  show(a);
  return 0;
}
