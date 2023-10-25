package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@Getter
@Setter
public class Request {
    private Map<String, String> params = new HashMap<>();
    private String actioncode;
    public Request(String command){
        String[] commandBits = command.split("\\?",2);
        actioncode = commandBits[0];

        if (commandBits.length == 1){
            return;
        }

        String[] actioncode2 = new String[]{commandBits[1]};
        for (String paramsStr : actioncode2){
            String[] paramsBits = paramsStr.split("=", 2);
            String key = paramsBits[0];
            String value = paramsBits[1];

            params.put(key, value);
        }
    }
    public int getIntparams(String name, int defalutValue){
        try{
             return Integer.parseInt(params.get(name));
        }catch (NumberFormatException e){
        }
        return defalutValue;
    }
}
