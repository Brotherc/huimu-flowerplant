package com.huimu.flowerplant.common.util;

import org.springframework.context.ApplicationContext;

public class SpringApplicationCxtUtil {

    private SpringApplicationCxtUtil() {
    }

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringApplicationCxtUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> aClass) {
        return applicationContext.getBean(aClass);
    }

}
