import java.util.ArrayList;
import java.util.regex.Pattern;

public class StringCalculator {

    private int calledCount;

    public int GetCalledCount() {
        return calledCount;
    }

    public int ReturnSameNumber(String number) throws Exception {
        if (Integer.parseInt(number) < 0) {
            throw new Exception("negatives not allowed " + number);
        }
        return Integer.parseInt(number);
    }

    public String NumberofDelimeterWithSingleAndVariableLength(String number)
    {
        String delimiter = null;
        String[] tokens = number.split("\n");

            String[] delimiterList = tokens[0].substring(3, tokens[0].length() - 1).split("\\]\\[");
            delimiter = "";
            for (String delim : delimiterList) {
                delimiter += Pattern.quote(delim) + "|";
            }
            delimiter = delimiter.substring(0, delimiter.length() - 1);
            return delimiter;
    }

    public int add(String number) throws Exception {
        if (number.isEmpty()) {
            calledCount++;
            return 0;
        } else if (number.length() == 1) {
            calledCount++;
            return ReturnSameNumber(number);
        } else {
            int sum = 0;
            ArrayList<String> NegativeElements = new ArrayList<>();
            if (number.startsWith("//")) {
                String delimiter = null;
                if (number.startsWith("[", 2)) {
                    String[] tokens = number.split("\n");
                    delimiter = ",";

                    if (tokens[0].startsWith("//[")) {
                        delimiter = NumberofDelimeterWithSingleAndVariableLength(number);
                    }

                    String numbersString = tokens[tokens.length - 1];
                    String[] numbers = numbersString.split(delimiter);

                    for (String num : numbers) {
                        if (num.startsWith("-")) {
                            NegativeElements.add(num);
                        } else if(Integer.parseInt(num.trim())<1000){
                            sum += Integer.parseInt(num.trim());
                        }
                    }
                } else {
                    int SeperatorIndex = number.indexOf("\n");
                    delimiter = number.substring(SeperatorIndex - 1, SeperatorIndex);
                    String numberSubstring = number.substring(SeperatorIndex + 1, number.length());
                    for (String iterator : numberSubstring.split(delimiter)) {
                        if (iterator.startsWith("-")) {
                            NegativeElements.add(iterator);
                        } else if(Integer.parseInt(iterator)<1000){
                            sum += Integer.parseInt(iterator);
                        }
                    }
                }
            } else {
                for (String num : number.replaceAll("\n", ",").split(",")) {
                    if(num.startsWith("-"))
                    {
                        NegativeElements.add(num);
                    }
                    else if(Integer.parseInt(num)<1000){
                        sum += Integer.parseInt(num);
                    }
                }
            }
            if (!NegativeElements.isEmpty()) {
                throw new RuntimeException("negatives not allowed " + NegativeElements.toString().replaceAll(" ", ""));
            } else {
                calledCount++;
                return sum;
            }
        }
    }
}




