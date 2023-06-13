package myboard.common;

import java.util.HashMap;
import java.util.Map;

public class Request {
    String ActionCode;
    Map<String, Object> params;

    public String getActionCode() {
        return ActionCode;
    }

    public void setActionCode(String actionCode) {
        ActionCode = actionCode;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
    public Request() {
        params = new HashMap<>();
    }

    public void setParameter(String key, Object value) {
        params.put(key, value);
    }
    public Object getParameter(String key) {
        return params.get(key);
    }

}
