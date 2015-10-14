/*******************************************************************************
 * AML is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AML. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) ISA, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.parsers.choco;

//// $ANTLR 2.7.7 (20060906): "ChocoAnalex.g" -> "ChocoAnalex.java"$
//package isa.us.es.aml.parsers.choco;
//
//import antlr.ANTLRHashString;
//import antlr.ByteBuffer;
//import antlr.CharBuffer;
//import antlr.CharStreamException;
//import antlr.CharStreamIOException;
//import antlr.InputBuffer;
//import antlr.LexerSharedInputState;
//import antlr.NoViableAltForCharException;
//import antlr.RecognitionException;
//import antlr.Token;
//import antlr.TokenStream;
//import antlr.TokenStreamException;
//import antlr.TokenStreamIOException;
//import antlr.TokenStreamRecognitionException;
//import antlr.collections.impl.BitSet;
//import java.io.InputStream;
//import java.io.Reader;
//import java.util.Hashtable;
//
//public class ChocoAnalex extends antlr.CharScanner implements ChocoAnalexTokenTypes, TokenStream {
//
//    public ChocoAnalex(InputStream in) {
//        this(new ByteBuffer(in));
//    }
//
//    public ChocoAnalex(Reader in) {
//        this(new CharBuffer(in));
//    }
//
//    public ChocoAnalex(InputBuffer ib) {
//        this(new LexerSharedInputState(ib));
//    }
//
//    public ChocoAnalex(LexerSharedInputState state) {
//        super(state);
//        caseSensitiveLiterals = true;
//        setCaseSensitive(true);
//        literals = new Hashtable();
//        literals.put(new ANTLRHashString("IFF", this), new Integer(5));
//        literals.put(new ANTLRHashString("IMPLIES", this), new Integer(6));
//        literals.put(new ANTLRHashString("OR", this), new Integer(7));
//        literals.put(new ANTLRHashString("AND", this), new Integer(8));
//        literals.put(new ANTLRHashString("NOT", this), new Integer(9));
//    }
//
//    public Token nextToken() throws TokenStreamException {
//        Token theRetToken = null;
//        tryAgain:
//        for (;;) {
//            Token _token = null;
//            int _ttype = Token.INVALID_TYPE;
//            resetText();
//            try {   // for char stream error handling
//                try {   // for lexical error handling
//                    switch (LA(1)) {
//                        case '\t':
//                        case '\n':
//                        case '\r':
//                        case ' ': {
//                            mBLANCO(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '.': {
//                            mPUNTO(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '#': {
//                            mCOMENT_LIN(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case 'A':
//                        case 'B':
//                        case 'C':
//                        case 'D':
//                        case 'E':
//                        case 'F':
//                        case 'G':
//                        case 'H':
//                        case 'I':
//                        case 'J':
//                        case 'K':
//                        case 'L':
//                        case 'M':
//                        case 'N':
//                        case 'O':
//                        case 'P':
//                        case 'Q':
//                        case 'R':
//                        case 'S':
//                        case 'T':
//                        case 'U':
//                        case 'V':
//                        case 'W':
//                        case 'X':
//                        case 'Y':
//                        case 'Z':
//                        case '_':
//                        case 'a':
//                        case 'b':
//                        case 'c':
//                        case 'd':
//                        case 'e':
//                        case 'f':
//                        case 'g':
//                        case 'h':
//                        case 'i':
//                        case 'j':
//                        case 'k':
//                        case 'l':
//                        case 'm':
//                        case 'n':
//                        case 'o':
//                        case 'p':
//                        case 'q':
//                        case 'r':
//                        case 's':
//                        case 't':
//                        case 'u':
//                        case 'v':
//                        case 'w':
//                        case 'x':
//                        case 'y':
//                        case 'z': {
//                            mIDENT(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '"': {
//                            mLIT_STRING(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '0':
//                        case '1':
//                        case '2':
//                        case '3':
//                        case '4':
//                        case '5':
//                        case '6':
//                        case '7':
//                        case '8':
//                        case '9': {
//                            mNUMERO(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '(': {
//                            mPARENTESIS_ABRIR(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case ')': {
//                            mPARENTESIS_CERRAR(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '+': {
//                            mMAS(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '-': {
//                            mMENOS(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '*': {
//                            mMULT(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '/': {
//                            mDIV(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '%': {
//                            mMOD(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '^': {
//                            mPOW(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '=': {
//                            mIGUAL(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        case '!': {
//                            mDISTINTO(true);
//                            theRetToken = _returnToken;
//                            break;
//                        }
//                        default:
//                            if ((LA(1) == '>') && (LA(2) == '=')) {
//                                mMAYOR_IGUAL(true);
//                                theRetToken = _returnToken;
//                            } else if ((LA(1) == '<') && (LA(2) == '=')) {
//                                mMENOR_IGUAL(true);
//                                theRetToken = _returnToken;
//                            } else if ((LA(1) == '>') && (true)) {
//                                mMAYOR(true);
//                                theRetToken = _returnToken;
//                            } else if ((LA(1) == '<') && (true)) {
//                                mMENOR(true);
//                                theRetToken = _returnToken;
//                            } else {
//                                if (LA(1) == EOF_CHAR) {
//                                    uponEOF();
//                                    _returnToken = makeToken(Token.EOF_TYPE);
//                                } else {
//                                    throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//                                }
//                            }
//                    }
//                    if (_returnToken == null) {
//                        continue tryAgain; // found SKIP token
//                    }
//                    _ttype = _returnToken.getType();
//                    _returnToken.setType(_ttype);
//                    return _returnToken;
//                } catch (RecognitionException e) {
//                    throw new TokenStreamRecognitionException(e);
//                }
//            } catch (CharStreamException cse) {
//                if (cse instanceof CharStreamIOException) {
//                    throw new TokenStreamIOException(((CharStreamIOException) cse).io);
//                } else {
//                    throw new TokenStreamException(cse.getMessage());
//                }
//            }
//        }
//    }
//
//    protected final void mSALTO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = SALTO;
//        int _saveIndex;
//        {
//            switch (LA(1)) {
//                case '\r': {
//                    match("\r\n");
//                    break;
//                }
//                case '\n': {
//                    match("\n");
//                    break;
//                }
//                default: {
//                    throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//                }
//            }
//        }
//        if (inputState.guessing == 0) {
//            newline();
//        }
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mBLANCO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = BLANCO;
//        int _saveIndex;
//        {
//            switch (LA(1)) {
//                case '\n':
//                case '\r': {
//                    mSALTO(false);
//                    break;
//                }
//                case ' ': {
//                    match(' ');
//                    break;
//                }
//                case '\t': {
//                    match('\t');
//                    break;
//                }
//                default: {
//                    throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//                }
//            }
//        }
//        if (inputState.guessing == 0) {
//            _ttype = Token.SKIP;
//        }
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    protected final void mLETRA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = LETRA;
//        int _saveIndex;
//        switch (LA(1)) {
//            case 'a':
//            case 'b':
//            case 'c':
//            case 'd':
//            case 'e':
//            case 'f':
//            case 'g':
//            case 'h':
//            case 'i':
//            case 'j':
//            case 'k':
//            case 'l':
//            case 'm':
//            case 'n':
//            case 'o':
//            case 'p':
//            case 'q':
//            case 'r':
//            case 's':
//            case 't':
//            case 'u':
//            case 'v':
//            case 'w':
//            case 'x':
//            case 'y':
//            case 'z': {
//                matchRange('a', 'z');
//                break;
//            }
//            case 'A':
//            case 'B':
//            case 'C':
//            case 'D':
//            case 'E':
//            case 'F':
//            case 'G':
//            case 'H':
//            case 'I':
//            case 'J':
//            case 'K':
//            case 'L':
//            case 'M':
//            case 'N':
//            case 'O':
//            case 'P':
//            case 'Q':
//            case 'R':
//            case 'S':
//            case 'T':
//            case 'U':
//            case 'V':
//            case 'W':
//            case 'X':
//            case 'Y':
//            case 'Z': {
//                matchRange('A', 'Z');
//                break;
//            }
//            default: {
//                throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//            }
//        }
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    protected final void mBARRA_BAJA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = BARRA_BAJA;
//        int _saveIndex;
//        match('_');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    protected final void mDIGITO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = DIGITO;
//        int _saveIndex;
//        matchRange('0', '9');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    protected final void mCOMILLA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = COMILLA;
//        int _saveIndex;
//        match('\'');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mPUNTO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = PUNTO;
//        int _saveIndex;
//        match('.');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    protected final void mALMOADILLA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = ALMOADILLA;
//        int _saveIndex;
//        match('#');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mCOMENT_LIN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = COMENT_LIN;
//        int _saveIndex;
//        mALMOADILLA(false);
//        {
//            _loop17:
//            do {
//                if ((LA(1) == '\r') && (_tokenSet_0.member(LA(2)))) {
//                    {
//                        int _cnt14 = 0;
//                        _loop14:
//                        do {
//                            if ((LA(1) == '\r') && (_tokenSet_0.member(LA(2)))) {
//                                match('\r');
//                            } else {
//                                if (_cnt14 >= 1) {
//                                    break _loop14;
//                                } else {
//                                    throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//                                }
//                            }
//                            _cnt14++;
//                        } while (true);
//                    }
//                    {
//                        match(_tokenSet_0);
//                    }
//                } else if ((_tokenSet_1.member(LA(1)))) {
//                    {
//                        match(_tokenSet_1);
//                    }
//                } else {
//                    break _loop17;
//                }
//            } while (true);
//        }
//        match("\r\n");
//        if (inputState.guessing == 0) {
//            newline();
//            _ttype = Token.SKIP;
//        }
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mIDENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = IDENT;
//        int _saveIndex;
//        {
//            switch (LA(1)) {
//                case 'A':
//                case 'B':
//                case 'C':
//                case 'D':
//                case 'E':
//                case 'F':
//                case 'G':
//                case 'H':
//                case 'I':
//                case 'J':
//                case 'K':
//                case 'L':
//                case 'M':
//                case 'N':
//                case 'O':
//                case 'P':
//                case 'Q':
//                case 'R':
//                case 'S':
//                case 'T':
//                case 'U':
//                case 'V':
//                case 'W':
//                case 'X':
//                case 'Y':
//                case 'Z':
//                case 'a':
//                case 'b':
//                case 'c':
//                case 'd':
//                case 'e':
//                case 'f':
//                case 'g':
//                case 'h':
//                case 'i':
//                case 'j':
//                case 'k':
//                case 'l':
//                case 'm':
//                case 'n':
//                case 'o':
//                case 'p':
//                case 'q':
//                case 'r':
//                case 's':
//                case 't':
//                case 'u':
//                case 'v':
//                case 'w':
//                case 'x':
//                case 'y':
//                case 'z': {
//                    mLETRA(false);
//                    break;
//                }
//                case '_': {
//                    mBARRA_BAJA(false);
//                    break;
//                }
//                default: {
//                    throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//                }
//            }
//        }
//        {
//            _loop21:
//            do {
//                switch (LA(1)) {
//                    case 'A':
//                    case 'B':
//                    case 'C':
//                    case 'D':
//                    case 'E':
//                    case 'F':
//                    case 'G':
//                    case 'H':
//                    case 'I':
//                    case 'J':
//                    case 'K':
//                    case 'L':
//                    case 'M':
//                    case 'N':
//                    case 'O':
//                    case 'P':
//                    case 'Q':
//                    case 'R':
//                    case 'S':
//                    case 'T':
//                    case 'U':
//                    case 'V':
//                    case 'W':
//                    case 'X':
//                    case 'Y':
//                    case 'Z':
//                    case 'a':
//                    case 'b':
//                    case 'c':
//                    case 'd':
//                    case 'e':
//                    case 'f':
//                    case 'g':
//                    case 'h':
//                    case 'i':
//                    case 'j':
//                    case 'k':
//                    case 'l':
//                    case 'm':
//                    case 'n':
//                    case 'o':
//                    case 'p':
//                    case 'q':
//                    case 'r':
//                    case 's':
//                    case 't':
//                    case 'u':
//                    case 'v':
//                    case 'w':
//                    case 'x':
//                    case 'y':
//                    case 'z': {
//                        mLETRA(false);
//                        break;
//                    }
//                    case '_': {
//                        mBARRA_BAJA(false);
//                        break;
//                    }
//                    case '0':
//                    case '1':
//                    case '2':
//                    case '3':
//                    case '4':
//                    case '5':
//                    case '6':
//                    case '7':
//                    case '8':
//                    case '9': {
//                        mDIGITO(false);
//                        break;
//                    }
//                    default: {
//                        break _loop21;
//                    }
//                }
//            } while (true);
//        }
//        _ttype = testLiteralsTable(_ttype);
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mLIT_STRING(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = LIT_STRING;
//        int _saveIndex;
//        match('"');
//        {
//            _loop24:
//            do {
//                if ((_tokenSet_2.member(LA(1)))) {
//                    matchNot('"');
//                } else {
//                    break _loop24;
//                }
//            } while (true);
//        }
//        match('"');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mNUMERO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = NUMERO;
//        int _saveIndex;
//        boolean synPredMatched29 = false;
//        if ((((LA(1) >= '0' && LA(1) <= '9')) && (_tokenSet_3.member(LA(2))))) {
//            int _m29 = mark();
//            synPredMatched29 = true;
//            inputState.guessing++;
//            try {
//                {
//                    {
//                        int _cnt28 = 0;
//                        _loop28:
//                        do {
//                            if (((LA(1) >= '0' && LA(1) <= '9'))) {
//                                mDIGITO(false);
//                            } else {
//                                if (_cnt28 >= 1) {
//                                    break _loop28;
//                                } else {
//                                    throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//                                }
//                            }
//                            _cnt28++;
//                        } while (true);
//                    }
//                    match('.');
//                }
//            } catch (RecognitionException pe) {
//                synPredMatched29 = false;
//            }
//            rewind(_m29);
//            inputState.guessing--;
//        }
//        if (synPredMatched29) {
//            {
//                int _cnt31 = 0;
//                _loop31:
//                do {
//                    if (((LA(1) >= '0' && LA(1) <= '9'))) {
//                        mDIGITO(false);
//                    } else {
//                        if (_cnt31 >= 1) {
//                            break _loop31;
//                        } else {
//                            throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//                        }
//                    }
//                    _cnt31++;
//                } while (true);
//            }
//            match('.');
//            {
//                int _cnt33 = 0;
//                _loop33:
//                do {
//                    if (((LA(1) >= '0' && LA(1) <= '9'))) {
//                        mDIGITO(false);
//                    } else {
//                        if (_cnt33 >= 1) {
//                            break _loop33;
//                        } else {
//                            throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//                        }
//                    }
//                    _cnt33++;
//                } while (true);
//            }
//            if (inputState.guessing == 0) {
//                _ttype = LIT_REAL;
//            }
//        } else {
//            boolean synPredMatched37 = false;
//            if ((((LA(1) >= '0' && LA(1) <= '9')) && (true))) {
//                int _m37 = mark();
//                synPredMatched37 = true;
//                inputState.guessing++;
//                try {
//                    {
//                        {
//                            int _cnt36 = 0;
//                            _loop36:
//                            do {
//                                if (((LA(1) >= '0' && LA(1) <= '9'))) {
//                                    mDIGITO(false);
//                                } else {
//                                    if (_cnt36 >= 1) {
//                                        break _loop36;
//                                    } else {
//                                        throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//                                    }
//                                }
//                                _cnt36++;
//                            } while (true);
//                        }
//                    }
//                } catch (RecognitionException pe) {
//                    synPredMatched37 = false;
//                }
//                rewind(_m37);
//                inputState.guessing--;
//            }
//            if (synPredMatched37) {
//                {
//                    int _cnt39 = 0;
//                    _loop39:
//                    do {
//                        if (((LA(1) >= '0' && LA(1) <= '9'))) {
//                            mDIGITO(false);
//                        } else {
//                            if (_cnt39 >= 1) {
//                                break _loop39;
//                            } else {
//                                throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//                            }
//                        }
//                        _cnt39++;
//                    } while (true);
//                }
//                if (inputState.guessing == 0) {
//                    _ttype = LIT_ENTERO;
//                }
//            } else {
//                throw new NoViableAltForCharException((char) LA(1), getFilename(), getLine(), getColumn());
//            }
//        }
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mPARENTESIS_ABRIR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = PARENTESIS_ABRIR;
//        int _saveIndex;
//        match('(');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mPARENTESIS_CERRAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = PARENTESIS_CERRAR;
//        int _saveIndex;
//        match(')');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mMAS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = MAS;
//        int _saveIndex;
//        match('+');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mMENOS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = MENOS;
//        int _saveIndex;
//        match('-');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mMULT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = MULT;
//        int _saveIndex;
//        match('*');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mDIV(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = DIV;
//        int _saveIndex;
//        match('/');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mMOD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = MOD;
//        int _saveIndex;
//        match('%');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mPOW(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = POW;
//        int _saveIndex;
//        match('^');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mMAYOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = MAYOR;
//        int _saveIndex;
//        match('>');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mMENOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = MENOR;
//        int _saveIndex;
//        match('<');
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mMAYOR_IGUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = MAYOR_IGUAL;
//        int _saveIndex;
//        match(">=");
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mMENOR_IGUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = MENOR_IGUAL;
//        int _saveIndex;
//        match("<=");
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mIGUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = IGUAL;
//        int _saveIndex;
//        match("=");
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    public final void mDISTINTO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
//        int _ttype;
//        Token _token = null;
//        int _begin = text.length();
//        _ttype = DISTINTO;
//        int _saveIndex;
//        match("!=");
//        if (_createToken && _token == null && _ttype != Token.SKIP) {
//            _token = makeToken(_ttype);
//            _token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
//        }
//        _returnToken = _token;
//    }
//
//    private static final long[] mk_tokenSet_0() {
//        long[] data = new long[260];
//        data[0] = -1032L;
//        for (int i = 1; i <= 3; i++) {
//            data[i] = -1L;
//        }
//        for (int i = 64; i <= 127; i++) {
//            data[i] = -1L;
//        }
//        return data;
//    }
//    public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
//
//    private static final long[] mk_tokenSet_1() {
//        long[] data = new long[260];
//        data[0] = -8200L;
//        for (int i = 1; i <= 3; i++) {
//            data[i] = -1L;
//        }
//        for (int i = 64; i <= 127; i++) {
//            data[i] = -1L;
//        }
//        return data;
//    }
//    public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
//
//    private static final long[] mk_tokenSet_2() {
//        long[] data = new long[260];
//        data[0] = -17179869192L;
//        for (int i = 1; i <= 3; i++) {
//            data[i] = -1L;
//        }
//        for (int i = 64; i <= 127; i++) {
//            data[i] = -1L;
//        }
//        return data;
//    }
//    public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
//
//    private static final long[] mk_tokenSet_3() {
//        long[] data = new long[131];
//        data[0] = 288019269919178752L;
//        return data;
//    }
//    public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
//}
