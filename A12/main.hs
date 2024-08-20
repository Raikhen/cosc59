-- Skip every n-th element
skipEveryN :: Integer -> [Integer] -> [Integer]
skipEveryN n list = skipHelper n list 1
  where
    skipHelper :: Integer -> [Integer] -> Integer -> [Integer]
    skipHelper _ [] _ =  []
    skipHelper n (x : xs) k =
      if n == k then
        skipHelper n xs 1
      else
        x : skipHelper n xs (k + 1)

-- Running sum in O(n)
runningSum :: [Integer] -> [Integer]
runningSum xs = helper xs 0
  where
    helper [] acc = []
    helper (x : xs) acc = (x + acc) : helper xs (x + acc)

-- Moessner Powers
moessnerPowers :: Integer -> [Integer]
moessnerPowers = skipAndRun [1 ..]
  where
    skipAndRun :: [Integer] -> Integer -> [Integer]
    skipAndRun list 1 = list
    skipAndRun list n = skipAndRun (runningSum (skipEveryN n list)) (n - 1)

-- Skip the elements on triangular indices
skipGrowing :: [Integer] -> [Integer]
skipGrowing list = helper list 0 1
  where
    helper :: [Integer] -> Integer -> Integer -> [Integer]
    helper [] _ _ = []
    helper (x : xs) 0 k = helper xs k (k + 1)
    helper (x : xs) n k = x : helper xs (n - 1) k

-- Moessner Factorial
moessnerFactorial :: [Integer]
moessnerFactorial = map (head . row) [0 ..]
  where
    row :: Integer -> [Integer]
    row 0 = [1 ..]
    row n = runningSum (skipGrowing (row (n - 1)))