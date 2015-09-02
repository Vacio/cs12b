//-----------------------------------------------------------------------------
// NAME: AISHNI PARAB
// CRUZID: APARAB
// CLASS: CMPS 12B
// DATE: AUGUST 9 2015
// FILENAME: DictionaryTest.c
// DESCRIPTION: Tests the implementation Dictionary.h using Hash Tables
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"Dictionary.h"

#define MAX_LEN 180

int main(int argc, char* argv[]){
 Dictionary A = newDictionary();
 //char* k;
 //char* v;
  char* X[] = {"one","two","three","four","five","six","seven"};
  char* Y[] = {"a","b","c","d","e","f","g"};
  int i;

  for(i=0; i<7; i++){
    insert(A, X[i], Y[i]);
  }

  printDictionary(stdout, A);
}
