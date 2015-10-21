package es.us.isa.aml.model.expression;

import java.util.Calendar;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

import es.us.isa.aml.model.ResourceProperty;
import es.us.isa.aml.model.ResourceState;
import es.us.isa.aml.util.AssessmentInterval;

/**
 * @author jdelafuente
 *
 */
public class FrecuencyExpression extends Expression {

    protected ResourceProperty property;
    protected Expression state;
    protected RelationalOperator operator;
    protected Expression ntimes;
    protected AssessmentInterval interval;

    public FrecuencyExpression(ResourceProperty property, Expression state, RelationalOperator operator, Expression ntimes, AssessmentInterval interval) {
        this.property = property;
        this.state = state;
        this.operator = operator;
        this.ntimes = ntimes;
        this.interval = interval;
    }

    public FrecuencyExpression(FrecuencyExpression frecuencyExpression) {
        this.property = new ResourceProperty(frecuencyExpression.property);
        this.state = frecuencyExpression.state;
        this.operator = frecuencyExpression.operator;
        this.ntimes = frecuencyExpression.ntimes;
        this.interval = frecuencyExpression.interval;
    }

    public FrecuencyExpression() {
    }

    @Override
    public Boolean calculate() {
        ResourceState resourceStates = property.getValue();
        Var varState = (Var) state;
        Atomic atomNtimes = (Atomic) ntimes;

        Map<String, Map<Long, String>> resourcesStateMap = resourceStates.getResourcesStateMap();
        String varStateValue = (String) varState.getId();
        Integer atomNtimesValue = new Integer((String) atomNtimes.calculate());

        return evalFrequency(resourcesStateMap, varStateValue, operator, atomNtimesValue, interval);
    }

    //ToDo
    private Boolean evalFrequency(Map<String, Map<Long, String>> map, String state, RelationalOperator operator, Integer cant, AssessmentInterval interval) {
        Boolean res = false;
        Integer freq = getFrequencyNow(map, state, interval);
        switch (operator) {
            case LTE:
                if (freq <= cant) {
                    res = true;
                }
                break;
            case GTE:
                if (freq >= cant) {
                    res = true;
                }
                break;
            case LT:
                if (freq < cant) {
                    res = true;
                }
                break;
            case GT:
                if (freq > cant) {
                    res = true;
                }
                break;
            case EQ:
                if (Objects.equals(freq, cant)) {
                    res = true;
                }
                break;
            default:
                throw new RuntimeException("unknown operator: " + operator);
        }
        return res;
    }

    //ToDo
    private Integer getFrequencyNow(Map<String, Map<Long, String>> map, String state, AssessmentInterval interval) {
        Integer ntimesVar = 0;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        switch (interval) {
            case YEARLY:
                calendar.add(Calendar.YEAR, -1);
                break;
            case MONTHLY:
                calendar.add(Calendar.MONTH, -1);
                break;
            case WEEKLY:
                calendar.add(Calendar.DAY_OF_YEAR, -7);
                break;
            case DAILY:
                calendar.add(Calendar.DAY_OF_YEAR, -1);
                break;
            case HOURLY:
                calendar.add(Calendar.HOUR, -1);
                break;
            case MINUTELY:
                calendar.add(Calendar.MINUTE, -1);
                break;
            case SECONDLY:
                calendar.add(Calendar.SECOND, -1);
                break;
            default:
                throw new RuntimeException("unknown operator: " + interval);
        }
        for (Map<Long, String> resourceStates : map.values()) {
            //boolean a = true;
            for (Long timestamp : resourceStates.keySet()) {
                if (timestamp > calendar.getTimeInMillis() && state.equals(resourceStates.get(timestamp))) {
                    // if (a) {
                    ntimesVar++;
                    break;
                    // }

                }
            }
        }
        return ntimesVar;
    }

    public ResourceProperty getProperty() {
        return property;
    }

    public void setProperty(ResourceProperty property) {
        this.property = property;
    }

    public Expression getState() {
        return state;
    }

    public void setState(Expression state) {
        this.state = state;
    }

    public RelationalOperator getOperator() {
        return operator;
    }

    public void setOperator(RelationalOperator operator) {
        this.operator = operator;
    }

    public Expression getNtimes() {
        return ntimes;
    }

    public void setNtimes(Expression ntimes) {
        this.ntimes = ntimes;
    }

    public AssessmentInterval getInterval() {
        return interval;
    }

    public void setInterval(AssessmentInterval interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        String op = "";
        String intervalStr = "";

        switch ((RelationalOperator) this.operator) {
            case GT:
                op = ">";
                break;
            case GTE:
                op = ">=";
                break;
            case LT:
                op = "<";
                break;
            case LTE:
                op = "<=";
                break;
            case EQ:
                op = "==";
                break;
            case NEQ:
                op = "!=";
                break;
        }

        switch ((AssessmentInterval) this.interval) {
            case DAILY:
                intervalStr = "DAILY";
                break;
            case HOURLY:
                intervalStr = "HOURLY";
                break;
            case MINUTELY:
                intervalStr = "MINUTELY";
                break;
            case MONTHLY:
                intervalStr = "MONTHLY";
                break;
            case WEEKLY:
                intervalStr = "WEEKLY";
                break;
            case YEARLY:
                intervalStr = "YEARLY";
                break;
            case SECONDLY:
                intervalStr = "SECONDLY";
                break;
        }
        return this.property + " in " + this.state + " " + op + " " + this.ntimes + " " + intervalStr;
    }

}
