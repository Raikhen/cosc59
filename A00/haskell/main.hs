import Data.List

-- Checks if n has divisors in 2..k
hasDivisors :: Integer -> Integer -> Bool
hasDivisors n k
  | k > 1   = mod n k == 0 || hasDivisors n (k - 1)
  | k <= 1  = False

-- Checks if n is a prime number
isPrime :: Integer -> Bool
isPrime n
  | n > 1   = not (hasDivisors n (n - 1))
  | n < 0   = isPrime (-n)
  | n == 1  = False
  | n == 0  = False

-- Get all primes in between m and n
getPrimes :: Integer -> Integer -> [Integer]
getPrimes m n
  | n < m                 = []
  | n >= m  && isPrime m  = m : getPrimes (m + 1) n
  | otherwise             = getPrimes (m + 1) n

-- Append a number to every partition
appendToPartitions :: Integer -> [[Integer]] -> [[Integer]]
appendToPartitions p = map (p :)

{-
DISCLAIMER:
I originally wrote appendToPartitions using pattern matching, as follows

appendToPartitions p [] = []
appendToPartitions p (y : ys) = (p : y) : appendToPartitions p ys

and the linter suggested rewriting it using the map function and using the eta
reduction from p ys = map (p :) ys.
-}

-- Get prime partitions that contain a given value p
getPrimePartitionsAux :: Integer -> Integer -> Integer -> [[Integer]]
getPrimePartitionsAux n lb p
  | p == n = [[p]]
  | p /= n = appendToPartitions p (getPrimePartitions (n - p) (p + 1))

-- Get prime partitions
getPrimePartitions :: Integer -> Integer -> [[Integer]]
getPrimePartitions n lb
  | n < 2 || null primes =  []
  | n >= 2 && not (null primes) = getPrimePartitionsAux n lb (head primes) ++ getPrimePartitions n (head primes + 1)
    where
      primes = getPrimes lb n

printPartitions :: Integer -> [[Integer]] -> IO ()
printPartitions n [] = do return ()
printPartitions n (y : ys) = do
  putStrLn (show n ++ " = " ++ sum ++ " (" ++ show (length y) ++ ")")
  printPartitions n ys
  where
    sum = intercalate " + " (map show y)

main :: IO ()
main = do
  printPartitions n partitions
  putStrLn (show n ++ " has " ++ show (length partitions) ++ " prime partitions")
  where
    n = 42
    partitions = getPrimePartitions n 2