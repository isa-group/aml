package isa.us.es.aml.parsers;

public class Error {
    public enum ERROR_SEVERITY {
		INFO, WARNING, ERROR, FATAL
    };
	

    protected int  lineNo;
    protected ERROR_SEVERITY severity;
    protected String message;

    public Error(int lineNo, ERROR_SEVERITY severity, String message) {
        this.lineNo = lineNo;
        this.severity = severity;
        this.message = message;
    }

    public int getLineNo() {
        return lineNo;
    }

    public String getMessage() {
        return message;
    }

    public ERROR_SEVERITY getSeverity() {
        return severity;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lineNo;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result
				+ ((severity == null) ? 0 : severity.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Error other = (Error) obj;
		if (lineNo != other.lineNo)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (severity == null) {
			if (other.severity != null)
				return false;
		} else if (!severity.equals(other.severity))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "( "+lineNo+") "+severity+": "+message;
    }

        
    
}
