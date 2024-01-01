// Generated from com/github/cluelessskywatcher/halcyonreimagined/halql/generated/HalcyonQueryLanguage.g4 by ANTLR 4.7.1
package com.github.cluelessskywatcher.halcyonreimagined.halql.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HalcyonQueryLanguageParser}.
 */
public interface HalcyonQueryLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#halqlEntryPoint}.
	 * @param ctx the parse tree
	 */
	void enterHalqlEntryPoint(HalcyonQueryLanguageParser.HalqlEntryPointContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#halqlEntryPoint}.
	 * @param ctx the parse tree
	 */
	void exitHalqlEntryPoint(HalcyonQueryLanguageParser.HalqlEntryPointContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#halqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterHalqlStatement(HalcyonQueryLanguageParser.HalqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#halqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitHalqlStatement(HalcyonQueryLanguageParser.HalqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#halqlDmlStatement}.
	 * @param ctx the parse tree
	 */
	void enterHalqlDmlStatement(HalcyonQueryLanguageParser.HalqlDmlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#halqlDmlStatement}.
	 * @param ctx the parse tree
	 */
	void exitHalqlDmlStatement(HalcyonQueryLanguageParser.HalqlDmlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#halqlDdlStatement}.
	 * @param ctx the parse tree
	 */
	void enterHalqlDdlStatement(HalcyonQueryLanguageParser.HalqlDdlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#halqlDdlStatement}.
	 * @param ctx the parse tree
	 */
	void exitHalqlDdlStatement(HalcyonQueryLanguageParser.HalqlDdlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#halqlDqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterHalqlDqlStatement(HalcyonQueryLanguageParser.HalqlDqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#halqlDqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitHalqlDqlStatement(HalcyonQueryLanguageParser.HalqlDqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#insertRowStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsertRowStatement(HalcyonQueryLanguageParser.InsertRowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#insertRowStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsertRowStatement(HalcyonQueryLanguageParser.InsertRowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#createTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableStatement(HalcyonQueryLanguageParser.CreateTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#createTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableStatement(HalcyonQueryLanguageParser.CreateTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#selectTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectTableStatement(HalcyonQueryLanguageParser.SelectTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#selectTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectTableStatement(HalcyonQueryLanguageParser.SelectTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTableIdentifier(HalcyonQueryLanguageParser.TableIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTableIdentifier(HalcyonQueryLanguageParser.TableIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#fieldIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldIdentifier(HalcyonQueryLanguageParser.FieldIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#fieldIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldIdentifier(HalcyonQueryLanguageParser.FieldIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(HalcyonQueryLanguageParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(HalcyonQueryLanguageParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#tableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTableDefinition(HalcyonQueryLanguageParser.TableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#tableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTableDefinition(HalcyonQueryLanguageParser.TableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#fieldDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFieldDefinition(HalcyonQueryLanguageParser.FieldDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#fieldDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFieldDefinition(HalcyonQueryLanguageParser.FieldDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(HalcyonQueryLanguageParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(HalcyonQueryLanguageParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#constValue}.
	 * @param ctx the parse tree
	 */
	void enterConstValue(HalcyonQueryLanguageParser.ConstValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#constValue}.
	 * @param ctx the parse tree
	 */
	void exitConstValue(HalcyonQueryLanguageParser.ConstValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HalcyonQueryLanguageParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(HalcyonQueryLanguageParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HalcyonQueryLanguageParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(HalcyonQueryLanguageParser.DataTypeContext ctx);
}