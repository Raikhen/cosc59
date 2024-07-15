grammar Expr;

@header {
    import java.util.HashSet;
}

@members {
    public HashSet<String> ids = new HashSet<String>();
    public String toPrint = "";
}

start   : list EOF {
    String s = ids.toString();
    s = s.substring(1, s.length() - 1);
    toPrint += "Symbol Table: " + s + ".";
};

list    : expr ';' { toPrint += ";"; } list
        |
        ;

line    : expr ';' { toPrint += ";"; } EOF;

expr    : term terms;

terms   : '+' term { toPrint += "+ "; } terms
        | '-' term { toPrint += "- "; } terms
        |
        ;

term    : factor factors;

factors : '*' factor { toPrint += "* "; } factors
        | '/' factor { toPrint += "/ "; } factors
        | MOD factor { toPrint += "MOD "; } factors
        |
        ;

factor  : '(' expr ')'
        | id = ID { toPrint += $id.text + " "; ids.add($id.text); }
        | num = NUM { toPrint += $num.text + " "; }
        ;

MOD : 'MOD';
NUM : [0-9]+;
ID  : [a-zA-Z] ([a-zA-Z] | [0-9])*;

// Ignore all whitespace
WS  : (' ' | '\t' | '\n' | '\r') -> skip;