package com.ohgiraffers.jwtsecurity.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConvertUtil {

    /* 오브젝트를 JSON 오브젝트로 변환 시키는 코드 */
    public static Object converObjectToJsonObject(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        JSONParser parser = new JSONParser();
        String convertJsonString;
        Object convertObj;

        try {
            /* JSON String으로 변경 */
            convertJsonString = mapper.writeValueAsString(obj);
            /* 다시 JSON 객체로 변경 */
            convertObj = parser.parse(convertJsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return convertObj;
    }
}
