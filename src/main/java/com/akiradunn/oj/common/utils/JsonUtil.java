/*
 *  JsonUtil.java
 *  Copyright 2022 Qunhe Tech, all rights reserved.
 *  Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */
package com.akiradunn.oj.common.utils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * @author xiaoyang
 */
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final TypeFactory TF;

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        TF = MAPPER.getTypeFactory();
    }

    /**
     * obj 转 json
     *
     * @param obj
     * @return
     */
    public static String toJsonString(Object obj) {
        try {
            if (obj instanceof String) {
                return (String) obj;
            }
            return MAPPER.writeValueAsString(obj);
        } catch (final Exception ex) {
            return "";
        }
    }

    /**
     * json 转 Collection<obj>
     *
     * @param jsonStr
     * @param collectionClass
     * @param elementClass
     * @param <T>
     * @return
     */
    public static <T> T toObject(String jsonStr, Class<? extends Collection> collectionClass, Class<?> elementClass) {
        try {
            return MAPPER.readValue(jsonStr, MAPPER.getTypeFactory().constructCollectionType(collectionClass, elementClass));
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * json 转 obj
     *
     * @param text
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T toObject(String text, Type type) {
        JavaType javaType = constructType(type);
        try {
            return MAPPER.readValue(text, javaType);
        } catch (IOException ex) {
            return null;
        }
    }

    private static final JavaType constructType(Type type) {
        return TypeFactory.defaultInstance().constructType(type);
    }

    /**
     * ojb 转 byte[]
     *
     * @param obj
     * @return
     */
    public static byte[] toBytes(final Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return MAPPER.writeValueAsBytes(obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("toBytes error");
        }
    }

    /**
     * bytes 转 <T>
     *
     * @param bytes
     * @param clz
     * @return
     */
    public static <T> T toObject(byte[] bytes, Class<T> clz) {
        if (bytes == null) {
            return null;
        }
        try {
            return MAPPER.readValue(bytes, clz);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * bytes 转 <T>
     *
     * @param bytes
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T toObject(byte[] bytes, TypeReference<T> type) {
        if (bytes == null) {
            return null;
        }
        try {
            return MAPPER.readValue(bytes, type);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * String 转 <T>
     *
     * @param jsonStr
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T toObject(String jsonStr, TypeReference<T> type) {
        if (jsonStr == null) {
            return null;
        }
        try {
            return MAPPER.readValue(jsonStr, type);
        } catch (IOException e) {
            return null;
        }
    }

}
