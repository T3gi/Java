/*
* ІО - 33 Титок Володимир
* Залікова №3324
*/

public class Lab2 {
    
    // C3 = 3324 % 3 = 0 - StringBuilder
    // C17 = 3324 % 17 = 9 - Задано текст та масив слів. Підрахувати у скількох реченнях зустрічається кожне слово масиву.

    public static int[] wordsCounter(StringBuilder text, StringBuilder[] words){
        int result[] = new int[words.length];
        int semi_result[];
        int next_dot;
        int next_exlamation;
        int next_question;
        int next_end;
        int next_comma;
        int next_space;
        int next_separator;
        StringBuilder word = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        StringBuilder textInput = text;
        while (textInput.length() != 0){
            next_dot = textInput.indexOf(".");
            next_exlamation = textInput.indexOf("!");
            next_question = textInput.indexOf("?");
            if (next_dot == -1) {
                next_dot = textInput.length() + 100;
            }
            if (next_exlamation == -1) {
                next_exlamation = textInput.length() + 100;
            }
            if (next_question == -1) {
                next_question = textInput.length() + 100;
            }
            next_end = Math.min(next_dot, next_exlamation);
            next_end = Math.min(next_end, next_question);
            if (next_end == textInput.length() + 100){
                next_end = textInput.length();
            }
            sentence = new StringBuilder(textInput.substring(0, next_end));
            sentence.append(" ");
            semi_result = new int[words.length];
            while (sentence.length() != 0){
                next_comma = sentence.indexOf(",");
                next_space = sentence.indexOf(" ");
                if (next_comma < 1){
                    next_comma = sentence.length() + 100;
                }
                if (next_space < 1){
                    next_space = sentence.length() + 100;
                }
                next_separator = Math.min(next_comma, next_space);
                if (next_separator == sentence.length() + 100){
                    next_separator = sentence.length();
                }
                word = new StringBuilder(sentence.substring(0, next_separator).toLowerCase());
                for (int i = 0; i < words.length; i++){
                    if (word.toString().equals(words[i].toString())){
                        semi_result[i]++;
                    }
                }
                if (next_separator == next_comma){
                    next_separator++;
                }
                sentence = new StringBuilder(sentence.substring(next_separator + 1));
            }
            if (next_end + 2 <= textInput.length()){
                next_end += 2;
            } else if (next_end + 1 <= textInput.length()){
                next_end++;
            }
            textInput = new StringBuilder(textInput.substring(next_end));
            for (int i = 0; i < result.length; i++){
                if (semi_result[i] > 0){
                    result[i]++;
                }
            }
        }

        return result;
    }

    public static void printCounter(StringBuilder[] words, int[] counter){
        for (int i = 0; i < words.length; i++){
            System.out.println(words[i] + ": " + counter[i] + " sentences");
        }
    }

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("Hello darkness my old friend, nice to meet you here again. Hello world, goodbye happiness and my friend. Here we go again my friend."); 
        StringBuilder[] words = {new StringBuilder("hello"), new StringBuilder("friend"), new StringBuilder("again"), new StringBuilder("here")};
        int[] counter = wordsCounter(text, words);
        printCounter(words, counter);
    }

}
