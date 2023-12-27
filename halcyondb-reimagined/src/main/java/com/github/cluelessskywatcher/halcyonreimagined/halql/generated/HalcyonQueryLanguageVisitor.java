// Generated from com/github/cluelessskywatcher/halcyonreimagined/halql/generated/HalcyonQueryLanguage.g4 by ANTLR 4.7.1
package com.github.cluelessskywatcher.halcyonreimagined.halql.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HalcyonQueryLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HalcyonQueryLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HalcyonQueryLanguageParser#halqlEntryPoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalqlEntryPoint(HalcyonQueryLanguageParser.HalqlEntryPointContext ctx);
	/**
	 * Visit a parse tree produced by {@link HalcyonQueryLanguageParser#halqlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalqlStatement(HalcyonQueryLanguageParser.HalqlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HalcyonQueryLanguageParser#halqlDmlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalqlDmlStatement(HalcyonQueryLanguageParser.HalqlDmlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HalcyonQueryLanguageParser#halqlDdlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalqlDdlStatement(HalcyonQueryLanguageParser.HalqlDdlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HalcyonQueryLanguageParser#halqlDqlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHalqlDqlStatement(HalcyonQueryLanguageParser.HalqlDqlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HalcyonQueryLanguageParser#insertRowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertRowStatement(HalcyonQueryLanguageParser.InsertRowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HalcyonQueryLanguageParser#selectTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectTableStatement(HalcyonQueryLanguageParser.SelectTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HalcyonQueryLanguageParser#tableIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableIdentifier(HalcyonQueryLanguageParser.TableIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link HalcyonQueryLanguageParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(HalcyonQueryLanguageParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link HalcyonQueryLanguageParser#values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(HalcyonQueryLanguageParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link HalcyonQueryLanguageParser#constValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstValue(HalcyonQueryLanguageParser.ConstValueContext ctx);
}