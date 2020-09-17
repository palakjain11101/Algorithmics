#include <iostream>
#include <fstream>
#include <iterator>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stdio.h>

using namespace std;

int main(int argc, char *argv[])
{
  int N;
  clock_t t; 
  
  sscanf(argv[1], "%d", &N);
  vector<double> data(N);
  for(unsigned int i=0; i<N; i++) {
    data[i] = rand()/(RAND_MAX+1.0);
  }
  t = clock(); 
  sort(data.begin(), data.end());
  t = clock() - t; 
  double time_taken = ((double)t)/CLOCKS_PER_SEC; // in seconds 
  printf("fun() took %f seconds to execute \n", time_taken); 
  return 0;
  //copy(data.begin(), data.end(), ostream_iterator<double>(cout,"\n"));
}


  
    