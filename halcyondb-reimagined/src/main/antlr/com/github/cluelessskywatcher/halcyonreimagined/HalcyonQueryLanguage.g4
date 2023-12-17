grammar HalcyonQueryLanguage;

expression
    : halqlStatement 
    ;

halqlStatement
    : halqlDdlStatement
    | halqlDqlStatement
    | halqlDmlStatement
    ;

halqlDdlStatement
    : newTableStatement
// |   newDatabaseStatement
// |   deleteTableStatement
// |   deleteDatabaseStatement
// |   changeTableStatement
// |   clearTableStatement    
    ;

halqlDqlStatement
    :
    // fetchTableStatement
    ;

halqlDmlStatement
    : insertRowStatement
    ;

insertValue
    : INTEGER | STRING 
    ;

insertValues
    : insertValue (',' insertValue)*
    ;

insertRowStatement
    : DML_INSERT C_INTO validName ('(' IDENTIFIER (',' IDENTIFIER)* ')')?
      C_VALUES '(' insertValues ')'
    ;

newTableStatement
    : DDL_NEW C_TABLE validName (C_IF C_NOT C_EXISTS)?
      C_WITH columnList
    ;

validName
    : name=identifier
    ;

identifier
    : IDENTIFIER DOT IDENTIFIER
    | IDENTIFIER
    ;

columnList
    : '(' identifier (',' identifier)* ')'
    ;

DDL_NEW     :   N E W ;
DDL_DELETE  :   D E L E T E ;
DDL_CHANGE  :   C H A N G E ;
DDL_CLEAR   :   C L E A R ;

DQL_FETCH   :   F E T C H ;

DML_INSERT  :   I N S E R T ;

C_TABLE     :   T A B L E ;
C_DATABASE  :   D A T A B A S E ;
C_IF        :   I F ;
C_NOT       :   N O T ;
C_EXISTS    :   E X I S T S ;
C_WITH      :   W I T H ;
C_INTO      :   I N T O ;
C_VALUES    :   V A L U E S ;

IDENTIFIER  :   LETTER (LETTER | '_' | DIGIT)* ;

DOT         :   '.' ;

INTEGER     :   (DIGIT)+ ;
STRING      :   '\'' (~'\'' | '\'\'' | ~('\'' | '\r' | '\n'))* '\'';

fragment A:[aA];
fragment B:[bB];
fragment C:[cC];
fragment D:[dD];
fragment E:[eE];
fragment F:[fF];
fragment G:[gG];
fragment H:[hH];
fragment I:[iI];
fragment J:[jJ];
fragment K:[kK];
fragment L:[lL];
fragment M:[mM];
fragment N:[nN];
fragment O:[oO];
fragment P:[pP];
fragment Q:[qQ];
fragment R:[rR];
fragment S:[sS];
fragment T:[tT];
fragment U:[uU];
fragment V:[vV];
fragment W:[wW];
fragment X:[xX];
fragment Y:[yY];
fragment Z:[zZ];

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];