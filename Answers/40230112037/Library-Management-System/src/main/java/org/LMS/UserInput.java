package org.LMS;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    public static String[] argumentsToArray(String input) {
        Pattern pattern = Pattern.compile("(?>(?<bare>[^\\\"\\s](?:\\\\\\\\|\\\\ |[^ ])*?)(?> |$)|(?>\\\"(?<quo>(?:\\\\\\\\|\\\\\\\"|[^\\\"])*?)\\\"))");
        Matcher matcher = pattern.matcher(input);
        ArrayList<String> result = new ArrayList<String>();
        while (matcher.find()) {
            if (matcher.group("bare") != null) {
                result.add(matcher.group("bare").replaceAll("\\\\\\\\", "\\\\").replaceAll("\\\\ ", " "));
            } else {
                result.add(matcher.group("quo").replaceAll("\\\\\\\\", "\\\\").replaceAll("\\\\\"", "\""));
            }
        }
        return result.toArray(new String[0]);
    }

    public static String sqlLikeRegex(String searchString) {
        return searchString.replace("!", "\\!").replace("%", "\\%").replace("_", "\\_").replace("[", "\\[");
    }
}