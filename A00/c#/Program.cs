using System;

class Program {
  static bool IsPrime(int n) {
    if (n < 2) {
      return false;
    }

    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }

  static List<int> GetPrimes(int lowerBound, int upperBound) {
    List<int> primes = new List<int>();

    for (int i = lowerBound; i <= upperBound; i++) {
      if (IsPrime(i)) {
        primes.Add(i);
      }
    }

    return primes;
  }

  static List<List<int>> GetPrimePartitions(int n, int bound = 2) {
    List<List<int>> partitions = new List<List<int>>();
    List<int> primes = GetPrimes(bound, n);

    if (n < 2) {
      return partitions;
    }

    for (int i = 0; i < primes.Count; i++) {
      int p = primes[i];

      if (n == p) {
        partitions.Add(new List<int> { p });
      } else {
        List<List<int>> subPartitions = GetPrimePartitions(n - p, p + 1);

        if (subPartitions.Count > 0) {
          for (int j = 0; j < subPartitions.Count; j++) {
            List<int> partition = subPartitions[j];
            partition.Add(p);
          }

          partitions.AddRange(subPartitions);
        }
      }
    }

    return partitions;
  }

  static void PrintPrimePartitions(int n) {
    List<List<int>> partitions = GetPrimePartitions(n);

    for (int i = 0; i < partitions.Count; i++) {
      List<int> partition = partitions[i];
      Console.Write($"{n} = ");

      for (int j = 0; j < partition.Count; j++) {
        Console.Write(partition[j]);
        Console.Write(j < partition.Count - 1 ? " + " : "");
      }

      Console.Write($" ({partition.Count})\n");
    }

    Console.WriteLine($"{n} has {partitions.Count} prime partitions\n");
  }

  static void Main(string[] args) {
    PrintPrimePartitions(20);
  }
}