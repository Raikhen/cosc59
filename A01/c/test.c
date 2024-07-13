#include <stdio.h>
#include <string.h>
#define N 1000 // Maximum number of characters in reference

char reference[N];

int main(void) {
  FILE *fptr;

  printf("%s", "Hey!");

  // Open a file in read mode
  fptr = fopen("test.txt", "r");

  // Clear the content
  for (int i = 0; i < N; i++) reference[i] = '\0';

  char newChar[1];
  fgets(newChar, 1, fptr);
  reference[0] = newChar[0];

  /*
  // Read the content and print it
  while(fgets(newChar, 1, fptr)) {
    if (strlen(reference) == N) {
      printf("Reference is too long\n");
      break;
    }

    if (newChar[0] != '\n') {
      reference[strlen(reference)] = newChar[0];
    } else {
      break;
    }
  }
  */

  // Close the file
  fclose(fptr);

  // Print the content
  printf("\n");
  printf("%s", reference);
  printf("\n");
  printf("%d", strlen(reference));
  
}

/*
1 John 1:2-4
Ps 12:1,3-4
Rev 2:4;4:3-6 (NASB)
9 Matthew 77:190-314 (MyOwnVersion)
123 123 123
:::
ajsdfhjkadshfhkjadshjfhkjadsfhkjahksdfhjkfdhjasdhjadhfkjskhjdfsakhjdj
*/