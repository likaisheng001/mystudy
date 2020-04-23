package com.panda.handwriting.spring30_v3.framework.webmvc.servlet;/**
 * Created by My on 2020-04-12.
 */

import java.io.File;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:20:37 2020-04-12
 * @Modified By:
 */
public class PViewResolver {
    private final String DEFAULT_TEMPLATE_SUFFIX = ".html";
    private File templateRootDir;
    public PViewResolver(String templateRoot){
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        templateRootDir = new File(templateRootPath);
    }

    public PView resolveViewName(String viewName){
        if (null == viewName || "".equals(viewName.trim())){return null;}
        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFIX) ? viewName : (viewName + DEFAULT_TEMPLATE_SUFFIX);
        File templateFile = new File((templateRootDir.getPath() + "/" + viewName).replace("/+","/"));
        return new PView(templateFile);
    }
}
