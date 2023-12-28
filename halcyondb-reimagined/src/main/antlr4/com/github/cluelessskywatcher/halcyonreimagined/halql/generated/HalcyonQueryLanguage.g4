grammar HalcyonQueryLanguage;

options {
    language = Java;
}

@header {
import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import java.util.*;
}

@members {
    class FieldDef {
        public String fieldId;
        public DataType dataType;

        public FieldDef(String fieldName, DataType dataType) {
            this.fieldId = fieldName;
            this.dataType = dataType;
        }
    }
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

halqlDdlStatement
    :   createTableStatement
    ;

halqlDqlStatement
    :   selectTableStatement
    ;

insertRowStatement
    :   KWORD_INSERT KWORD_INTO tableIdentifier KWORD_VALUES '(' values ')' 
    ;

createTableStatement
    :   KWORD_CREATE KWORD_TABLE tableIdentifier KWORD_WITH '(' tableDefinition ')'
    ;

selectTableStatement
    :   KWORD_SELECT ASTERISK KWORD_FROM tableIdentifier KWORD_WITH '(' tableDefinition ')'
    ;

tableIdentifier
    :   identifier
    ;

fieldIdentifier returns [String fieldId]
    :   IDENTIFIER { $fieldId = $IDENTIFIER.text; }
    ;

identifier
    :   IDENTIFIER '.' IDENTIFIER
    |   IDENTIFIER
    ;

tableDefinition returns [ Map<String, DataType> tableDef ]
    @init {
        $tableDef = new LinkedHashMap<String, DataType>();
    }
    :   a=fieldDefinition { $tableDef.put($a.def.fieldId, $a.def.dataType); } 
        (',' b=fieldDefinition { $tableDef.put($b.def.fieldId, $b.def.dataType); })*
    ;

fieldDefinition returns [FieldDef def]
    :   a=fieldIdentifier b=dataType { $def = new FieldDef($a.fieldId, $b.dtType); }
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


dataType returns [DataType dtType]
    :   TYPE_INT    {$dtType = DataType.INTEGER; }
    |   TYPE_STRING {$dtType = DataType.STRING; }
    ;

TYPE_INT    :   I N T ;
TYPE_STRING :   S T R I N G ;

KWORD_INSERT  :   I N S E R T ;
KWORD_CREATE  :   C R E A T E ;
KWORD_SELECT  :   S E L E C T ;

KWORD_FROM  :   F R O M ;
KWORD_INTO  :   I N T O ;
KWORD_VALUES:   V A L U E S ;
KWORD_TABLE :   T A B L E ;
KWORD_WITH  :   W I T H ;

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
