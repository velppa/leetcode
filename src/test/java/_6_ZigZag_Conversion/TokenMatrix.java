package _6_ZigZag_Conversion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TokenMatrix {
    List<String> matrix;
    int middleLength;
    int nRows;

    public TokenMatrix(List<String> matrix, int nRows) {
        this.matrix = matrix;
        this.middleLength = (nRows - 2) <= 0 ? 0 : (nRows - 2);
        this.nRows = nRows;

        if(matrix.isEmpty()){
            new RuntimeException("Empty matrix!");
        }
    }

    String allProcess(){
        return IntStream.range(0, nRows).mapToObj(i -> columnProcessor(i)).collect(Collectors.joining());
    }

    String columnProcessor(int colIdx){
        if(colIdx%(middleLength + 1) == 0){
            return getUpColumnChars(colIdx);
        }

        return getMiddleColumnChars(colIdx);
    }

    char getChar(String s, int idx){
        if(idx >= s.length() || idx < 0){
            return '-';
        }
        return s.charAt(idx);
    }

    String getUpColumnChars(int columnIdx){
        return matrix.stream().map(s -> getChar(s, columnIdx)).filter(c -> c != '-').map(String::valueOf).collect(Collectors.joining());
    };

    String getMiddleColumnChars(int columnIdx){
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < matrix.size(); r++){
            if(columnIdx >= matrix.get(r).length()){
                continue;
            }

            sb.append(getChar(matrix.get(r), columnIdx));

            int endIdx = matrix.get(r).length() - columnIdx;

            if(columnIdx != endIdx){
                sb.append(getChar(matrix.get(r), endIdx));
            }

        }

        return sb.toString();
    }
}
