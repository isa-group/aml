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

//package isa.us.es.aml.parsers.choco;
//
//import antlr.RecognitionException;
//import antlr.TokenStreamException;
//import antlr.collections.AST;
//import choco.kernel.model.variables.Variable;
//import isa.us.es.aml.adaintegration.adaadhoc.ada.choco.utils.ParsingResult;
//import isa.us.es.aml.parsers.choco.ChocoAnalex;
//import isa.us.es.aml.parsers.choco.ChocoAnasint;
//import isa.us.es.aml.parsers.choco.ChocoTreeParser;
//import java.io.ByteArrayInputStream;
//import java.util.Map;
////TODO hay que tocar en el parser para cambiar las constantes enumeradas
////por su valor
//
//public class ChocoParser {
//
//    private Map<String, Variable> vars;
//
//    public ParsingResult parseConstraint(String c) {
//        ParsingResult res = null;
//        if (c == null) {
//            LOG.log(Level.INFO,"Atencion, se esta intentando parsear un string null a constraint!");
//            return null;
//        }
//        ByteArrayInputStream fis = new ByteArrayInputStream(c.getBytes());
//        ChocoAnalex analex = new ChocoAnalex(fis);
//        ChocoAnasint anasint = new ChocoAnasint(analex);
//        AST arbol = null;
//        try {
//            anasint.expresion();
//            arbol = anasint.getAST();
////			ASTFrame frame = new ASTFrame("arbol",arbol);
////			frame.setVisible(true);
//            ChocoTreeParser anasem = new ChocoTreeParser();
////			anasem.setVars(vars);
//            res = anasem.entrada(arbol, vars);
//        } catch (RecognitionException e) {
//            LOG.log(Level.INFO,null,e);
//        } catch (TokenStreamException e) {
//          LOG.log(Level.INFO,null,e);
//        }
//        return res;
//    }
//
//    public void setVariables(Map<String, Variable> v) {
//        vars = v;
//    }
//}
