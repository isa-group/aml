package es.us.isa.aml.model.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class ListExpression extends Expression {

	public ListExpression(Object n) {
		this.value = n;
	}

	@Override
	public Object calculate() {
		return this.value;
	}

	@Override
	public String toString() {
		if (value instanceof ArrayList) {
			return value.toString();
		} else {
			StringBuilder sb = new StringBuilder();
			Object[] values = (Object[]) value;
			List<Object> ls = new ArrayList<Object>();
			for (int i = 0; i < values.length; i++) {
				ls.add("\"" + values[i] + "\"");
			}
			sb.append(ls.toString().replace("[", "{").replace("]", "}"));
			return sb.toString();
		}
	}
}
