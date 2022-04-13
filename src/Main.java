import java.util.*;

public class Main {
    public static void main(String[] args) {

        String inputString = "sdfgabcwetrrytruyrtuabcpotre!@#abcprtort";
        ArrayList<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();

        resultList.add(processString(inputString, "abc"));
        resultList.add(processString(inputString, "s"));
        resultList.add(processString(inputString, "r"));
        resultList.add(processString(inputString, "zi"));

        printResult(resultList);
    }

    private static HashMap<String, String> processString(String inputStr, String separator) {
        HashMap<String, String> result = new LinkedHashMap<String, String>();

        int count = 0;

        String[] split = inputStr.split(separator);
        List<String> storedItems = new ArrayList<>(List.of(split));

        if (inputStr.contains(separator)) {
            count = split.length - 1;
            result.put("Count", Integer.toString(count));
            if (inputStr.startsWith(separator)) {
                result.put("Prefix", "no Prefix");
            } else {
                result.put("Prefix", inputStr.substring(0, inputStr.indexOf(separator)));
            }
            storedItems.remove(0);
            Collections.sort(storedItems);
            result.put("sortedItems", String.join(" ", storedItems));

        } else {
            count = 1;
            result.put("Count", Integer.toString(count));
            result.put("Prefix", "no Prefix");
            result.put("sortedItems", inputStr);
        }

        StringBuilder evenChars = new StringBuilder();
        for (int i = 2; i < inputStr.length(); i += 2) {
            evenChars.append(inputStr.charAt(i));
        }
        result.put("evenChars", evenChars.toString());

        return result;
    }

    private static void printResult(ArrayList<HashMap<String, String>> resultList) {
        /*
    		Below is an example output when executed with inputString = "abcdef SEP gabcwet SEP sds SEP dsfg SEP fro", separator = "SEP"

    		Count: 4
    		Prefix: abcdef
    		sortedItems: dsfg fro gabcwet sds
    		evenChars: aceSPaceSPdSPsgEfo
		*/


        resultList
                .stream()
                .forEach(map ->
                        map.entrySet()
                                .stream()
                                .forEach(stringStringEntry ->
                                        System.out.println(String.format("%s : %s",
                                                stringStringEntry.getKey(), stringStringEntry.getValue()))));
        System.out.println("Pesho adding code");
       
    }
}
