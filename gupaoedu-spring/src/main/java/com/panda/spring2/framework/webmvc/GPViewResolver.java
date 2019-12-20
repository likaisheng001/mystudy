package com.panda.spring2.framework.webmvc;/**
 * Created by My on 2019-12-16.
 */

import com.sun.istack.internal.Nullable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Locale;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 20:33:35 2019-12-16
 * @Modified By:
 */
public class GPViewResolver {
    private File templateRootDir;
    private final String DEFAULT_TEMPLATE_SUFFX = ".html";
    //private String viewName;

    public GPViewResolver(String templateRoot) {
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        templateRootDir = new File(templateRootPath);
    }

    public GPView resolveViewName(String viewName,Locale locale){
        if (viewName == null || "".equals(viewName.trim())){
            return null;
        }
        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFX) ? viewName : (viewName + DEFAULT_TEMPLATE_SUFFX);
        //File templateFile = new File((templateRootDir.getPath() + "/" + viewName ).replaceAll("/+","/"));
        File templateFile = new File((templateRootDir.getPath() + "\\" + viewName ).replaceAll("]\\+","\\"));
        return new GPView(templateFile);
    }

}
