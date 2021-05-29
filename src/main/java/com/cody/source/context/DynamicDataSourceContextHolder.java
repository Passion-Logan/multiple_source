package com.cody.source.context;

import com.cody.source.constants.DataSourceConstants;

/**
 * ClassName: DynamicDataSourceContextHolder
 * 动态数据源名称上下文处理
 *
 * @author WQL
 * @Description:
 * @date: 2021/5/29 16:45
 * @since JDK 1.8
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> DATASOURCE_CONTEXT_KEY_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param key
     */
    public static void setContextKey(String key) {
        System.out.println("切换数据源：" + key);
        DATASOURCE_CONTEXT_KEY_HOLDER.set(key);
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static String getContextKey() {
        String key = DATASOURCE_CONTEXT_KEY_HOLDER.get();
        return key == null ? DataSourceConstants.DS_KEY_MASTER : key;
    }

    /**
     * 删除当前数据源
     */
    public static void removeContextKey() {
        DATASOURCE_CONTEXT_KEY_HOLDER.remove();
    }

}
