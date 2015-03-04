package es.us.isa.aml.parsers.choco;

//// $ANTLR 2.7.7 (20060906): "ChocoAnasint.g" -> "ChocoAnasint.java"$
//package isa.us.es.aml.parsers.choco;
//
//import antlr.ASTFactory;
//import antlr.ASTPair;
//import antlr.NoViableAltException;
//import antlr.ParserSharedInputState;
//import antlr.RecognitionException;
//import antlr.TokenBuffer;
//import antlr.TokenStream;
//import antlr.TokenStreamException;
//import antlr.collections.AST;
//import antlr.collections.impl.ASTArray;
//import antlr.collections.impl.BitSet;
//
//public class ChocoAnasint extends antlr.LLkParser implements ChocoAnasintTokenTypes {
//
//    protected ChocoAnasint(TokenBuffer tokenBuf, int k) {
//        super(tokenBuf, k);
//        tokenNames = _tokenNames;
//        buildTokenTypeASTClassMap();
//        astFactory = new ASTFactory(getTokenTypeToASTClassMap());
//    }
//
//    public ChocoAnasint(TokenBuffer tokenBuf) {
//        this(tokenBuf, 2);
//    }
//
//    protected ChocoAnasint(TokenStream lexer, int k) {
//        super(lexer, k);
//        tokenNames = _tokenNames;
//        buildTokenTypeASTClassMap();
//        astFactory = new ASTFactory(getTokenTypeToASTClassMap());
//    }
//
//    public ChocoAnasint(TokenStream lexer) {
//        this(lexer, 2);
//    }
//
//    public ChocoAnasint(ParserSharedInputState state) {
//        super(state, 2);
//        tokenNames = _tokenNames;
//        buildTokenTypeASTClassMap();
//        astFactory = new ASTFactory(getTokenTypeToASTClassMap());
//    }
//
//    public final void expresion() throws RecognitionException, TokenStreamException {
//        returnAST = null;
//        ASTPair currentAST = new ASTPair();
//        AST expresion_AST = null;
//        try {      // for error handling
//            expresion_nivel_1();
//            astFactory.addASTChild(currentAST, returnAST);
//            {
//                _loop4:
//                do {
//                    if ((LA(1) == IFF || LA(1) == IMPLIES)) {
//                        {
//                            switch (LA(1)) {
//                                case IFF: {
//                                    AST tmp1_AST = null;
//                                    tmp1_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp1_AST);
//                                    match(IFF);
//                                    break;
//                                }
//                                case IMPLIES: {
//                                    AST tmp2_AST = null;
//                                    tmp2_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp2_AST);
//                                    match(IMPLIES);
//                                    break;
//                                }
//                                default: {
//                                    throw new NoViableAltException(LT(1), getFilename());
//                                }
//                            }
//                        }
//                        expresion_nivel_1();
//                        astFactory.addASTChild(currentAST, returnAST);
//                    } else {
//                        break _loop4;
//                    }
//                } while (true);
//            }
//            expresion_AST = (AST) currentAST.root;
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            recover(ex, _tokenSet_0);
//        }
//        returnAST = expresion_AST;
//    }
//
//    public final void expresion_nivel_1() throws RecognitionException, TokenStreamException {
//        returnAST = null;
//        ASTPair currentAST = new ASTPair();
//        AST expresion_nivel_1_AST = null;
//        try {      // for error handling
//            expresion_nivel_2();
//            astFactory.addASTChild(currentAST, returnAST);
//            {
//                _loop7:
//                do {
//                    if ((LA(1) == OR)) {
//                        AST tmp3_AST = null;
//                        tmp3_AST = astFactory.create(LT(1));
//                        astFactory.makeASTRoot(currentAST, tmp3_AST);
//                        match(OR);
//                        expresion_nivel_2();
//                        astFactory.addASTChild(currentAST, returnAST);
//                    } else {
//                        break _loop7;
//                    }
//                } while (true);
//            }
//            expresion_nivel_1_AST = (AST) currentAST.root;
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            recover(ex, _tokenSet_1);
//        }
//        returnAST = expresion_nivel_1_AST;
//    }
//
//    public final void expresion_nivel_2() throws RecognitionException, TokenStreamException {
//        returnAST = null;
//        ASTPair currentAST = new ASTPair();
//        AST expresion_nivel_2_AST = null;
//        try {      // for error handling
//            expresion_nivel_3();
//            astFactory.addASTChild(currentAST, returnAST);
//            {
//                _loop10:
//                do {
//                    if ((LA(1) == AND)) {
//                        AST tmp4_AST = null;
//                        tmp4_AST = astFactory.create(LT(1));
//                        astFactory.makeASTRoot(currentAST, tmp4_AST);
//                        match(AND);
//                        expresion_nivel_3();
//                        astFactory.addASTChild(currentAST, returnAST);
//                    } else {
//                        break _loop10;
//                    }
//                } while (true);
//            }
//            expresion_nivel_2_AST = (AST) currentAST.root;
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            recover(ex, _tokenSet_2);
//        }
//        returnAST = expresion_nivel_2_AST;
//    }
//
//    public final void expresion_nivel_3() throws RecognitionException, TokenStreamException {
//        returnAST = null;
//        ASTPair currentAST = new ASTPair();
//        AST expresion_nivel_3_AST = null;
//        try {      // for error handling
//            switch (LA(1)) {
//                case NOT: {
//                    {
//                        AST tmp5_AST = null;
//                        tmp5_AST = astFactory.create(LT(1));
//                        astFactory.makeASTRoot(currentAST, tmp5_AST);
//                        match(NOT);
//                        expresion_nivel_4();
//                        astFactory.addASTChild(currentAST, returnAST);
//                    }
//                    expresion_nivel_3_AST = (AST) currentAST.root;
//                    break;
//                }
//                case MENOS:
//                case IDENT:
//                case LIT_REAL:
//                case LIT_ENTERO:
//                case LIT_STRING:
//                case PARENTESIS_ABRIR: {
//                    expresion_nivel_4();
//                    astFactory.addASTChild(currentAST, returnAST);
//                    expresion_nivel_3_AST = (AST) currentAST.root;
//                    break;
//                }
//                default: {
//                    throw new NoViableAltException(LT(1), getFilename());
//                }
//            }
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            recover(ex, _tokenSet_3);
//        }
//        returnAST = expresion_nivel_3_AST;
//    }
//
//    public final void expresion_nivel_4() throws RecognitionException, TokenStreamException {
//        returnAST = null;
//        ASTPair currentAST = new ASTPair();
//        AST expresion_nivel_4_AST = null;
//        try {      // for error handling
//            expresion_nivel_5();
//            astFactory.addASTChild(currentAST, returnAST);
//            {
//                _loop16:
//                do {
//                    if (((LA(1) >= MAYOR && LA(1) <= DISTINTO))) {
//                        {
//                            switch (LA(1)) {
//                                case MAYOR: {
//                                    AST tmp6_AST = null;
//                                    tmp6_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp6_AST);
//                                    match(MAYOR);
//                                    break;
//                                }
//                                case MENOR: {
//                                    AST tmp7_AST = null;
//                                    tmp7_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp7_AST);
//                                    match(MENOR);
//                                    break;
//                                }
//                                case MAYOR_IGUAL: {
//                                    AST tmp8_AST = null;
//                                    tmp8_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp8_AST);
//                                    match(MAYOR_IGUAL);
//                                    break;
//                                }
//                                case MENOR_IGUAL: {
//                                    AST tmp9_AST = null;
//                                    tmp9_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp9_AST);
//                                    match(MENOR_IGUAL);
//                                    break;
//                                }
//                                case IGUAL: {
//                                    AST tmp10_AST = null;
//                                    tmp10_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp10_AST);
//                                    match(IGUAL);
//                                    break;
//                                }
//                                case DISTINTO: {
//                                    AST tmp11_AST = null;
//                                    tmp11_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp11_AST);
//                                    match(DISTINTO);
//                                    break;
//                                }
//                                default: {
//                                    throw new NoViableAltException(LT(1), getFilename());
//                                }
//                            }
//                        }
//                        expresion_nivel_5();
//                        astFactory.addASTChild(currentAST, returnAST);
//                    } else {
//                        break _loop16;
//                    }
//                } while (true);
//            }
//            expresion_nivel_4_AST = (AST) currentAST.root;
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            recover(ex, _tokenSet_3);
//        }
//        returnAST = expresion_nivel_4_AST;
//    }
//
//    public final void expresion_nivel_5() throws RecognitionException, TokenStreamException {
//        returnAST = null;
//        ASTPair currentAST = new ASTPair();
//        AST expresion_nivel_5_AST = null;
//        try {      // for error handling
//            exp_mult();
//            astFactory.addASTChild(currentAST, returnAST);
//            {
//                _loop20:
//                do {
//                    if ((LA(1) == MAS || LA(1) == MENOS)) {
//                        {
//                            switch (LA(1)) {
//                                case MAS: {
//                                    AST tmp12_AST = null;
//                                    tmp12_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp12_AST);
//                                    match(MAS);
//                                    break;
//                                }
//                                case MENOS: {
//                                    AST tmp13_AST = null;
//                                    tmp13_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp13_AST);
//                                    match(MENOS);
//                                    break;
//                                }
//                                default: {
//                                    throw new NoViableAltException(LT(1), getFilename());
//                                }
//                            }
//                        }
//                        exp_mult();
//                        astFactory.addASTChild(currentAST, returnAST);
//                    } else {
//                        break _loop20;
//                    }
//                } while (true);
//            }
//            expresion_nivel_5_AST = (AST) currentAST.root;
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            recover(ex, _tokenSet_4);
//        }
//        returnAST = expresion_nivel_5_AST;
//    }
//
//    public final void exp_mult() throws RecognitionException, TokenStreamException {
//        returnAST = null;
//        ASTPair currentAST = new ASTPair();
//        AST exp_mult_AST = null;
//        try {      // for error handling
//            expresion_unaria();
//            astFactory.addASTChild(currentAST, returnAST);
//            {
//                _loop24:
//                do {
//                    if (((LA(1) >= MULT && LA(1) <= POW))) {
//                        {
//                            switch (LA(1)) {
//                                case MULT: {
//                                    AST tmp14_AST = null;
//                                    tmp14_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp14_AST);
//                                    match(MULT);
//                                    break;
//                                }
//                                case DIV: {
//                                    AST tmp15_AST = null;
//                                    tmp15_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp15_AST);
//                                    match(DIV);
//                                    break;
//                                }
//                                case MOD: {
//                                    AST tmp16_AST = null;
//                                    tmp16_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp16_AST);
//                                    match(MOD);
//                                    break;
//                                }
//                                case POW: {
//                                    AST tmp17_AST = null;
//                                    tmp17_AST = astFactory.create(LT(1));
//                                    astFactory.makeASTRoot(currentAST, tmp17_AST);
//                                    match(POW);
//                                    break;
//                                }
//                                default: {
//                                    throw new NoViableAltException(LT(1), getFilename());
//                                }
//                            }
//                        }
//                        expresion_unaria();
//                        astFactory.addASTChild(currentAST, returnAST);
//                    } else {
//                        break _loop24;
//                    }
//                } while (true);
//            }
//            exp_mult_AST = (AST) currentAST.root;
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            recover(ex, _tokenSet_5);
//        }
//        returnAST = exp_mult_AST;
//    }
//
//    public final void expresion_unaria() throws RecognitionException, TokenStreamException {
//        returnAST = null;
//        ASTPair currentAST = new ASTPair();
//        AST expresion_unaria_AST = null;
//        AST j_AST = null;
//        AST e_AST = null;
//        try {      // for error handling
//            switch (LA(1)) {
//                case MENOS: {
//                    match(MENOS);
//                    exp_base();
//                    j_AST = (AST) returnAST;
//                    expresion_unaria_AST = (AST) currentAST.root;
//                    expresion_unaria_AST = (AST) astFactory.make((new ASTArray(2)).add(astFactory.create(MENOS_UNARIO, "Unary Minus")).add(j_AST));
//                    currentAST.root = expresion_unaria_AST;
//                    currentAST.child = expresion_unaria_AST != null && expresion_unaria_AST.getFirstChild() != null
//                            ? expresion_unaria_AST.getFirstChild() : expresion_unaria_AST;
//                    currentAST.advanceChildToEnd();
//                    break;
//                }
//                case IDENT:
//                case LIT_REAL:
//                case LIT_ENTERO:
//                case LIT_STRING:
//                case PARENTESIS_ABRIR: {
//                    exp_base();
//                    e_AST = (AST) returnAST;
//                    expresion_unaria_AST = (AST) currentAST.root;
//                    expresion_unaria_AST = e_AST;
//                    currentAST.root = expresion_unaria_AST;
//                    currentAST.child = expresion_unaria_AST != null && expresion_unaria_AST.getFirstChild() != null
//                            ? expresion_unaria_AST.getFirstChild() : expresion_unaria_AST;
//                    currentAST.advanceChildToEnd();
//                    break;
//                }
//                default: {
//                    throw new NoViableAltException(LT(1), getFilename());
//                }
//            }
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            recover(ex, _tokenSet_6);
//        }
//        returnAST = expresion_unaria_AST;
//    }
//
//    public final void exp_base() throws RecognitionException, TokenStreamException {
//        returnAST = null;
//        ASTPair currentAST = new ASTPair();
//        AST exp_base_AST = null;
//        try {      // for error handling
//            switch (LA(1)) {
//                case IDENT: {
//                    AST tmp19_AST = null;
//                    tmp19_AST = astFactory.create(LT(1));
//                    astFactory.addASTChild(currentAST, tmp19_AST);
//                    match(IDENT);
//                    exp_base_AST = (AST) currentAST.root;
//                    break;
//                }
//                case LIT_REAL: {
//                    AST tmp20_AST = null;
//                    tmp20_AST = astFactory.create(LT(1));
//                    astFactory.addASTChild(currentAST, tmp20_AST);
//                    match(LIT_REAL);
//                    exp_base_AST = (AST) currentAST.root;
//                    break;
//                }
//                case LIT_ENTERO: {
//                    AST tmp21_AST = null;
//                    tmp21_AST = astFactory.create(LT(1));
//                    astFactory.addASTChild(currentAST, tmp21_AST);
//                    match(LIT_ENTERO);
//                    exp_base_AST = (AST) currentAST.root;
//                    break;
//                }
//                case LIT_STRING: {
//                    AST tmp22_AST = null;
//                    tmp22_AST = astFactory.create(LT(1));
//                    astFactory.addASTChild(currentAST, tmp22_AST);
//                    match(LIT_STRING);
//                    exp_base_AST = (AST) currentAST.root;
//                    break;
//                }
//                case PARENTESIS_ABRIR: {
//                    match(PARENTESIS_ABRIR);
//                    expresion();
//                    astFactory.addASTChild(currentAST, returnAST);
//                    match(PARENTESIS_CERRAR);
//                    exp_base_AST = (AST) currentAST.root;
//                    break;
//                }
//                default: {
//                    throw new NoViableAltException(LT(1), getFilename());
//                }
//            }
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            recover(ex, _tokenSet_6);
//        }
//        returnAST = exp_base_AST;
//    }
//    public static final String[] _tokenNames = {
//        "<0>",
//        "EOF",
//        "<2>",
//        "NULL_TREE_LOOKAHEAD",
//        "MENOS_UNARIO",
//        "IFF",
//        "IMPLIES",
//        "OR",
//        "AND",
//        "NOT",
//        "MAYOR",
//        "MENOR",
//        "MAYOR_IGUAL",
//        "MENOR_IGUAL",
//        "IGUAL",
//        "DISTINTO",
//        "MAS",
//        "MENOS",
//        "MULT",
//        "DIV",
//        "MOD",
//        "POW",
//        "IDENT",
//        "LIT_REAL",
//        "LIT_ENTERO",
//        "LIT_STRING",
//        "PARENTESIS_ABRIR",
//        "PARENTESIS_CERRAR"
//    };
//
//    protected void buildTokenTypeASTClassMap() {
//        tokenTypeToASTClassMap = null;
//    }
//
//    ;
//	private static final long[] mk_tokenSet_0() {
//        long[] data = {134217728L, 0L};
//        return data;
//    }
//    public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
//
//    private static final long[] mk_tokenSet_1() {
//        long[] data = {134217824L, 0L};
//        return data;
//    }
//    public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
//
//    private static final long[] mk_tokenSet_2() {
//        long[] data = {134217952L, 0L};
//        return data;
//    }
//    public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
//
//    private static final long[] mk_tokenSet_3() {
//        long[] data = {134218208L, 0L};
//        return data;
//    }
//    public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
//
//    private static final long[] mk_tokenSet_4() {
//        long[] data = {134282720L, 0L};
//        return data;
//    }
//    public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
//
//    private static final long[] mk_tokenSet_5() {
//        long[] data = {134479328L, 0L};
//        return data;
//    }
//    public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
//
//    private static final long[] mk_tokenSet_6() {
//        long[] data = {138411488L, 0L};
//        return data;
//    }
//    public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
//}
