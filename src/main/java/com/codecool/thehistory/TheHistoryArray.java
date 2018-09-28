package com.codecool.thehistory;

import java.util.Arrays;
import java.util.regex.*;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray;

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] words;
        words = Pattern.compile("\\s+").split(text);
        wordsArray = new String[words.length];
        java.lang.System.arraycopy(words, 0, wordsArray, 0, words.length);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        for (int i=0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(wordToBeRemoved)) {
                wordsArray[i] = "";
            }
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
//        wordsArray = new String[0];
        Arrays.fill(wordsArray, null);
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i=0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) {
                wordsArray[i] = wordsArray[i].replace(from, to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        int lengthDifference = fromWords.length - toWords.length;
        int indexStartReplace = 0;
        do {
            if (wordsArray[indexStartReplace].equals(fromWords[0])) {
                int counterEquals = 0;
                for (int j = 0; j < fromWords.length; j++) {
                    try {
                        if (wordsArray[indexStartReplace + j].equals(fromWords[j])) {
                            counterEquals++;
                        } else {
                            break;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        break;
                    }
                }

                if (counterEquals == fromWords.length) {
                    if (fromWords.length == toWords.length) {
                        java.lang.System.arraycopy(toWords, 0, wordsArray, indexStartReplace, toWords.length);

                    } else if (fromWords.length > toWords.length) {
                        String tempArray[] = new String[wordsArray.length - lengthDifference];
                        java.lang.System.arraycopy(wordsArray, 0, tempArray, 0, indexStartReplace);
                        java.lang.System.arraycopy(toWords, 0, tempArray, indexStartReplace, toWords.length);
                        java.lang.System.arraycopy(wordsArray, indexStartReplace + fromWords.length, tempArray,
                                indexStartReplace + toWords.length, (wordsArray.length - indexStartReplace - fromWords.length));
                        wordsArray = tempArray;
                    } else {
                        String tempArray[] = new String[wordsArray.length - lengthDifference];
                        java.lang.System.arraycopy(wordsArray, 0, tempArray, 0, indexStartReplace);
                        java.lang.System.arraycopy(toWords, 0, tempArray, indexStartReplace, toWords.length);
                        java.lang.System.arraycopy(wordsArray, indexStartReplace + fromWords.length, tempArray,
                                indexStartReplace + toWords.length, (wordsArray.length - indexStartReplace - fromWords.length));
                        wordsArray = tempArray;
                        indexStartReplace -= lengthDifference;
                    }
                }
            }
            indexStartReplace++;
        }
        while (indexStartReplace < wordsArray.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
