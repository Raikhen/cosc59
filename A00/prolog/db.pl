% Author - Sebastian Frazier & Dylan Fridman
% CS59 A00 - Lang Comp - Prolog Module
% This program defines an implementation of distinct prime partitions in Prolog

% Define primes with following rules
isPrime(N) :-
  N < 2,
  !,
  fail.
isPrime(2) :-
  !.
isPrime(N) :-
  N > 2,
  \+ hasFactor(N, 2).

% Define if a number is divisible by others
hasFactor(N, X) :-
  X * X =< N,
  (N mod X =:= 0;
   X2 is X + 1,
   hasFactor(N, X2)).

% Generate a list of primes, L is a list to store
getPrimes(X, Y, L) :- getPrimes(X, Y, [], L). % Helper with new empty list
getPrimes(X, Y, L, Lp) :-
  (X > Y ->
      Lp = L; % If X is greater than Y, set Lp to our empty List
   Yp is Y - 1,
   (isPrime(Y) ->
     getPrimes(X, Yp, [Y | L], Lp); % If Y is prime, add it to the list
     getPrimes(X, Yp, L, Lp))).

% Add partitions for determining combinations
addPartition(P, [H | T]) :-
  addPartition(Pp, T),
  P is H + Pp. % Add new number to partition
addPartition(0, []). % Base case with empty list.

% Find all subsets of a list to assist our partitions
subset([], []). % Empty set has no partitions except itself
subset([H | T], [H | Tp]) :-
  subset(T, Tp). % Find partitions w/ head
subset([_ | T], Tp) :-
  subset(T, Tp). % Find partitions w/o head

% Create distinct prime partitions
getPrimePartitions(N) :-
  getPrimes(1, N, PL), % Get a list PL (Prime List) of all primes from 1 to N
  findall(L, (subset(PL, L), addPartition(P, L), P =:= N), Ls), % Get all possible partitions
  sort(Ls, SL), % Sort the list
  length(SL, NP), % Get number of partitions
  printPrimePartitions(SL, N, NP). % Print from the sorted list

% Print number of partitions
printPrimePartitions(PL, N, NP) :-
  format('~d has ~d prime partitions.~n', [N, NP]), % Print the number of partitions
  printPartitions(PL). % Print all partitions

% Print all our partitions in correct format
printPartitions([]).
printPartitions([H | T]) :-
printPartition(H), % Print one node (the head)
  nl,
  printPartitions(T). % Recall for tail.

% Print each partition
printPartition([H | T]) :-
  length(T, S), % Get current length of our tail
  (S =:= 0 ->
     format('~d', [H]); % If our tail is empty, just print the value
     format('~d + ', [H])), % Else, print value with a plus sign
  printPartition(T).
printPartition([]). % Base case