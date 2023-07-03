package com.huimu.flowerplant.common.util;

import com.baidu.fsg.uid.impl.CachedUidGenerator;

public class UidUtil {

    private UidUtil() {
    }

    public static Long nextId() {
        CachedUidGenerator uidGenerator = SpringApplicationCxtUtil.getBean(CachedUidGenerator.class);
        return uidGenerator.getUID();
    }

}
