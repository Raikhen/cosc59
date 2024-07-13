grammar passage;

s: b r t; // Full passage

t: (' (' N ')')?;
l: D | D '-' D;
v: l (',' l)*;
c: D;
x: c | (c ':' v);
r: (x (';' x)*)?;
b: (O ' ')? N;

O: [0-9];
N: [a-zA-Z]+;
D: [0-9]+;