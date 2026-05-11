int main() {
  int i = 0;
  int sum = 0;
  while (i < 5) {
    i++;
    if (i % 2 == 0) {
      sum += i;
      continue;
    }
    sum += 1;
  }
  return sum;
}

