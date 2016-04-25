package es.us.isa.aml.reasoners.cspwebreasoner;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-03-04T11:56:55.748+01:00")
public class Problem {

    private String id = null;
    private String sessionId = null;
    private String type = null;
    private String definition = null;
    private Solution solution = null;


    /**
     *
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     */
    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     *
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     */
    @JsonProperty("definition")
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    /**
     *
     */
    @JsonProperty("solution")
    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Problem problem = (Problem) o;
        return Objects.equals(id, problem.id)
                && Objects.equals(sessionId, problem.sessionId)
                && Objects.equals(type, problem.type)
                && Objects.equals(definition, problem.definition)
                && Objects.equals(solution, problem.solution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionId, type, definition, solution);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Problem {\n");

        sb.append("  id: ").append(id).append("\n");
        sb.append("  sessionId: ").append(sessionId).append("\n");
        sb.append("  type: ").append(type).append("\n");
        sb.append("  definition: ").append(definition).append("\n");
        sb.append("  solution: ").append(solution).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
