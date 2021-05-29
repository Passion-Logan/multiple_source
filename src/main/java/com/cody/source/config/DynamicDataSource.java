package com.cody.source.config;

import com.cody.source.context.DynamicDataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ClassName: DynamicDataSource
 *
 * @author WQL
 * @Description:
 * @date: 2021/5/29 16:34
 * @since JDK 1.8
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 动态获取数据源
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getContextKey();
    }

}
