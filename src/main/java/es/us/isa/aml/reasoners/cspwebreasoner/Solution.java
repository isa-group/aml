package es.us.isa.aml.reasoners.cspwebreasoner;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-03-11T10:40:03.945+01:00")
public class Solution  {
  
  private Boolean feasibility = null;
  private String explaining = null;
  private List<String> conflicts = new ArrayList<>();
  private String error = null;

  
  /**
   **/
  @JsonProperty("feasibility")
  public Boolean getFeasibility() {
    return feasibility;
  }
  public void setFeasibility(Boolean feasibility) {
    this.feasibility = feasibility;
  }

  
  /**
   **/
  @JsonProperty("explaining")
  public String getExplaining() {
    return explaining;
  }
  public void setExplaining(String explaining) {
    this.explaining = explaining;
  }

  
  /**
   **/
  @JsonProperty("conflicts")
  public List<String> getConflicts() {
    return conflicts;
  }
  public void setConflicts(List<String> conflicts) {
    this.conflicts = conflicts;
  }

  
  /**
   **/
  @JsonProperty("error")
  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Solution solution = (Solution) o;
    return Objects.equals(feasibility, solution.feasibility) &&
        Objects.equals(explaining, solution.explaining) &&
        Objects.equals(conflicts, solution.conflicts) &&
        Objects.equals(error, solution.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feasibility, explaining, conflicts, error);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Solution {\n");
    
    sb.append("  feasibility: ").append(feasibility).append("\n");
    sb.append("  explaining: ").append(explaining).append("\n");
    sb.append("  conflicts: ").append(conflicts).append("\n");
    sb.append("  error: ").append(error).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
