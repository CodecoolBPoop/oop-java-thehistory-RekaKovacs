package com.codecool.thehistory;

import java.util.*;
import java.util.regex.Pattern;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] words;
        words = Pattern.compile("\\s+").split(text);
        for (String word : words) {
            wordsArrayList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        do {
            wordsArrayList.remove(wordToBeRemoved);
        } while (wordsArrayList.contains(wordToBeRemoved));
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        do {
            wordsArrayList.set(wordsArrayList.indexOf(from), to);
        } while (wordsArrayList.contains(from));
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
//        Iterator wordOriginList = wordsArrayList.iterator();
        int indexStartReplace = 0;
        do {
            if (wordsArrayList.get(indexStartReplace).equals(fromWords[0])) {
                int counterEquals = 0;
                for (int i = 0; i < fromWords.length; i++) {
                   if (wordsArrayList.get(indexStartReplace+i).equals(fromWords[i])) {
                       counterEquals++;
                   }
                   else {
                       break;
                   }
                }
                if (counterEquals == fromWords.length) {
                    for (int j = 0; j < fromWords.length ; j++) {
                        wordsArrayList.remove(indexStartReplace);
                    }
                    for (int k = 0; k < toWords.length; k++) {
                        wordsArrayList.add(indexStartReplace, toWords[k]);
                        indexStartReplace ++;
                    }
                    indexStartReplace--;
                }
            }
            indexStartReplace++;
        } while (indexStartReplace + fromWords.length -1 < wordsArrayList.size());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
