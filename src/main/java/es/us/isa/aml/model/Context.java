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
package es.us.isa.aml.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jdelafuente
 *
 */
public class Context {

	private String templateId;
	private Double templateVersion;
	private Actor initiator;
    private Actor responder;
    private Map<String, Metric> metrics;

    /**
     *
     */
    public Context() {
        metrics = new HashMap<>();
    }
    
    /**
     * @return the templateId
     */
    public String getTemplateId() {
        return this.templateId;
    }

    /**
     * @param templateId the templateId to set
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * @return the templateVersion
     */
    public Double getTemplateVersion() {
        return this.templateVersion;
    }

    /**
     * @param templateVersion the templateVersion to set
     */
    public void setTemplateVersion(Double templateVersion) {
        this.templateVersion = templateVersion;
    }

    public Actor getInitiator() {
        return this.initiator;
    }

    public void setInitiator(Actor initiator) {
        this.initiator = initiator;
    }

    public Actor getResponder() {
        return this.responder;
    }

    public void setResponder(Actor responder) {
        this.responder = responder;
    }

    public Map<String, Metric> getMetrics() {
        return this.metrics;
    }

    public void setMetrics(Map<String, Metric> metrics) {
        this.metrics = metrics;
    }
    
    @Override
    public Context clone() {
    	Context ctx = new Context();
    	ctx.setInitiator(initiator);
    	ctx.setResponder(responder);
    	ctx.setTemplateId(templateId);
    	ctx.setTemplateVersion(templateVersion);
    	for(Metric metric : metrics.values()){
    		Metric m = metric.clone();
    		ctx.getMetrics().put(m.getId(), m);
    	}
    	return ctx;
    }

}
