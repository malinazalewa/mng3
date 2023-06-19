grammar Calculator;

expression: multiplyingExpression ((PLUS | MINUS) multiplyingExpression)*;
multiplyingExpression: powExpression ((TIMES | DIV) powExpression)*;
powExpression: signedAtom (POW signedAtom)*;
signedAtom: (PLUS | MINUS)? (atom | func) ;
atom: INTEGER | LPAREN expression RPAREN;
func: funcname LPAREN expression (COMMA expression)* RPAREN;
funcname: SQRT;

INTEGER: [0-9]+;
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';
POW: '^';
SQRT: 'sqrt';
LPAREN: '(';
RPAREN: ')';
COMMA: ',';
WS: [ \t\r\n]+ -> skip;
