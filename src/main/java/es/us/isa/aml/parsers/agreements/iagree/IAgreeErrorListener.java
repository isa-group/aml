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
package es.us.isa.aml.parsers.agreements.iagree;

import es.us.isa.aml.parsers.Error.ERROR_SEVERITY;
import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

public class IAgreeErrorListener extends BaseErrorListener {

    public static IAgreeErrorListener INSTANCE = new IAgreeErrorListener();
    private final List<IAgreeError> errors = new LinkedList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
            Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        int charEndOffset = charPositionInLine;
        if (offendingSymbol != null && offendingSymbol instanceof Token) {
            charEndOffset = ((Token) offendingSymbol).getStopIndex()
                    - ((Token) offendingSymbol).getStartIndex();
        }

        errors.add(new IAgreeError(line,
                charPositionInLine, charEndOffset,
                ERROR_SEVERITY.ERROR, "line " + line + ":" + charPositionInLine
                + " " + msg));

    }

    public List<IAgreeError> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void clearErrors() {
        errors.clear();
    }

    @Override
    public String toString() {
        return "IAgreeErrorListener [errors=" + errors + "]";
    }

}
