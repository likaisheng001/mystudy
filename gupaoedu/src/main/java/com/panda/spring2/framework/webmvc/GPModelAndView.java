package com.panda.spring2.framework.webmvc;/**
 * Created by My on 2019-12-16.
 */

import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:24:46 2019-12-16
 * @Modified By:
 */
public class GPModelAndView {
    private String viewName;
    private Map<String,?> model;

    public GPModelAndView(String viewName){
        this.viewName = viewName;
    }
    public GPModelAndView(String viewName,Map<String,?> model){
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }

    public void setModel(Map<String, ?> model) {
        this.model = model;
    }
}
