package org.example;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String actioncode;
    private Map<String, String> params = new HashMap<>();

    public Request(String command){
        String[] commandBits = command.split("\\?", 2);
        actioncode = commandBits[0];

        if (commandBits.length == 1){return;}

        String[] paramsBits = new String[]{commandBits[1]};
        for (String paramsStr : paramsBits){
            String[] paramsStrBits = paramsStr.split("=", 2);
            String key = paramsStrBits[0];
            String value = paramsStrBits[1];

            params.put(key, value);
        }

    }
    public String getActioncode() {
        return actioncode;
    }
    public int getIntParams(String name, int defaultValue){
        try{
            return Integer.parseInt(params.get(name));
        }catch (NumberFormatException e){

        }
        return defaultValue;
    }
}
