package org.example;


import java.util.HashMap;
import java.util.Map;

public class Request {
    private static String actioncode;
    private Map<String, String> params = new HashMap<>();
    public Request(String command){
        String[] commandBits = command.split("\\?", 2);

        actioncode = commandBits[0];

        if (commandBits.length == 1)return;

        String[] bitscommand = new String[]{commandBits[1]};
        for (String paramsStr : bitscommand){
            String[] paramsBits = paramsStr.split("=", 2);
            String key = paramsBits[0];
            String value = paramsBits[1];

            params.put(key, value);
        }
    }
    public static String getActioncode() {
        return actioncode;
    }

    public int DefaultValue(String name, int DefaultValue){
        try {
            return Integer.parseInt(params.get(name));
        }catch (NumberFormatException e){

        }
        return DefaultValue;
    }
}
