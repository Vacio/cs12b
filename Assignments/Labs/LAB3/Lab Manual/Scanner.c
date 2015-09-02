#include <stdio.h>
#include <stdlib.h>

int main() {
  int n, i; int x[3];
  //int x, y, z;
  printf("Enter three integers separated by commas, then press return: ");
  n = scanf(" %d %d %d", &x[0], &x[1], &x[2]);
  //printf("The integers entered were %d, %d, %d\n", x, y, z);
  printf("%d numbers were successfully read: ", n);
  for(i=0; i<n; i++) printf("%d ", x[i]);
  printf("\n");
  return EXIT_SUCCESS;
}
