// Generated from src/main/java/Zeon.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ZeonParser}.
 */
public interface ZeonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ZeonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ZeonParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ZeonParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ZeonParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ZeonParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclStat(ZeonParser.DeclStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclStat(ZeonParser.DeclStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(ZeonParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(ZeonParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(ZeonParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(ZeonParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReadStat(ZeonParser.ReadStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReadStat(ZeonParser.ReadStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(ZeonParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(ZeonParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStat(ZeonParser.IfElseStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElseStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStat(ZeonParser.IfElseStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(ZeonParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(ZeonParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(ZeonParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link ZeonParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(ZeonParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(ZeonParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(ZeonParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(ZeonParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(ZeonParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(ZeonParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(ZeonParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#functype}.
	 * @param ctx the parse tree
	 */
	void enterFunctype(ZeonParser.FunctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#functype}.
	 * @param ctx the parse tree
	 */
	void exitFunctype(ZeonParser.FunctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#blockifelse}.
	 * @param ctx the parse tree
	 */
	void enterBlockifelse(ZeonParser.BlockifelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#blockifelse}.
	 * @param ctx the parse tree
	 */
	void exitBlockifelse(ZeonParser.BlockifelseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#blockif}.
	 * @param ctx the parse tree
	 */
	void enterBlockif(ZeonParser.BlockifContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#blockif}.
	 * @param ctx the parse tree
	 */
	void exitBlockif(ZeonParser.BlockifContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#blockelse}.
	 * @param ctx the parse tree
	 */
	void enterBlockelse(ZeonParser.BlockelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#blockelse}.
	 * @param ctx the parse tree
	 */
	void exitBlockelse(ZeonParser.BlockelseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#blockwhile}.
	 * @param ctx the parse tree
	 */
	void enterBlockwhile(ZeonParser.BlockwhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#blockwhile}.
	 * @param ctx the parse tree
	 */
	void exitBlockwhile(ZeonParser.BlockwhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(ZeonParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(ZeonParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#orCond}.
	 * @param ctx the parse tree
	 */
	void enterOrCond(ZeonParser.OrCondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#orCond}.
	 * @param ctx the parse tree
	 */
	void exitOrCond(ZeonParser.OrCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#andCond}.
	 * @param ctx the parse tree
	 */
	void enterAndCond(ZeonParser.AndCondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#andCond}.
	 * @param ctx the parse tree
	 */
	void exitAndCond(ZeonParser.AndCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#atomCond}.
	 * @param ctx the parse tree
	 */
	void enterAtomCond(ZeonParser.AtomCondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#atomCond}.
	 * @param ctx the parse tree
	 */
	void exitAtomCond(ZeonParser.AtomCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(ZeonParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(ZeonParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ZeonParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ZeonParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ZeonParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ZeonParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(ZeonParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(ZeonParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ZeonParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ZeonParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(ZeonParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(ZeonParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(ZeonParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(ZeonParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallFunc}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCallFunc(ZeonParser.CallFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallFunc}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCallFunc(ZeonParser.CallFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Real}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReal(ZeonParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Real}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReal(ZeonParser.RealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(ZeonParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMinus}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(ZeonParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Id}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(ZeonParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Id}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(ZeonParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(ZeonParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(ZeonParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultDiv(ZeonParser.MultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultDiv}
	 * labeled alternative in {@link ZeonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultDiv(ZeonParser.MultDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZeonParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(ZeonParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZeonParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(ZeonParser.ArgsContext ctx);
}