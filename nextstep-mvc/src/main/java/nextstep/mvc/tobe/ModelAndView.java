package nextstep.mvc.tobe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private Object view;
    private Map<String, Object> model = new HashMap<String, Object>();

    public ModelAndView() {
    }

    public ModelAndView(String viewName) {  // viewName (index.html, ...)
        this.view = viewName;
    }

    public ModelAndView(View view) {  // view (JspView, JsonView, ...)
        this.view = view;
    }

    public ModelAndView(Object view) {  // json
        this.view = view;
    }

    public ModelAndView addObject(String attributeName, Object attributeValue) {
        model.put(attributeName, attributeValue);
        return this;
    }

    public Object getObject(String attributeName) {
        return model.get(attributeName);
    }

    public Map<String, Object> getModel() {
        return Collections.unmodifiableMap(model);
    }

    public Object getView() {
        return view;
    }
}
