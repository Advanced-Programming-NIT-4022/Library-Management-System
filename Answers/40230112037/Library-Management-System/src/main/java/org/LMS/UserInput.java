package org.LMS;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {

    public static String sqlLikeRegex(String searchString) {
        return searchString.replace("!", "\\!").replace("%", "\\%").replace("_", "\\_").replace("[", "\\[");
    }
}