package lambdaExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //ex 1

        Voter voter1 = new Voter("Ivan", "Sofia", "Paskalev", "61");
        Voter voter2 = new Voter("Petur", "Blagoevgrad", "Rakovski", "44");
        Voter voter3 = new Voter("Maria", "Sofia", "Kokiche", "12");
        Voter voter4 = new Voter("Cvetan", "Dimitrovgrad", "Vazov", "55");
        Voter voter5 = new Voter("Dimitur", "Sofia", "Positano", "32");
        Voter voter6 = new Voter("Georgi", "Sofia", "Positano", "31");

        List<Voter> voterList = new ArrayList<>();

        voterList.add(voter1);
        voterList.add(voter2);
        voterList.add(voter3);
        voterList.add(voter4);
        voterList.add(voter5);
        voterList.add(voter6);

        voterList = voterList.stream()
                .filter(voter -> voter.getCity().compareTo("Sofia") == 0)
                .sorted(Comparator.comparing(Voter::getStreet)
                        .thenComparing(Voter::getAddress))
                .collect(Collectors.toList());

        System.out.println(voterList);


        //ex 2

        StringComparison string1 = new StringComparison("hello");
        StringComparison string2 = new StringComparison("greetings");
        StringComparison string3 = new StringComparison("friend");
        StringComparison string4 = new StringComparison("brother");
        StringComparison string5 = new StringComparison("s1");

        List<StringComparison> stringList = new ArrayList<>();

        stringList.add(string1);
        stringList.add(string2);
        stringList.add(string3);
        stringList.add(string4);
        stringList.add(string5);

        stringList = stringList.stream()
                .sorted(Comparator.comparing(string -> string.getString().length()))
                .collect(Collectors.toList());

        String stringWithLowestLength = stringList.get(0).toString();
        String stringWithHighestLength = stringList.get(stringList.size()-1).toString();
        int lowestLength = stringWithLowestLength.length();
        int highestLength = stringWithHighestLength.length();
        System.out.println();
        System.out.println("Lowest length: " + lowestLength + "\nHighest length: " + highestLength);

        //ex 3
        String alphabeticRegex = "^[a-zA-Z]+$";
        String numericRegex = "\\d+";
        String specialSymbolsRegex = "[^a-zA-Z\\d]+";

        //Alphabetic check

        StringComparison alphabeticCheck1 = new StringComparison("hello");
        StringComparison alphabeticCheck2 = new StringComparison("world");
        StringComparison alphabeticCheck3 = new StringComparison("friend");
        StringComparison alphabeticCheck4 = new StringComparison("brother");
        //StringComparison alphabeticCheck5 = new StringComparison("11hello1");


        List<StringComparison> alphabeticList = new ArrayList<>();
        alphabeticList.add(alphabeticCheck1);
        alphabeticList.add(alphabeticCheck2);
        alphabeticList.add(alphabeticCheck3);
        alphabeticList.add(alphabeticCheck4);
        //alphabeticList.add(alphabeticCheck5);


        boolean alphabeticCharCheck = regexStringCheck(alphabeticList, alphabeticRegex);
        System.out.println();
        System.out.println(alphabeticCharCheck + ", " + alphabeticList);

        //Numeric Check

        StringComparison numericCheck1 = new StringComparison("1");
        StringComparison numericCheck2 = new StringComparison("222");
        StringComparison numericCheck3 = new StringComparison("33333");
        StringComparison numericCheck4 = new StringComparison("4444");
        //StringComparison numericCheck5 = new StringComparison("4444AA");


        List<StringComparison> numericCheckList = new ArrayList<>();
        numericCheckList.add(numericCheck1);
        numericCheckList.add(numericCheck2);
        numericCheckList.add(numericCheck3);
        numericCheckList.add(numericCheck4);
        //numericCheckList.add(numericCheck5);

        boolean numericCharCheck = regexStringCheck(numericCheckList, numericRegex);
        System.out.println();
        System.out.println(numericCharCheck + ", " + numericCheckList);


        //Special Symbols Check
        StringComparison specialCheck1 = new StringComparison("!!!");
        StringComparison specialCheck2 = new StringComparison("@@@#%$");
        StringComparison specialCheck3 = new StringComparison("$#$#");
        StringComparison specialCheck4 = new StringComparison("%$*");
        //StringComparison specialCheck5 = new StringComparison("%$f*");


        List<StringComparison> specialCheckList = new ArrayList<>();
        specialCheckList.add(specialCheck1);
        specialCheckList.add(specialCheck2);
        specialCheckList.add(specialCheck3);
        specialCheckList.add(specialCheck4);
        //specialCheckList.add(specialCheck5);

        boolean specialCharCheck = regexStringCheck(specialCheckList, specialSymbolsRegex);
        System.out.println();
        System.out.println(specialCharCheck + ", " + specialCheckList);

    }
    static boolean regexStringCheck(List<StringComparison> listToCheck, String regex){
        //String alphabeticRegex = "^[a-zA-Z]+$";
        List<StringComparison> listToCheck2 = listToCheck.stream()
                .filter(string -> string.getString().matches(regex))
                .collect(Collectors.toList());

        int listLength = listToCheck.size();
        int filteredListLength = listToCheck2.size();
        return listLength == filteredListLength;
    }
}
