package es.us.isa.aml.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author AntonioGamez
 */
public class ResourceState {

    private Map<String, Map<Long, String>> resourcesStateMap;

    public ResourceState() {
        resourcesStateMap = new HashMap<String, Map<Long, String>>();
    }

    public ResourceState(Map<String, Map<Long, String>> resourceStateMap) {
        this.resourcesStateMap = resourceStateMap;
    }

    public Map<String, Map<Long, String>> getResourcesStateMap() {
        return resourcesStateMap;
    }

    public void setResourceStateMap(Map<String, Map<Long, String>> resourceStateMap) {
        this.resourcesStateMap = resourceStateMap;
    }

    public Map<Long, String> getAllResourceStates(String resource) {
        if (resourcesStateMap.get(resource) != null) {
            return resourcesStateMap.get(resource);
        }
        return new HashMap<Long, String>();
    }
//ToDo: timestamps generados a la vez son iguales, ver que sucede aqui!!!!

    public void addResourceStateChange(String resource, String state, Long timestamp) {
        if (resourcesStateMap.containsKey(resource)) {
            if (resourcesStateMap.get(resource) != null && !resourcesStateMap.get(resource).containsKey(timestamp)) {
                resourcesStateMap.get(resource).put(timestamp, state);
            }
        } else {
            Map<Long, String> mp = new HashMap<Long, String>();
            mp.put(timestamp, state);
            resourcesStateMap.put(resource, mp);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.resourcesStateMap);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResourceState other = (ResourceState) obj;
        if (!Objects.equals(this.resourcesStateMap, other.resourcesStateMap)) {
            return false;
        }
        return true;
    }

    @Override
    public ResourceState clone() {
        HashMap<String, Map<Long, String>> a = new HashMap<String, Map<Long, String>>();
        a.putAll(getResourcesStateMap());
        ResourceState p = new ResourceState(a);
        return p;
    }

}
