/*
* charCount.c
* prints the number of characters in a string on the command line
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char* argv[]){
  if( argc<2 ){
    printf("Usage: %s some-string\n", argv[0]);
    exit(EXIT_FAILURE);
  }

  printf("%s contains %d characters\n", argv[1], strlen(argv[1]) );;
  return EXIT_SUCCESS;
}
