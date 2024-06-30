% Author - Sebastian Frazier & Dylan Fridman
% CS59 A00 - Lang Comp - Prolog Module
% This program defines an implementation of distinct prime partitions in Prolog

% Define primes with isPrime/1
isPrime(N) :- 
    N < 2, 
    false.
  isPrime(2). % 2 is prime
  isPrime(N) :-
    N > 2,
    hasFactor(N, N-1).
  
  % Define if a number is divisible by others
  hasFactor(N, X) :- 
    X > 1,
    mod(N, X) =\= 0, % 
    hasFactor(N, X-1). % Recurse for each X less than N
  hasFactor(_, X) :- 1 is X. % Every num is a factor of itself
  
  % Generate a list of primes, L is a list to store
  getPrimes(X, Y, L) :- getPrimes(X, Y, [], L). % Helper with new empty list
  getPrimes(X, Y, L, Lp) :-
    (X > Y -> % If X is greater than Y
        Lp = L; % Set Lp to our empty List
      Yp = Y-1, % Used to store Y and Y-1 simultaneously.
      (isPrime(Y) -> % If Y is prime, add it to the list
        getPrimes(X, Yp, [Y | L], Lp);
      getPrimes(X, Yp, L, Lp))).
  
  % Add partitions for determining combinations
  addPartition(P, L) :-
    L = [H | T], % List with head and Tail
    addPartition(Pp, T),
    P is H + Pp. % Add new number to partition
  addPartition(0, []). % Basecase with empty list.
  
  % Create distinct prime partitions
  getPrimePartitions(N) :- 
    getPrimes(1, N, PL), % Get a list PL (Prime List) of all primes from 1 to N
    getPrimePartitions(N, PL, [], L), % Recursively partition the primelist
    sort(L, SL), % sort the list into a list SL
    printPrimePartitions(N, SL).
  
  % Helper for getPrimePartitions, handles algorithm to recursively generate partitions
  getPrimePartitions(N, PL, L, Lp) :-
    (addPartition(P, L),
    P = N -> % If the sum created is equal to our target N, add it to our list
    Lp = L;
    
    PL = [H | T], % PrimeList is Head + Tail
    (getPrimePartitions(N, T, [H | L], Lp);
    getPrimePartitions(N, T, L, Lp))).
  
  % Print function
  printPrimePartitions(N, PL) :- 
    PL = [H | T],
    length(T, S), % Get length of our list, store it in variable S
    (S = 0 -> format('~d~n', H); % If list is empty, print our number.
    format('~d + ', H)), % Otherwise print number with plus sign
    printPrimePartitions(T), % Print the rest.
    length(PL, NP), % Get number of partitions
    format('~d has ~d prime partitions', [N, NP]).
  printPrimePartitions([]). % Basecase