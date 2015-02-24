/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.parsers;

import isa.us.es.aml.model.AgreementModel;
import isa.us.es.aml.util.SLAFile;

/**
 *
 * @author Antonio
 */
public interface Parser {

    public AgreementModel doParse(SLAFile file);
}
