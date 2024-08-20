-- Mergesort
mergesort :: [Integer] -> [Integer]
mergesort [] = []
mergesort [x] = [x]
mergesort [x, y] = if x > y then [y, x] else [x, y]
mergesort list = merge (mergesort first) (mergesort second)
  where
    m  = div (length list) 2
    n = length list - m
    first = take m list
    second = take n (drop m list)

    -- Merge procedure
    merge xs [] = xs
    merge [] ys = ys
    merge (x : xs) (y : ys) =
      if x < y then
        x : merge xs (y : ys)
      else
        y : merge (x : xs) ys

selection :: [Integer] -> Integer
selection list =
  if length list > 5 then
    selection (map pickMiddle (intoChunksOfFive list))
  else
    pickMiddle list
  where
    pickMiddle xs = mergesort xs !! div (length xs ) 2
    intoChunksOfFive xs =
      if length xs <= 5 then
        [xs]
      else
        take 5 xs : intoChunksOfFive (drop 5 xs)

-- Quicksort
quicksort :: [Integer] -> [Integer]
quicksort [] = []
quicksort list = helper list (pivot list)
  where
    -- Picks the best pivot of given a list
    pivot ys =
      if length ys > 5 then
        pivot (map pickMiddle (intoChunksOfFive ys))
      else
        pickMiddle ys

    -- Picks the middle element of a short list
    pickMiddle xs = mergesort xs !! div (length xs ) 2

    -- Splits a list into chunks of five elements
    intoChunksOfFive xs =
      if length xs <= 5 then
        [xs]
      else
        take 5 xs : intoChunksOfFive (drop 5 xs)

    small = quicksort [e | e <- list, e < pivot list]
    equal = [e | e <- list, e == pivot list]
    big = quicksort [e | e <- list, e > pivot list]
    helper list pivot = small ++ equal ++ big

-- Translate expression to reverse polish notation
infix2rpn :: String -> String
infix2rpn input = parseTerms (map parseFactors metaList)
  where
    metaList = map intoFactors (intoTerms input)

    parseFactors [] = ""
    parseFactors [x] = x
    parseFactors (x : xs) = x ++ " " ++ parseFactors xs ++ " *"

    parseTerms [] = ""
    parseTerms [x] = x
    parseTerms (x : xs) = x ++ " " ++ parseTerms xs ++ " +"

    intoTerms str = intoTermsHelper str ""
    intoTermsHelper "" term = [term]
    intoTermsHelper ('+' : xs) term = term : intoTermsHelper xs ""
    intoTermsHelper (' ' : xs) term = intoTermsHelper xs term
    intoTermsHelper (x : xs) term = intoTermsHelper xs (x : term)

    intoFactors str = intoFactorsHelper str ""
    intoFactorsHelper "" term = [term]
    intoFactorsHelper ('*' : xs) term = term : intoFactorsHelper xs ""
    intoFactorsHelper (' ' : xs) term = intoFactorsHelper xs term
    intoFactorsHelper (x : xs) term = intoFactorsHelper xs (x : term)

-- Evaluate an expression in reverse polish notation
evalrpn :: String -> Int
evalrpn str = fst (evalWithLeftover (words str))
  where
    evalWithLeftover [x] = (read x, [])
    evalWithLeftover xs
      | last xs == "+" =
        let prev = evalWithLeftover (init xs)
        in (fst prev + fst (evalWithLeftover (snd prev)), snd (evalWithLeftover (snd prev)))
      | last xs == "*" = 
        let prev = evalWithLeftover (init xs)
        in (fst prev * fst (evalWithLeftover (snd prev)), snd (evalWithLeftover (snd prev)))
      | otherwise = (read (last xs), init xs)