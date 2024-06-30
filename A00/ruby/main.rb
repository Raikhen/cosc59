def is_prime(n)
  if n < 2
    return false
  end

  for m in 2..(n - 1)
    if n % m == 0
      return false
    end
  end

  return true
end

def get_primes(lower_bound, upper_bound)
  list = []

  for p in lower_bound..upper_bound
    if is_prime(p)
      list.append(p)
    end
  end

  return list
end

def get_prime_partitions(n, bound = 2)
  partitions = []
  primes = get_primes(bound, n)

  if n < 2
    return []
  end

  for p in primes
    if n == p
      partitions += [[p]]
    end

    smaller_partitions = get_prime_partitions(n - p, p + 1)

    for partition in smaller_partitions
      partition.append(p)
    end

    partitions = partitions + smaller_partitions
  end

  return partitions
end

def print_prime_partitions(n)
  partitions = get_prime_partitions(n)

  if partitions.length == 0
    puts "There are no prime partitions of #{n}"
  else
    for partition in partitions
      puts "#{n} = #{partition.join(" + ")} (#{partition.length})"
    end

    puts "#{n} has #{partitions.length} prime partitions"
  end
end

n = -5
print_prime_partitions(n)
