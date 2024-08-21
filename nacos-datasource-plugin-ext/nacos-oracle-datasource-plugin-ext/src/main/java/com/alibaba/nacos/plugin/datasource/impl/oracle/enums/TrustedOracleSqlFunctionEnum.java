package com.alibaba.nacos.plugin.datasource.impl.oracle.enums;

import java.util.HashMap;
import java.util.Map;

public enum TrustedOracleSqlFunctionEnum {

    /**
     * NOW().
     */
    NOW("NOW()", "sysdate");

    private static final Map<String, TrustedOracleSqlFunctionEnum> LOOKUP_MAP = new HashMap<>();

    static {
        for (TrustedOracleSqlFunctionEnum entry : TrustedOracleSqlFunctionEnum.values()) {
            LOOKUP_MAP.put(entry.functionName, entry);
        }
    }

    private final String functionName;

    private final String function;

    TrustedOracleSqlFunctionEnum(String functionName, String function) {
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
        TrustedOracleSqlFunctionEnum entry = LOOKUP_MAP.get(functionName);
        if (entry != null) {
            return entry.function;
        }
        throw new IllegalArgumentException(String.format("Invalid function name: %s", functionName));
    }
}

