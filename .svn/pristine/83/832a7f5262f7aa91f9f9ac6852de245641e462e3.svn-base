package com.common.filter;

import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * sql注入攻击拦截
 * @author s
 */
public class SqlInjectFilter implements Filter
{
    FilterConfig filterConfig = null;

    /**
     * 初始化
     * @param filterConfig filterConfig
     * @throws ServletException 异常
     */
    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.filterConfig = filterConfig;
    }

    public void destroy()
    {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String noLoginPaths = filterConfig.getInitParameter("noLoginPaths");  //获取<init-param> 中的key和value  ,
        try
        {
        	System.out.println("sql过滤器");
            // 获得所有请求参数名
            Enumeration params = req.getParameterNames();
            String sql = "";
            while (params.hasMoreElements())
            {
                // 得到参数名
                String name = params.nextElement().toString();
                // 得到参数对应值
                String[] value = req.getParameterValues(name);
                for (int i = 0; i < value.length; i++)
                {
                    sql = sql + value[i];
                }
            }
            // 截取我要拦截的字段
            sql = getfilte(sql);
            // 有sql关键字，跳转到error.html
            if (sqlValidate(sql))
            {
                res.setHeader("SESSIONSTATUS", "TIMEOUT");
                res.setHeader("CONTEXTPATH", req.getContextPath() + "/pwbzh_module/500.jsp");
                res.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return;
                // throw new IOException("您发送请求中的参数中含有非法字符");

            }

            chain.doFilter(request, response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    // 效验
    protected static boolean sqlValidate(String str)
    {
        str = str.toLowerCase();// 统一转为小写
        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" + "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" + "table|from|grant|use|group_concat|column_name|" + "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" + "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";// 过滤掉的sql关键字，可以手动添加
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++)
        {
            // 循环检测，判断在请求参数当中是否包含SQL关键字
            if (str.indexOf(badStrs[i]) >= 0)
            {
                return true;
            }
        }
        return false;
    }

    // 截取需要拦截的字段
    protected static String getfilte(String str)
    {
        int idex = str.indexOf("filter");
        String ss = "";
        if (idex < 0)
        {
            return ss;
        }
        if (str.indexOf(",", idex) < 0)
        {
            ss = str.substring(idex, str.length());
        }
        else
        {
            ss = str.substring(idex, str.indexOf(",", idex));
        }
        return ss;
    }
}