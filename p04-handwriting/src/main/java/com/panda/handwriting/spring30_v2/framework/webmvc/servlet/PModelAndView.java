package com.panda.handwriting.spring30_v2.framework.webmvc.servlet;/**
 * Created by My on 2020-04-12.
 */

import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:53:39 2020-04-12
 * @Modified By:
 */
public class PModelAndView {
    private String viewName;
    private Map<String,?> model;

    public PModelAndView(String viewName, Map<String, ?> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public PModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public Map<String, ?> getModel() {
        return model;
    }
}
