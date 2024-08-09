set_prolog_flag(answer_write_options,[max_depth(0)]). % Show every element in a list

% inorder
inorder(void, L). % L = []
tree4(T), inorder(T, L). % L = [5, 4, 6, 8, 5, 2, 7, 6, 1, 3].
inorder(4, L). % false
inorder(tree(4, 4, 4), L). % false

% subtree
subtree(4, void). % false.
subtree(4, 4). % false.
tree4(T1), tree2(T2), subtree(T1, T2). % true.
tree4(T1), tree2(T2), subtree(T2, T1). % false.
subtree(tree(5, void, void), 5). % false
subtree(tree(5, void, void), tree(5, void, void)). % true
subtree(tree(5, tree(1, void, void), void), tree(1, void, void)). % true
subtree(tree(5, tree(1, void, void), void), tree(5, void, void)). % false

% sumtree
tree4(T), sumtree(T, S). % S = 47
sumtree(void, S). % S = 0
sumtree([1, 2, 3], _). % false
sumtree(tree(1, 2, void), _). % false
sumtree(tree(1, void, 3), _). % false

% ordered
tree1(T), ordered(T). % true
tree2(T), ordered(T). % true
tree3(T), ordered(T). % true
tree4(T), ordered(T). % false
ordered(void). % true
ordered(tree(1, 2, 3)). % false
ordered(4). % false
ordered(tree(1, tree(2, void, void), tree(2, void, void))). % false
ordered(tree(1, tree(2, void, void), tree(3, void, void))). % true
ordered(tree(1, tree(2, void, void), tree(3, tree(2, void, void), void))). % false

% substitute
tree1(T1), substitute(T1, 1, T2, 2).

%  Should be:
%
%      T2
%
%      2
%     / \
%    2   3
%


tree1(T1), substitute(T1, 2, T2, 1).

%  Should be:
%
%      T2
%
%      1
%     / \
%    1   3
%

tree1(T1), substitute(T1, 4, T2, 2).

%  Should be:
%
%      T2
%
%      1
%     / \
%    2   3
%

tree4(T1), substitute(T1, 4, void, 2). % false
tree4(T1), substitute(void, 4, T1, 2). % false

% pathto
tree1(T), pathto(T, 1, P). % P = [1],
tree1(T), pathto(T, 2, P). % P = [left, 2]
tree3(T), pathto(T, 6, P). % P = [left, right, 6]
tree3(T), pathto(T, X, [left, right, X]). % 6
tree4(T), pathto(T, 5, P). % [left, left, 5] and [right, left, left, 5]
tree1(T), pathto(T, 4, P). % false