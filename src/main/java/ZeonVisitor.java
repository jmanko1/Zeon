// Generated from C:/Users/Kuba/IdeaProjects/Compiler/src/main/java/Zeon.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ZeonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ZeonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ZeonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ZeonParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ZeonParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclStat(ZeonParser.DeclStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(ZeonParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(ZeonParser.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStat(ZeonParser.ReadStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(ZeonParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStat(ZeonParser.IfElseStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(ZeonParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(ZeonParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(ZeonParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(ZeonParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(ZeonParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#functype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctype(ZeonParser.FunctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#blockifelse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockifelse(ZeonParser.BlockifelseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#blockif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockif(ZeonParser.BlockifContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#blockelse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockelse(ZeonParser.BlockelseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#blockwhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockwhile(ZeonParser.BlockwhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(ZeonParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(ZeonParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ZeonParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ZeonParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(ZeonParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ZeonParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(ZeonParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(ZeonParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallFunc}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallFunc(ZeonParser.CallFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Real}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal(ZeonParser.RealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinus(ZeonParser.UnaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(ZeonParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(ZeonParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDiv(ZeonParser.MultDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZeonParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(ZeonParser.ArgsContext ctx);
}