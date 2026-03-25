// Generated from C:/Users/Kuba/IdeaProjects/Compiler/src/main/resources/Jacob.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JacobParser}.
 */
public interface JacobListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JacobParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(JacobParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link JacobParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(JacobParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link JacobParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JacobParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JacobParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JacobParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclStat(JacobParser.DeclStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclStat(JacobParser.DeclStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(JacobParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(JacobParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(JacobParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(JacobParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReadStat(JacobParser.ReadStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReadStat(JacobParser.ReadStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(JacobParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(JacobParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(JacobParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(JacobParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(JacobParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(JacobParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(JacobParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link JacobParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(JacobParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link JacobParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(JacobParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link JacobParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(JacobParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link JacobParser#blockif}.
	 * @param ctx the parse tree
	 */
	void enterBlockif(JacobParser.BlockifContext ctx);
	/**
	 * Exit a parse tree produced by {@link JacobParser#blockif}.
	 * @param ctx the parse tree
	 */
	void exitBlockif(JacobParser.BlockifContext ctx);
	/**
	 * Enter a parse tree produced by {@link JacobParser#blockwhile}.
	 * @param ctx the parse tree
	 */
	void enterBlockwhile(JacobParser.BlockwhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link JacobParser#blockwhile}.
	 * @param ctx the parse tree
	 */
	void exitBlockwhile(JacobParser.BlockwhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link JacobParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(JacobParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link JacobParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(JacobParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link JacobParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(JacobParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link JacobParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(JacobParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link JacobParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(JacobParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link JacobParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(JacobParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link JacobParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JacobParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JacobParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JacobParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JacobParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(JacobParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link JacobParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(JacobParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link JacobParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(JacobParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link JacobParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(JacobParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(JacobParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(JacobParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(JacobParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(JacobParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallFunc}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCallFunc(JacobParser.CallFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallFunc}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCallFunc(JacobParser.CallFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Real}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReal(JacobParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Real}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReal(JacobParser.RealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Id}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(JacobParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(JacobParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(JacobParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(JacobParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultDiv(JacobParser.MultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link JacobParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultDiv(JacobParser.MultDivContext ctx);
}