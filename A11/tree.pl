%%%%%%%%%%%%%%%%%%%%%%%%%%
% tree.pl
% https://gfx.cse.taylor.edu/courses/cos382/assignments/11_Paradigm_LogicProlog
% The goal of this assignment is to write a collection of Prolog rules
% to represent and manipulate binary trees.
%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%
% Starter code

% binary_tree(Tree)
% - Tree is a binary tree.

binary_tree(void).
binary_tree(tree(_, Left, Right)) :-
        binary_tree(Left),
        binary_tree(Right).

% tree_member(Tree, Element)
% - Element is an element of the binary tree Tree.

tree_member(tree(X, _, _), X).
tree_member(tree(_, Left, _), X)  :- tree_member(Left, X).
tree_member(tree(_, _, Right), X) :- tree_member(Right, X).

% preorder(Tree, Pre)
% - Pre is a list of elements of Tree accumulated during a preorder traversal.

preorder(tree(X, L, R), Xs) :-
        preorder(L, Ls),
        preorder(R, Rs),
        append([X|Ls], Rs, Xs).
preorder(void, []).

%%%%%%%%%%%%%%%%%%%%%%%%%%
% Sample trees

%
%    tree1       tree2         tree3
%
%      1           4             1
%     / \         / \           / \
%    2   3       5   6         2   3
%                             / \
%                            5   6
%                               /
%                              7
%

tree1(tree(1,tree(2,void,void),tree(3,void,void))).
tree2(tree(4,tree(5,void,void),tree(6,void,void))).
tree3(
        tree(   1,
                tree(   2,
                        tree(5,void,void),
                        tree(   6,
                                tree(7,void,void),
                                void
                        )
                ),
                tree(3,void,void)
        )
).

%%%%%%%%%%%%%%%%%%%%%%%%%%
% Place your code here

% inorder/2

inorder(void, []).

inorder(tree(X, L, R), Xs) :-
        inorder(L, Ls),
        inorder(R, Rs),
        append(Ls, [X | Rs], Xs).

% subtree/2

subtree(T, T) :- binary_tree(T).

subtree(tree(_, L, R), T) :-
        subtree(L, T),
        binary_tree(R).

subtree(tree(_, L, R), T) :-
        subtree(R, T),
        binary_tree(L).

% sumtree/2

sumtree(void, 0).

sumtree(tree(X, L, R), S) :-
        sumtree(L, N),
        sumtree(R, M),
        S is X + M + N.

% ordered/1

% I'm quite confused as to why this predicate was called ordered
% and not something like alldistinct or noreps...

not_in(_, void).

not_in(X, tree(Y, L, R)) :-
        \+ X = Y,
        not_in(X, L),
        not_in(X, R).

disjoint(void, _).

disjoint(tree(X, L, R), T) :-
        not_in(X, T),
        disjoint(L, T),
        disjoint(R, T).

ordered(void).

ordered(tree(X, L, R)) :-
        not_in(X, L),
        not_in(X, R),
        ordered(L),
        ordered(R),
        disjoint(L, R).

% substitute/4

substitute(void, _, void, _).

substitute(tree(X, LX, RX), X, tree(Y, LY, RY), Y) :-
        substitute(LX, X, LY, Y),
        substitute(RX, X, RY, Y).

substitute(tree(Z, L1, R1), X, tree(Z, L2, R2), Y) :-
        substitute(L1, X, L2, Y),
        substitute(R1, X, R2, Y).

% pathto

pathto(tree(N, L, R), N, [N]) :-
        binary_tree(L),
        binary_tree(R).

pathto(tree(_, L, R), N, [left | T]) :-
        pathto(L, N, T),
        binary_tree(R).

pathto(tree(_, L, R), N, [right | T]) :-
        pathto(R, N, T),
        binary_tree(L).

% Also, why are some of the predicates written likethis and some like_this?

% Additional test data
tree4(tree(8, T2, T3)) :-
        tree2(T2),
        tree3(T3).