grammar HalcyonQueryLanguage;

options {
    language = Java;
}

halqlEntryPoint :   halqlStatement ';' ;

halqlStatement  
    :   halqlDmlStatement
    |   halqlDdlStatement
    |   halqlDqlStatement
    ;

halqlDmlStatement
    :   insertRowStatement
    ;

halqlDdlStatement:
    ;

halqlDqlStatement
    :   selectTableStatement
    ;

insertRowStatement
    :   KWORD_INSERT KWORD_INTO tableIdentifier KWORD_VALUES '(' values ')' 
    ;

selectTableStatement
    :   KWORD_SELECT ASTERISK KWORD_FROM tableIdentifier
    ;

tableIdentifier
    :   name=identifier
    ;

identifier
    :   IDENTIFIER '.' IDENTIFIER
    |   IDENTIFIER
    ;

values returns [ List<String> valueList ]
    @init {
        $valueList = new ArrayList<String>();
    }
    :   a=constValue { $valueList.add($a.value); } (',' b=constValue { $valueList.add($b.value); })*
    ;

constValue returns [String value]
    :   NUMBER { $value = $NUMBER.text; }
    |   QUOTED { $value = $QUOTED.text; }
    ;

KWORD_INSERT  :   I N S E R T ;
KWORD_NEW     :   N E W ;
KWORD_SELECT  :   S E L E C T ;

KWORD_FROM  :   F R O M ;
KWORD_INTO  :   I N T O ;
KWORD_VALUES:   V A L U E S ;

fragment A: ('a'|'A');
fragment B: ('b'|'B');
fragment C: ('c'|'C');
fragment D: ('d'|'D');
fragment E: ('e'|'E');
fragment F: ('f'|'F');
fragment G: ('g'|'G');
fragment H: ('h'|'H');
fragment I: ('i'|'I');
fragment J: ('j'|'J');
fragment K: ('k'|'K');
fragment L: ('l'|'L');
fragment M: ('m'|'M');
fragment N: ('n'|'N');
fragment O: ('o'|'O');
fragment P: ('p'|'P');
fragment Q: ('q'|'Q');
fragment R: ('r'|'R');
fragment S: ('s'|'S');
fragment T: ('t'|'T');
fragment U: ('u'|'U');
fragment V: ('v'|'V');
fragment W: ('w'|'W');
fragment X: ('x'|'X');
fragment Y: ('y'|'Y');
fragment Z: ('z'|'Z');

Q_MARK      :   '?' ;
ASTERISK    :   '*' ;

IDENTIFIER  :   (LETTER | '_') (LETTER | DIGIT | '_')* ;

QUOTED      :   '"' ( ~('"'|'\\') | ('\\' .) )* '"';

NUMBER
    :   ('-' | '+')? INTEGER
    |   ('-' | '+')? FLOAT
    ;
FLOAT
    :   DIGIT+ '.' DIGIT*
    |   '.' DIGIT+
    ;
INTEGER : DIGIT+ ;


fragment LETTER     :   [a-zA-Z] ;
fragment DIGIT      :   [0-9];

WS  :   [ \t\r\n]+ -> skip ;
