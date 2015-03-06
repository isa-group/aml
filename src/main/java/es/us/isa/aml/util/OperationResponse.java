/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AntonioGamez
 */
public class OperationResponse {

    private final List<Object> responseList;

    public OperationResponse() {
        responseList = new ArrayList<>();
    }

    public void addResponseObject(Object o) {
        responseList.add(o);
    }

    public Object getResponseObject(int index) {
        return responseList.get(index);
    }

}
