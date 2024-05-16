import java.util.ArrayList;
import java.util.List;

class Util {
    // warp an string to the desiered line width
    public static List<String> stringWrap(String string, int maxChar) {
        List<String> subLines = new ArrayList<String>();
        int length = string.length();
        int start = 0;
        int end = maxChar;
        if (length > maxChar) {
            int noOfLines = (length / maxChar) + 1;
            int endOfStr[] = new int[noOfLines];
            for (int f = 0; f < noOfLines - 1; f++) {
                int end1 = maxChar;
                endOfStr[f] = end;
                if (string.charAt(end - 1) != ' ') {
                    if (string.charAt(end - 2) == ' ') {
                        subLines.add(string.substring(start, end - 1));
                        start = end - 1;
                        end = end - 1 + end1;
                    } else if (string.charAt(end - 2) != ' '
                            && string.charAt(end) == ' ') {
                        subLines.add(string.substring(start, end));
                        start = end;
                        end = end + end1;
                    } else if (string.charAt(end - 2) != ' ') {
                        subLines.add(string.substring(start, end) + "-");
                        start = end;
                        end = end + end1;
                    } else if (string.charAt(end + 2) == ' ') {
                        int lastSpaceIndex = string.substring(start, end)
                                .lastIndexOf("");
                        subLines.add(string.substring(start, lastSpaceIndex));

                        start = lastSpaceIndex;
                        end = lastSpaceIndex + end1;
                    }
                } else {
                    subLines.add(string.substring(start, end));
                    start = end;
                    end = end + end1;
                }
            }
            subLines.add(string.substring(endOfStr[noOfLines - 2], length));
        }
        if (subLines.size() == 0) subLines.add(string);
        return subLines;
    }

    // Convert decimal to hexa
    public static String toHex(int decimal){
        int rem;  
        String hex="";   
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
        while(decimal>0)  
        {  
            rem=decimal%16;   
            hex=hexchars[rem]+hex;   
            decimal=decimal/16;  
        }  
        return hex;  
    }

    public static boolean isPassStrong(String password) {
        boolean hasUpper, hasLower, hasNumber, hasSymbol;
        hasUpper = hasLower = hasNumber = hasSymbol = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i)))
                hasLower = true;
            else if (Character.isUpperCase(password.charAt(i)))
                hasUpper = true;
            else if (Character.isDigit(password.charAt(i)))
                hasNumber = true;
            else
                hasSymbol = true;
        }

        return hasUpper && hasLower && hasNumber && hasSymbol;
    }
}
