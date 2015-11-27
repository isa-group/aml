package es.us.isa.aml.model.expression;

import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;

import es.us.isa.aml.model.ResourceProperty;
import es.us.isa.aml.model.ResourceState;

/**
 * @author AntonioGamez
 *
 */
public class DuringExpression extends Expression {

    protected ResourceProperty property;
    protected Expression state;
    protected Expression num;
    protected DuringInterval interval;

    public DuringExpression(ResourceProperty property, Expression state, Expression num, DuringInterval interval) {
        this.property = property;
        this.state = state;
        this.num = num;
        this.interval = interval;
    }

    public DuringExpression(DuringExpression duringExpression) {
        this.property = new ResourceProperty(duringExpression.property);
        //this.property = new ResourceProperty(duringExpression.property,new ResourceState(duringExpression.property.getResourceState().getResourcesStateMap()));
        this.state = duringExpression.state;
        this.num = duringExpression.num;
        this.interval = duringExpression.interval;
    }

    public DuringExpression() {
    }

    @Override
    public Boolean calculate() {
        ResourceState resourceState = property.getValue();
        Var varState = (Var) state;
        Atomic atomNum = (Atomic) num;

        Map<String, Map<Long, String>> resourcesStateMap = resourceState.getResourcesStateMap();
        String varStateValue = (String) varState.getId();
        Integer atomNumValue = new Integer((String) atomNum.calculate());

        return evalDuration(resourcesStateMap, varStateValue, atomNumValue, interval);
    }

    private Boolean evalDuration(Map<String, Map<Long, String>> map, String state, Integer cant, DuringInterval interval) {
        Boolean res = true;
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int intervalStr = cal.get(Calendar.DAY_OF_MONTH);
        switch (interval) {
            case DAY:
                intervalStr = Calendar.DAY_OF_MONTH;
                break;
            case HOUR:
                intervalStr = Calendar.HOUR;
                break;
            case MINUTE:
                intervalStr = Calendar.MINUTE;
                break;
            case MONTH:
                intervalStr = Calendar.MONTH;
                break;
            case WEEK:
                intervalStr = Calendar.DAY_OF_MONTH;
                cant = cant * 7;
                break;
            case YEAR:
                intervalStr = Calendar.YEAR;
                break;
            case SECOND:
                intervalStr = Calendar.SECOND;
                break;
            default:
                throw new RuntimeException("unknown operator: " + interval);
        }
        for (Entry<String, Map<Long, String>> entry : map.entrySet()) {
            for (Entry<Long, String> resourceStatesEntry : entry.getValue().entrySet()) {
                Long point = nextTimeStamp(entry.getValue(), resourceStatesEntry.getKey(), state);
                Calendar c1 = Calendar.getInstance();
                c1.setTimeInMillis(point);
                c1.add(intervalStr, -cant);
                String st = resourceStatesEntry.getValue();
                if (resourceStatesEntry.getKey() < c1.getTimeInMillis() && state.equals(st)) {
                    return false;
                }
            }
        }
        return res;
    }

    private Long nextTimeStamp(Map<Long, String> map, Long point, String state) {
        Long min = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();

        for (Entry<Long, String> a : map.entrySet()) {
            Long b = a.getKey();
            if (b > point) {
                if ((b < min) && !a.getValue().equals(state)) {
                    min = b;
                }
            }
        }
        return min;
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

    public Expression getNum() {
        return num;
    }

    public void setNum(Expression num) {
        this.num = num;
    }

    public DuringInterval getInterval() {
        return interval;
    }

    public void setInterval(DuringInterval interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        String intervalStr = "";
        switch ((DuringInterval) this.interval) {
            case DAY:
                intervalStr = "DAY";
                break;
            case HOUR:
                intervalStr = "HOUR";
                break;
            case MINUTE:
                intervalStr = "MINUTE";
                break;
            case MONTH:
                intervalStr = "MONTH";
                break;
            case WEEK:
                intervalStr = "WEEK";
                break;
            case YEAR:
                intervalStr = "YEAR";
                break;
            case SECOND:
                intervalStr = "SECOND";
                break;
        }

        return this.property + " in " + this.state + " by " + this.num + " " + intervalStr;
    }

}
