/*
* ІО - 33 Титок Володимир
* Залікова №3324
*/

public class Lab2 {
    
    // C3 = 3324 % 3 = 0 - StringBuilder
    // C17 = 3324 % 17 = 9 - Задано текст та масив слів. Підрахувати у скількох реченнях зустрічається кожне слово масиву.

    public static int[] wordsCounter(StringBuilder text, StringBuilder[] words){
        int result[] = new int[words.length];
        int next_dot;
        int next_comma;
        int next_space;
        int next_separator;
        StringBuilder word = new StringBuilder();
        while (!text.isEmpty()){
            next_dot = text.indexOf(".");
            next_comma = text.indexOf(",");
            next_space = text.indexOf(" ");
            if (next_dot < 1){
                next_dot = text.length() + 100;
            }
            if (next_comma < 1){
                next_comma = text.length() + 100;
            }
            if (next_space < 1){
                next_space = text.length() + 100;
            }
            next_separator = Math.min(next_dot, next_comma);
            next_separator = Math.min(next_separator, next_space);
            word = new StringBuilder(text.substring(0, next_separator).toLowerCase());
            for (int i = 0; i < words.length; i++){
                if (word.toString().equals(words[i].toString())){
                    result[i]++;
                }
            }
            if (next_separator == next_comma || next_separator == next_dot){
                next_separator++;
            }
            text.delete(0, next_separator + 1);
        }
        return result;
    }

    public static void printCounter(StringBuilder[] words, int[] counter){
        for (int i = 0; i < words.length; i++){
            System.out.println(words[i] + ": " + counter[i] + " times");
        }
    }

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("Hello darkness my old friend, nice to meet you here again. Hello world, goodbye happiness and my friend. Here we go again my friend."); 
        StringBuilder[] words = {new StringBuilder("hello"), new StringBuilder("friend"), new StringBuilder("again"), new StringBuilder("here")};
        int[] counter = wordsCounter(text, words);
        printCounter(words, counter);
    }

}
