; Checks if n has divisors in 2..k
(define (has-divisors n k)
  (if (= k 1)
    #f
    (if (= (remainder n k) 0)
      #t
      (has-divisors n (- k 1)))))

; Checks if n is prime
(define (is-prime n)
  (if (= n 1)
    #f
    (not (has-divisors n (- n 1)))))

; Returns a list of prime numbers between m and n, inclusive
(define (get-primes m n)
  (if (< n m)
    '()
    (if (is-prime m)
      (cons m (get-primes (+ m 1) n))
      (get-primes (+ m 1) n))))

; Appends p to every partition in a list of partitions
(define (append-to-partitions p partitions)
  (map (lambda (partition) (cons p partition)) partitions))

; Returns the prime partitions of n containing p where every element >= p
(define (get-prime-partitions-with-p n lower-bound p)
  (if (= p n)
    (cons (cons p '()) '())
    (append-to-partitions p (get-prime-partitions (- n p) (+ p 1)))))

; Returns the prime partitions of n where every element >= p
(define (get-prime-partitions n lower-bound)
  (if (or (< n 2) (= 0 (length (get-primes lower-bound n))))
    '()
    (append (get-prime-partitions-with-p n lower-bound (car (get-primes lower-bound n)))
      (get-prime-partitions n (+ 1 (car (get-primes lower-bound n)))))))

; Intercalates a list of strings with a separator
(define (intercalate s l)
  (if (= 1 (length l))
    (car l)
    (string-append (car l) s (intercalate s (cdr l)))))

; Converts a partition to a string
(define (partition-to-string n partition)
  (string-append
    (number->string n)
    " = "
    (intercalate " + " (map number->string partition))
    " ("
    (number->string (length partition))
    ")\n"))

; Converts a list of partitions to a string
(define (partitions-to-string n partitions)
  (if (null? partitions)
    ""
    (string-append
      (partition-to-string n (car partitions))
      (partitions-to-string n (cdr partitions)))))

(define N 20)

(display (partitions-to-string N (get-prime-partitions N 2)))
(display (string-append
  (number->string N)
  " has "
  (number->string (length (get-prime-partitions N 2)))
  " prime partitions"))

; wow, this language sucks...