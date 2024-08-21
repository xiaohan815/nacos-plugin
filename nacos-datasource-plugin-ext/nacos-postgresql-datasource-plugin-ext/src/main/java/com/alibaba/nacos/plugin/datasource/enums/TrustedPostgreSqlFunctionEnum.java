package com.alibaba.nacos.plugin.datasource.enums;

import java.util.HashMap;
import java.util.Map;

public enum TrustedPostgreSqlFunctionEnum {

    /**
     * NOW().
     */
    NOW("NOW()", "NOW()");

    private static final Map<String, TrustedPostgreSqlFunctionEnum> LOOKUP_MAP = new HashMap<>();

    static {
        for (TrustedPostgreSqlFunctionEnum entry : TrustedPostgreSqlFunctionEnum.values()) {
            LOOKUP_MAP.put(entry.functionName, entry);
        }
    }

    private final String functionName;

    private final String function;

    TrustedPostgreSqlFunctionEnum(String functionName, String function) {
        this.functionName = functionName;
        this.function = function;
    }

    /**
     * Get the function name.
     *
     * @param functionName function name
     * @return function
     */
    public static String getFunctionByName(String functionName) {
        TrustedPostgreSqlFunctionEnum entry = LOOKUP_MAP.get(functionName);
        if (entry != null) {
            return entry.function;
        }
        throw new IllegalArgumentException(String.format("Invalid function name: %s", functionName));
    }
}

