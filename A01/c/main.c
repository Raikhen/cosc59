#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define M 1000000 // Maximum number of characters in reference

bool letter(char* ref, int start, int end) {
  // printf("letter(%d, %d)\n", start, end);
  
  if (end != start + 1) return false;
  if (start < 0) return false;

  bool isUppercase = ref[start] >= 'A' && ref[start] <= 'Z';
  bool isLowercase = (ref[start] >= 'a' && ref[start] <= 'z');
  return isUppercase || isLowercase;
}

bool digit(char* ref, int start, int end) {
  // printf("digit(%d, %d)\n", start, end);
  
  if (end != start + 1) return false;
  if (start < 0) return false;

  return ref[start] >= '0' && ref[start] <= '9';
}

bool N(char* ref, int start, int end) {
  // printf("N(%d, %d)\n", start, end);
  
  if (start < 0 || start >= end) return false;
  
  if (end == start + 1) {
    return letter(ref, start, end);
  }

  return letter(ref, start, start + 1) && N(ref, start + 1, end);
}

bool D(char* ref, int start, int end) {
  // printf("D(%d, %d)\n", start, end);
  
  if (start < 0 || start >= end) return false;
  
  if (end == start + 1) {
    return digit(ref, start, end);
  }

  return digit(ref, start, start + 1) && D(ref, start + 1, end);
}

bool O(char* ref, int start, int end) {
  // printf("O(%d, %d)\n", start, end);
  
  if (start < 0 || start > end) return false;

  return end == start || (digit(ref, start, start + 1) && ref[start + 1] == ' ');
}

bool T(char* ref, int start, int end) {
  // printf("T(%d, %d)\n", start, end);
  
  if (start < 0 || start > end) return false;
  if (end == start) return true;

  bool parens = ref[start + 1] == '(' && ref[end - 1] == ')';
  return ref[start] == ' ' && parens && N(ref, start + 2, end - 1);
}

bool L(char* ref, int start, int end) {
  // printf("L(%d, %d)\n", start, end);
  
  if (start < 0 || start >= end) return false;
  if (D(ref, start, end)) return true;

  for (int i = start; i < end; i++) {
    if (ref[i] == '-' && D(ref, start, i) && D(ref, i + 1, end)) {
      return true;
    }
  }

  return false;
}

bool V(char* ref, int start, int end) {
  // printf("V(%d, %d)\n", start, end);
  
  if (start < 0 || start >= end) return false;
  if (L(ref, start, end)) return true;

  for (int i = start; i < end; i++) {
    if (ref[i] == ',' && L(ref, start, i) && V(ref, i + 1, end)) {
      return true;
    }
  }

  return false;
}

bool C(char* ref, int start, int end) {
  // printf("C(%d, %d)\n", start, end);
  
  return D(ref, start, end);
}

bool X(char* ref, int start, int end) {
  // printf("X(%d, %d)\n", start, end);
  
  if (start < 0 || start >= end) return false;
  if (C(ref, start, end)) return true;

  for (int i = start; i < end; i++) {
    if (ref[i] == ':' && C(ref, start, i) && V(ref, i + 1, end)) {
      return true;
    }
  }

  return false;
}

bool R(char* ref, int start, int end) {
  // printf("R(%d, %d)\n", start, end);
  
  if (start < 0 || start > end) return false;
  if (X(ref, start, end) || start == end) return true;

  for (int i = start; i < end; i++) {
    if (ref[i] == ';' && X(ref, start, i) && R(ref, i + 1, end)) {
      return true;
    }
  }

  return false;
}

bool RS(char* ref, int start, int end) {
  if (start < 0 || start > end) return false;
  if (start == end) return true;
  return ref[start] == ' ' && R(ref, start + 1, end);
}

bool B(char* ref, int start, int end) {
  // printf("B(%d, %d)\n", start, end);

  if (start < 0 || start >= end) return false;

  for (int i = start; i < end; i++) {
    if (O(ref, start, i) && N(ref, i, end)) {
      return true;
    }
  }

  return false;
}

bool S(char* ref, int start, int end) {
  // printf("S(%d, %d)\n", start, end);

  if (start < 0 || start >= end) return false;

  for (int i = start; i <= end; i++) {
    for (int j = i; j <= end; j++) {
      if (B(ref, start, i) && RS(ref, i, j) && T(ref, j, end)) {
        return true;
      }
    }
  }

  return false;
}

bool checkReference(char *ref, size_t n) {
  return S(ref, 0, n);
}

void processReference(char *ref, size_t n) {
  bool isReferenceValid = checkReference(ref, n);
  
  if (isReferenceValid) {
    printf("%s\nValid\n\n", ref);
  } else {
    printf("%s\nInvalid\n\n", ref);
  }
}

int main(void) {
  FILE *file = fopen("../test.txt", "r");

  char *ref;
  size_t n = 0;
  int c;

  if (file == NULL) {
    printf("Could not open file\n");
    return 1; // Could not open file
  }

  ref = malloc(M);

  while ((c = fgetc(file)) != EOF) {
    if (c == '\n') {
      processReference(ref, n);

      // Clear reference
      for (int i = 0; i < n; i++) ref[i] = '\0';
      n = 0;
    } else {
      ref[n++] = (char) c;
    }
  }

  processReference(ref, n);
  return 0;
}