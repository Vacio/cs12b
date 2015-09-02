/*
* -------------------------------------------------------------------------------------
* NAME: AISHNI PARAB
* CRUZID: APARAB
* CLASS: CMPS 12M
* DATE: JULY 20 2015
* FILENAME: charType.c
* DESCRIPTION: This program classifies the characters on each line of the input file into
* alphabetic characters, numeric characters, punctuation and whitespace. It then prints a
* report to the output file for each line in the input file.
* ---------------------------------------------------------------------------------------
*/

 #include <stdio.h>
 #include <stdlib.h>
 #include <string.h>
 #include <ctype.h>
 #include <assert.h>

#define maxStrLength 100 //max string length

void extract_chars(char* s, char* a, char* d, char* p, char* w);

int main(int argc, char* argv[]){
   FILE* in;
   FILE* out;
   char* line;
   char* word;
   char* number;
   char* punctuation;
   char* whitespace;
   int lineNum = 1; //line number

   if( argc != 3 ){
     printf("Usage: %s <input file> <output file>\n", argv[0]);
     exit(EXIT_FAILURE);
   }

   /* if input file is null, throws error */
   in = fopen(argv[1], "r");
   if ( in==NULL ){
     printf("Unable to read from file %s\n", argv[1]);
     exit(EXIT_FAILURE);
   }

   /* if output file is null, throw error */
   out = fopen(argv[2], "w");
   if( out==NULL ){
     printf("Unable to write to file %s\n", argv[2]);
     exit(EXIT_FAILURE);
   }

   /* char arrays are allocated heap memory here */
   line = calloc(maxStrLength + 1, sizeof(char));
   word = calloc(maxStrLength + 1, sizeof(char));
   number = calloc(maxStrLength + 1, sizeof(char));
   punctuation = calloc(maxStrLength + 1, sizeof(char));
   whitespace = calloc(maxStrLength + 1, sizeof(char));
   assert( line != NULL && word != NULL && number != NULL && punctuation != NULL && whitespace != NULL);

   /* reads input file and prints array in its respective character type */
   while ( fgets(line, maxStrLength, in) != NULL){
     //sorts the character into its respective type
     extract_chars(line, word, number, punctuation, whitespace);
     fprintf(out, "line %d contains: \n", lineNum);
     //word
     if(strlen(word)>1){
       fprintf(out, "%d alphabetic characters: %s\n", (int)strlen(word), word);
     }
     else {
       fprintf(out, "%d alphabetic characters: %s\n", (int)strlen(word), word);
     }
     //number
     if(strlen(number)>1){
       fprintf(out, "%d alphabetic characters: %s\n", (int)strlen(number), number);
     }
     else {
       fprintf(out, "%d alphabetic characters: %s\n", (int)strlen(number), number);
     }
     //punctuation
     if(strlen(punctuation)>1){
       fprintf(out, "%d alphabetic characters: %s\n", (int)strlen(punctuation), punctuation);
     }
     else {
       fprintf(out, "%d alphabetic characters: %s\n", (int)strlen(punctuation), punctuation);
     }
     //whitespace
     if(strlen(whitespace)>1){
       fprintf(out, "%d alphabetic characters: %s\n", (int)strlen(whitespace), whitespace);
     }
     else {
       fprintf(out, "%d alphabetic characters: %s\n", (int)strlen(whitespace), whitespace);
     }
     //increment line number
     lineNum++;
   }

   /* free allocated heap memory */
   free(line);
   free(word);
   free(number);
   free(punctuation);
   free(whitespace);

   /* close the files */
   fclose(in);
   fclose(out);

   return EXIT_SUCCESS;

 }

 void extract_chars(char* s, char* a, char* d, char* p, char* w){
   int i=0, j=0, k=0, l=0, m=0;
   while (s[i] != '\0' && i<maxStrLength){
     if( isupper((int)s[i])){
			a[j]=s[i];
			j++;
		}
		else if( isalpha((int)s[i])){
			a[j] =s[i];
			j++;
		}
		else if( isdigit((int)s[i])){
			d[k] = s[i];
			k++;
		}
		else if(ispunct((int)s[i])){
			p[l]=s[i];
			l++;
		}
		else{
			w[m]=s[i];
			m++;
		}
		i++;
   }

   //end of array has null char
   a[j] = '\0';
   d[k] = '\0';
	 p[l] = '\0';
	 w[m] = '\0';
 }
