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
package es.us.isa.aml.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains the response of a web reasoner.
 * 
 * @author jdelafuente
 *
 */
public class OperationResponse {

	private Map<String, Object> result;

	public OperationResponse() {
		result = new HashMap<>();
	}

	/**
	 * @return the result
	 */
	public Map<String, Object> getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	/**
	 * @param string The key of the operation response map
	 * @return The value of the given key contained in the operation response
	 */
	public Object get(String string) {
		return result.get(string);
	}

	/**
	 * @param string The key of the entry you want to put in the operation response map
	 * @param obj The value of entry you want to put in the operation response map
	 */
	public void put(String string, Object obj) {
		result.put(string, obj);
	}

	/**
	 * @param result The operation response object to join with
	 */
	public void putAll(OperationResponse result) {
		for (String key : result.getResult().keySet()) {
			this.result.put(key, result.getResult().get(key));
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Object> entrySet : result.entrySet()) {
			sb.append("\t").append(entrySet.getKey()).append(":" + " ")
					.append(entrySet.getValue()).append("\n");
		}
		return sb.toString();
	}

	public Object remove(String key) {
		return result.remove(key);
	}

}
