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
 * Copyright (C) ISA Research Group - University of Sevilla, 2015
 * Licensed under GPL (https://github.com/isa-group/aml/blob/master/LICENSE.txt)
 *******************************************************************************/
package es.us.isa.aml.parsers.choco;

//// $ANTLR 2.7.7 (20060906): "ChocoTreeParser.g" -> "ChocoTreeParser.java"$
//package isa.us.es.aml.parsers.choco;
//
//import antlr.NoViableAltException;
//import antlr.RecognitionException;
//import antlr.collections.AST;
//import choco.Choco;
//import choco.kernel.model.constraints.Constraint;
//import choco.kernel.model.variables.Variable;
//import choco.kernel.model.variables.integer.IntegerConstantVariable;
//import choco.kernel.model.variables.integer.IntegerExpressionVariable;
//import choco.kernel.model.variables.integer.IntegerVariable;
//import choco.kernel.model.variables.real.RealConstantVariable;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.utils.ParsingResult;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.utils.Utils;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.domain.ConstantConverter;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.wsag10.domain.DefaultConstantConverter;
//import java.util.Collection;
//import java.util.LinkedList;
//import java.util.Map;
//
//public class ChocoTreeParser extends antlr.TreeParser implements ChocoTreeParserTokenTypes {
//
//    ConstantConverter converter = DefaultConstantConverter.getInstance();
//    Map<String, Variable> variables;
//    Collection<String> unknownVars;
//
//    public IntegerVariable getVariable(AST ident) {
//        IntegerVariable res = null;
//        String s = ident.getText();
//        Variable v = variables.get(s);
//        if (v != null && (v instanceof IntegerVariable)) {
//            res = (IntegerVariable) v;
//        } else {
//            unknownVars.add(s);
//        }
//        return res;
//    }
//
//    public IntegerConstantVariable getEnumValue(AST t) {
//        //String quotesTrimmed = t.getText();
//        String quotesTrimmed = t.getText().replace("\"", "");
//        int aux = converter.convertToInteger(quotesTrimmed);
//        IntegerConstantVariable res = Choco.constant(aux);
//        return res;
//    }
//
//    public IntegerConstantVariable toInt(AST t) {
//        String s = Utils.removeQuotes(t.getText());
//        int i = Integer.parseInt(s);
//        IntegerConstantVariable res = Choco.constant(i);
//        return res;
//    }
//
//    public RealConstantVariable toDouble(AST t) {
//        String s = t.getText();
//        double i = Double.parseDouble(s);
//        RealConstantVariable res = Choco.constant(i);
//        return res;
//    }
//
//    public ChocoTreeParser() {
//        tokenNames = _tokenNames;
//    }
//
//    public final ParsingResult entrada(AST _t,
//            Map<String, Variable> vars
//    ) throws RecognitionException {
//        ParsingResult res = null;
//        AST entrada_AST_in = (_t == ASTNULL) ? null : (AST) _t;
//        Constraint aux = null;
//        try {      // for error handling
//            variables = vars;
//            unknownVars = new LinkedList<String>();
//            aux = expresion_logica(_t);
//            _t = _retTree;
//            res = new ParsingResult(aux, unknownVars);
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            if (_t != null) {
//                _t = _t.getNextSibling();
//            }
//        }
//        _retTree = _t;
//        return res;
//    }
//
//    public final Constraint expresion_logica(AST _t) throws RecognitionException {
//        Constraint res = null;
//        AST expresion_logica_AST_in = (_t == ASTNULL) ? null : (AST) _t;
//        Constraint c1 = null, c2 = null;
//        try {      // for error handling
//            if (_t == null) {
//                _t = ASTNULL;
//            }
//            switch (_t.getType()) {
//                case IFF: {
//                    AST __t3 = _t;
//                    AST tmp1_AST_in = (AST) _t;
//                    match(_t, IFF);
//                    _t = _t.getFirstChild();
//                    c1 = expresion_logica(_t);
//                    _t = _retTree;
//                    c2 = expresion_logica(_t);
//                    _t = _retTree;
//                    res = Choco.ifOnlyIf(c1, c2);
//                    _t = __t3;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case IMPLIES: {
//                    AST __t4 = _t;
//                    AST tmp2_AST_in = (AST) _t;
//                    match(_t, IMPLIES);
//                    _t = _t.getFirstChild();
//                    c1 = expresion_logica(_t);
//                    _t = _retTree;
//                    c2 = expresion_logica(_t);
//                    _t = _retTree;
//                    res = Choco.implies(c1, c2);
//                    _t = __t4;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case OR: {
//                    AST __t5 = _t;
//                    AST tmp3_AST_in = (AST) _t;
//                    match(_t, OR);
//                    _t = _t.getFirstChild();
//                    c1 = expresion_logica(_t);
//                    _t = _retTree;
//                    c2 = expresion_logica(_t);
//                    _t = _retTree;
//                    res = Choco.or(c1, c2);
//                    _t = __t5;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case AND: {
//                    AST __t6 = _t;
//                    AST tmp4_AST_in = (AST) _t;
//                    match(_t, AND);
//                    _t = _t.getFirstChild();
//                    c1 = expresion_logica(_t);
//                    _t = _retTree;
//                    c2 = expresion_logica(_t);
//                    _t = _retTree;
//                    res = Choco.and(c1, c2);
//                    _t = __t6;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case NOT: {
//                    AST __t7 = _t;
//                    AST tmp5_AST_in = (AST) _t;
//                    match(_t, NOT);
//                    _t = _t.getFirstChild();
//                    c1 = expresion_logica(_t);
//                    _t = _retTree;
//                    res = Choco.not(c1);
//                    _t = __t7;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case MAYOR:
//                case MENOR:
//                case MAYOR_IGUAL:
//                case MENOR_IGUAL:
//                case IGUAL:
//                case DISTINTO: {
//                    res = expresion_relacional(_t);
//                    _t = _retTree;
//                    break;
//                }
//                default: {
//                    throw new NoViableAltException(_t);
//                }
//            }
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            if (_t != null) {
//                _t = _t.getNextSibling();
//            }
//        }
//        _retTree = _t;
//        return res;
//    }
//
//    public final Constraint expresion_relacional(AST _t) throws RecognitionException {
//        Constraint res = null;
//        AST expresion_relacional_AST_in = (_t == ASTNULL) ? null : (AST) _t;
//        IntegerExpressionVariable v1 = null, v2 = null;
//        try {      // for error handling
//            if (_t == null) {
//                _t = ASTNULL;
//            }
//            switch (_t.getType()) {
//                case MAYOR: {
//                    AST __t9 = _t;
//                    AST tmp6_AST_in = (AST) _t;
//                    match(_t, MAYOR);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.gt(v1, v2);
//                    _t = __t9;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case MENOR: {
//                    AST __t10 = _t;
//                    AST tmp7_AST_in = (AST) _t;
//                    match(_t, MENOR);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.lt(v1, v2);
//                    _t = __t10;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case MAYOR_IGUAL: {
//                    AST __t11 = _t;
//                    AST tmp8_AST_in = (AST) _t;
//                    match(_t, MAYOR_IGUAL);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.geq(v1, v2);
//                    _t = __t11;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case MENOR_IGUAL: {
//                    AST __t12 = _t;
//                    AST tmp9_AST_in = (AST) _t;
//                    match(_t, MENOR_IGUAL);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.leq(v1, v2);
//                    _t = __t12;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case IGUAL: {
//                    AST __t13 = _t;
//                    AST tmp10_AST_in = (AST) _t;
//                    match(_t, IGUAL);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.eq(v1, v2);
//                    _t = __t13;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case DISTINTO: {
//                    AST __t14 = _t;
//                    AST tmp11_AST_in = (AST) _t;
//                    match(_t, DISTINTO);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.neq(v1, v2);
//                    _t = __t14;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                default: {
//                    throw new NoViableAltException(_t);
//                }
//            }
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            if (_t != null) {
//                _t = _t.getNextSibling();
//            }
//        }
//        _retTree = _t;
//        return res;
//    }
//
//    public final IntegerExpressionVariable expresion_aritmetica(AST _t) throws RecognitionException {
//        IntegerExpressionVariable res = null;;
//        AST expresion_aritmetica_AST_in = (_t == ASTNULL) ? null : (AST) _t;
//        AST i = null;
//        AST s = null;
//        IntegerExpressionVariable v1 = null, v2 = null;
//        try {      // for error handling
//            if (_t == null) {
//                _t = ASTNULL;
//            }
//            switch (_t.getType()) {
//                case MAS: {
//                    AST __t16 = _t;
//                    AST tmp12_AST_in = (AST) _t;
//                    match(_t, MAS);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.plus(v1, v2);
//                    _t = __t16;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case MENOS: {
//                    AST __t17 = _t;
//                    AST tmp13_AST_in = (AST) _t;
//                    match(_t, MENOS);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.minus(v1, v2);
//                    _t = __t17;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case MULT: {
//                    AST __t18 = _t;
//                    AST tmp14_AST_in = (AST) _t;
//                    match(_t, MULT);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.mult(v1, v2);
//                    _t = __t18;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case DIV: {
//                    AST __t19 = _t;
//                    AST tmp15_AST_in = (AST) _t;
//                    match(_t, DIV);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.div(v1, v2);
//                    _t = __t19;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case MOD: {
//                    AST __t20 = _t;
//                    AST tmp16_AST_in = (AST) _t;
//                    match(_t, MOD);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.mod(v1, v2);
//                    _t = __t20;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case POW: {
//                    AST __t21 = _t;
//                    AST tmp17_AST_in = (AST) _t;
//                    match(_t, POW);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    v2 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    res = Choco.power(v1, v2);
//                    _t = __t21;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case MENOS_UNARIO: {
//                    AST __t22 = _t;
//                    AST tmp18_AST_in = (AST) _t;
//                    match(_t, MENOS_UNARIO);
//                    _t = _t.getFirstChild();
//                    v1 = expresion_aritmetica(_t);
//                    _t = _retTree;
//                    _t = __t22;
//                    _t = _t.getNextSibling();
//                    break;
//                }
//                case LIT_ENTERO: {
//                    res = valor(_t);
//                    _t = _retTree;
//                    break;
//                }
//                case IDENT: {
//                    i = (AST) _t;
//                    match(_t, IDENT);
//                    _t = _t.getNextSibling();
//                    res = getVariable(i);
//                    break;
//                }
//                case LIT_STRING: {
//                    s = (AST) _t;
//                    match(_t, LIT_STRING);
//                    _t = _t.getNextSibling();
//                    res = getEnumValue(s);
//                    break;
//                }
//                default: {
//                    throw new NoViableAltException(_t);
//                }
//            }
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            if (_t != null) {
//                _t = _t.getNextSibling();
//            }
//        }
//        _retTree = _t;
//        return res;
//    }
//
//    public final IntegerConstantVariable valor(AST _t) throws RecognitionException {
//        IntegerConstantVariable res = null;;
//        AST valor_AST_in = (_t == ASTNULL) ? null : (AST) _t;
//        AST i = null;
//        try {      // for error handling
//            i = (AST) _t;
//            match(_t, LIT_ENTERO);
//            _t = _t.getNextSibling();
//            res = toInt(i);
//        } catch (RecognitionException ex) {
//            reportError(ex);
//            if (_t != null) {
//                _t = _t.getNextSibling();
//            }
//        }
//        _retTree = _t;
//        return res;
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
//}
