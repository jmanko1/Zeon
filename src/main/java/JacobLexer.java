// Generated from C:/Users/Kuba/IdeaProjects/Compiler/src/main/resources/Jacob.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JacobLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		READ=1, PRINT=2, INTTYPE=3, REALTYPE=4, LONGREAL=5, LONGINT=6, IF=7, WHILE=8, 
		RETURN=9, REAL=10, INT=11, ID=12, SEMIC=13, ASSIGN=14, LBRAC=15, RBRAC=16, 
		LCLASP=17, RCLASP=18, ADD=19, SUB=20, MULT=21, DIV=22, EQ=23, NEQ=24, 
		GT=25, LT=26, GTE=27, LTE=28, WS=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"READ", "PRINT", "INTTYPE", "REALTYPE", "LONGREAL", "LONGINT", "IF", 
			"WHILE", "RETURN", "REAL", "INT", "ID", "SEMIC", "ASSIGN", "LBRAC", "RBRAC", 
			"LCLASP", "RCLASP", "ADD", "SUB", "MULT", "DIV", "EQ", "NEQ", "GT", "LT", 
			"GTE", "LTE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'read'", "'print'", "'int'", "'real'", "'lreal'", "'lint'", "'if'", 
			"'while'", "'return'", null, null, null, "';'", "'='", "'('", "')'", 
			"'{'", "'}'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'>'", "'<'", 
			"'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "READ", "PRINT", "INTTYPE", "REALTYPE", "LONGREAL", "LONGINT", 
			"IF", "WHILE", "RETURN", "REAL", "INT", "ID", "SEMIC", "ASSIGN", "LBRAC", 
			"RBRAC", "LCLASP", "RCLASP", "ADD", "SUB", "MULT", "DIV", "EQ", "NEQ", 
			"GT", "LT", "GTE", "LTE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public JacobLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Jacob.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001d\u00aa\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0004\tl\b\t\u000b\t\f\tm\u0001\t\u0001\t\u0004\tr"+
		"\b\t\u000b\t\f\ts\u0001\n\u0004\nw\b\n\u000b\n\f\nx\u0001\u000b\u0004"+
		"\u000b|\b\u000b\u000b\u000b\f\u000b}\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0004\u001c\u00a5\b\u001c\u000b\u001c\f"+
		"\u001c\u00a6\u0001\u001c\u0001\u001c\u0000\u0000\u001d\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"5\u001b7\u001c9\u001d\u0001\u0000\u0003\u0001\u000009\u0002\u0000AZaz"+
		"\u0003\u0000\t\n\r\r  \u00ae\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000"+
		"\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0001;"+
		"\u0001\u0000\u0000\u0000\u0003@\u0001\u0000\u0000\u0000\u0005F\u0001\u0000"+
		"\u0000\u0000\u0007J\u0001\u0000\u0000\u0000\tO\u0001\u0000\u0000\u0000"+
		"\u000bU\u0001\u0000\u0000\u0000\rZ\u0001\u0000\u0000\u0000\u000f]\u0001"+
		"\u0000\u0000\u0000\u0011c\u0001\u0000\u0000\u0000\u0013k\u0001\u0000\u0000"+
		"\u0000\u0015v\u0001\u0000\u0000\u0000\u0017{\u0001\u0000\u0000\u0000\u0019"+
		"\u007f\u0001\u0000\u0000\u0000\u001b\u0081\u0001\u0000\u0000\u0000\u001d"+
		"\u0083\u0001\u0000\u0000\u0000\u001f\u0085\u0001\u0000\u0000\u0000!\u0087"+
		"\u0001\u0000\u0000\u0000#\u0089\u0001\u0000\u0000\u0000%\u008b\u0001\u0000"+
		"\u0000\u0000\'\u008d\u0001\u0000\u0000\u0000)\u008f\u0001\u0000\u0000"+
		"\u0000+\u0091\u0001\u0000\u0000\u0000-\u0093\u0001\u0000\u0000\u0000/"+
		"\u0096\u0001\u0000\u0000\u00001\u0099\u0001\u0000\u0000\u00003\u009b\u0001"+
		"\u0000\u0000\u00005\u009d\u0001\u0000\u0000\u00007\u00a0\u0001\u0000\u0000"+
		"\u00009\u00a4\u0001\u0000\u0000\u0000;<\u0005r\u0000\u0000<=\u0005e\u0000"+
		"\u0000=>\u0005a\u0000\u0000>?\u0005d\u0000\u0000?\u0002\u0001\u0000\u0000"+
		"\u0000@A\u0005p\u0000\u0000AB\u0005r\u0000\u0000BC\u0005i\u0000\u0000"+
		"CD\u0005n\u0000\u0000DE\u0005t\u0000\u0000E\u0004\u0001\u0000\u0000\u0000"+
		"FG\u0005i\u0000\u0000GH\u0005n\u0000\u0000HI\u0005t\u0000\u0000I\u0006"+
		"\u0001\u0000\u0000\u0000JK\u0005r\u0000\u0000KL\u0005e\u0000\u0000LM\u0005"+
		"a\u0000\u0000MN\u0005l\u0000\u0000N\b\u0001\u0000\u0000\u0000OP\u0005"+
		"l\u0000\u0000PQ\u0005r\u0000\u0000QR\u0005e\u0000\u0000RS\u0005a\u0000"+
		"\u0000ST\u0005l\u0000\u0000T\n\u0001\u0000\u0000\u0000UV\u0005l\u0000"+
		"\u0000VW\u0005i\u0000\u0000WX\u0005n\u0000\u0000XY\u0005t\u0000\u0000"+
		"Y\f\u0001\u0000\u0000\u0000Z[\u0005i\u0000\u0000[\\\u0005f\u0000\u0000"+
		"\\\u000e\u0001\u0000\u0000\u0000]^\u0005w\u0000\u0000^_\u0005h\u0000\u0000"+
		"_`\u0005i\u0000\u0000`a\u0005l\u0000\u0000ab\u0005e\u0000\u0000b\u0010"+
		"\u0001\u0000\u0000\u0000cd\u0005r\u0000\u0000de\u0005e\u0000\u0000ef\u0005"+
		"t\u0000\u0000fg\u0005u\u0000\u0000gh\u0005r\u0000\u0000hi\u0005n\u0000"+
		"\u0000i\u0012\u0001\u0000\u0000\u0000jl\u0007\u0000\u0000\u0000kj\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000"+
		"mn\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0005.\u0000\u0000"+
		"pr\u0007\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\u0014\u0001"+
		"\u0000\u0000\u0000uw\u0007\u0000\u0000\u0000vu\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000y\u0016\u0001\u0000\u0000\u0000z|\u0007\u0001\u0000\u0000{z\u0001"+
		"\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000"+
		"}~\u0001\u0000\u0000\u0000~\u0018\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0005;\u0000\u0000\u0080\u001a\u0001\u0000\u0000\u0000\u0081\u0082\u0005"+
		"=\u0000\u0000\u0082\u001c\u0001\u0000\u0000\u0000\u0083\u0084\u0005(\u0000"+
		"\u0000\u0084\u001e\u0001\u0000\u0000\u0000\u0085\u0086\u0005)\u0000\u0000"+
		"\u0086 \u0001\u0000\u0000\u0000\u0087\u0088\u0005{\u0000\u0000\u0088\""+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0005}\u0000\u0000\u008a$\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0005+\u0000\u0000\u008c&\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0005-\u0000\u0000\u008e(\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0005*\u0000\u0000\u0090*\u0001\u0000\u0000\u0000\u0091\u0092\u0005/"+
		"\u0000\u0000\u0092,\u0001\u0000\u0000\u0000\u0093\u0094\u0005=\u0000\u0000"+
		"\u0094\u0095\u0005=\u0000\u0000\u0095.\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0005!\u0000\u0000\u0097\u0098\u0005=\u0000\u0000\u00980\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0005>\u0000\u0000\u009a2\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0005<\u0000\u0000\u009c4\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0005>\u0000\u0000\u009e\u009f\u0005=\u0000\u0000\u009f6\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0005<\u0000\u0000\u00a1\u00a2\u0005=\u0000\u0000"+
		"\u00a28\u0001\u0000\u0000\u0000\u00a3\u00a5\u0007\u0002\u0000\u0000\u00a4"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0006\u001c\u0000\u0000\u00a9"+
		":\u0001\u0000\u0000\u0000\u0006\u0000msx}\u00a6\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}