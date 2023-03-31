package _6_ZigZag_Conversion;

public class Token {
    String token;
    int stringUnitLength;
    int nRows;
    int orderIdx = 0;
    int returnStrLength;

    public Token(String token, int stringUnitLength, int nRows) {
        this.token = token;
        this.nRows = nRows;
        this.stringUnitLength = stringUnitLength;
    }

    StringBuilder getNext(){
        StringBuilder rStr = new StringBuilder();

        try {
            if(returnStrLength >= token.length()){
                // return empty string
                return rStr;
            }

            if(orderIdx%(nRows + 1) == 0){
                // return "up" or "down" value
                return rStr.append(token.charAt(orderIdx));
            }

            // add middle value
            rStr.append(token.charAt(orderIdx));

            int endIdx = stringUnitLength - orderIdx;

            if(orderIdx != endIdx && endIdx < token.length()){
                // add mirror value of middle value if exists
                rStr.append(token.charAt(endIdx));
            }

            return rStr;
        } finally {
            returnStrLength = returnStrLength + rStr.length();
            orderIdx++;
        }
    }

    @Override
    public String toString() {
        return token;
    }
}
