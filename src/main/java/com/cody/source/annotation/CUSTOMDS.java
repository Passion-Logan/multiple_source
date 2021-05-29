package com.cody.source.annotation;

import com.cody.source.constants.DataSourceConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: CUSTOMDS
 *
 * @author WQL
 * @Description:
 * @date: 2021/5/29 16:52
 * @since JDK 1.8
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CUSTOMDS {

    /**
     * 数据源名称
     *
     * @return
     */
    String value() default DataSourceConstants.DS_KEY_MASTER;
}
