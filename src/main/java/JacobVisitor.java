// Generated from C:/Users/jakub/IdeaProjects/LLVMCompiler/src/main/resources/Jacob.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JacobParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JacobVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JacobParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(JacobParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link JacobParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JacobParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclStat(JacobParser.DeclStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(JacobParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(JacobParser.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStat(JacobParser.ReadStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(JacobParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(JacobParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(JacobParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(JacobParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link JacobParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(JacobParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link JacobParser#blockif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockif(JacobParser.BlockifContext ctx);
	/**
	 * Visit a parse tree produced by {@link JacobParser#blockwhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockwhile(JacobParser.BlockwhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link JacobParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(JacobParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link JacobParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(JacobParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link JacobParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(JacobParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link JacobParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(JacobParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link JacobParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(JacobParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link JacobParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(JacobParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(JacobParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(JacobParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallFunc}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallFunc(JacobParser.CallFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Real}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal(JacobParser.RealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(JacobParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(JacobParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDiv(JacobParser.MultDivContext ctx);
}