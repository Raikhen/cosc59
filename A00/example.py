def get_primes(lower_bound, upper_bound):
  nums = [-1 for k in range(upper_bound + 1)]

  k = 2
  while k * k < upper_bound:
    if nums[k] == -1:
      nums[k] = 1

      for i in range(2, upper_bound // k + 1):
        if i * k <= upper_bound:
          nums[i * k] = 0
    k += 1

  def check(m):
    return nums[m] != 0 and m >= lower_bound

  return list(filter(check, range(2, upper_bound + 1)))

def get_prime_partitions(n, bound = 2):
  partitions = []
  primes = get_primes(bound, n)

  if n < 2:
    return []
  
  for p in primes:
    if n == p:
      partitions += [[p]]
    
    smaller_partitions = get_prime_partitions(n - p, p + 1)

    if len(smaller_partitions) > 0:
      for partition in smaller_partitions:
        partition.append(p)
      
      partitions += smaller_partitions
  
  return partitions

partitions = get_prime_partitions(12)
print(partitions)