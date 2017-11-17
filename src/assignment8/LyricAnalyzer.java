package assignment8;

import java.io.*;
import java.util.*;

public class LyricAnalyzer {
    int sum = 1;
    private HashMap<String, ArrayList<Integer>> map;

    LyricAnalyzer() {
        map = new HashMap<>();
    }

    public void read(File file) throws FileNotFoundException {
        map = new HashMap<>();
        FileReader reader = new FileReader(file);
        Scanner fileIn = new Scanner(reader);
        while (fileIn.hasNextLine()) {
            String[] s = fileIn.nextLine().split(" ");
            for (int i = 0; i < s.length - 1; i++) {
                add(s[i], sum);
                sum++;
            }
            add(s[s.length - 1], -sum);
            sum++;
        }
    }


    private void add(String lyricWord, int wordPosition) {
        if (!map.containsKey(lyricWord)) {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(wordPosition);
            map.put(lyricWord, a);
        } else {
            map.get(lyricWord).add(wordPosition);
        }
    }

    public void displayWords() {
        TreeSet<String> treeSet = new TreeSet(map.keySet());
        for (String s : treeSet) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < map.get(s).size(); i++) {
                sb.append(map.get(s).get(i));
                if (i != map.get(s).size() - 1) sb.append(",");
            }
            System.out.println(s + ": " + sb.toString());
        }

    }

    public void writeLyrics(File file) throws IOException {
        String[] s = new String[sum];
 //       s[0] = "";
//        for (int i = 1; i <= sum; i++) {
//            for (String s1 : map.keySet()) {
//                if (map.get(s1).contains(i)) s[i] = s1 + " ";
//                if (map.get(s1).contains(-i)) s[i] = s1 + "\n";
//            }
        //}
        for(String s1 : map.keySet()){
            for(int index : map.get(s1)){
                if(index<0) s[-index] =  s1 + "\n";
                else s[index] = s1 + " ";
            }
        }
        s[sum]="";
        FileWriter writer = new FileWriter(file);
        PrintWriter pw = new PrintWriter(writer);
        for(String ss : s) pw.print(ss);
        pw.close();
        writer.close();
    }

    public int count() {
        return map.size();

    }

    public String mostFrequentWord() {
        int max = 0;
        String location = "";
        TreeSet<String> treeSet = new TreeSet(map.keySet());
        for(int i =0;i<count();i++) {
            for (String s : treeSet) {
                if(map.get(s).size()>max){
                    max = map.get(s).size();
                    location = s;}
            }
        }
        return location;
    }
}


 class Lyric {
    public static void main(String[] args) throws IOException {
        LyricAnalyzer l = new LyricAnalyzer();
        System.out.println("Please enter a file name:");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        File f = new File(name);
        l.read(f);
        l.displayWords();
        System.out.println();
        System.out.println("The Most Frequent Word");
        System.out.println(l.mostFrequentWord());
        l.writeLyrics(f);
    }
}
