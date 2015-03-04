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
//            System.err.println("Atencion, se esta intentando parsear un string null a constraint!");
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
//            e.printStackTrace();
//        } catch (TokenStreamException e) {
//            e.printStackTrace();
//        }
//        return res;
//    }
//
//    public void setVariables(Map<String, Variable> v) {
//        vars = v;
//    }
//}
