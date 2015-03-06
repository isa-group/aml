package es.us.isa.aml.parsers.agreements.iagree;

import es.us.isa.aml.parsers.Error;

public class IAgreeError extends Error {

    protected int charStart;
    protected int charEnd;
    protected TYPE type;

    public IAgreeError(int lineNo, int charStart, int charEnd, ERROR_SEVERITY severity, String message) {
        super(lineNo, severity, message);
        this.charStart = charStart;
        this.charEnd = charEnd;
    }

    public int getCharStart() {
        return charStart;
    }

    public void setCharStart(int charStart) {
        this.charStart = charStart;
    }

    public int getCharEnd() {
        return charEnd;
    }

    public void setCharEnd(int charEnd) {
        this.charEnd = charEnd;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "( " + lineNo + ":" + charStart + ":" + charEnd + ") " + severity + ": " + message;
    }

    public enum TYPE {

        SYNTAX, SEMANTIC
    }

}
