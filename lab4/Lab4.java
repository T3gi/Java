/*
* ІО - 33 Титок Володимир
* Залікова №3324
*/

public class Lab4 {
    /**
     * Підраховує, у скількох реченнях зустрічається кожне слово із заданого масиву.
     *
     * @param text  Об'єкт тексту, що складається з речень.
     * @param words Масив слів, які необхідно шукати.
     * @return Масив цілих чисел, де i-й елемент відповідає кількості речень,
     * що містять i-те слово з масиву words.
     */
    public static int[] wordsCounter(Text text, Word[] words){
        int result[] = new int[words.length];
        int semiResult[];
        Word wordInput;
        for (Sentence sentence: text.sentences){
            semiResult = new int[words.length];
            for (Word word: sentence.words){
                word = word.toLowerCase();
                for (int i = 0; i < words.length; i++){
                    wordInput = words[i];
                    if (word.equals(wordInput)) {
                        semiResult[i]++;
                    }
                }
            }
            for (int i = 0; i < semiResult.length; i++){
                if (semiResult[i] > 0) {
                    result[i]++;
                }
            }
        }
        
        return result;
    }

    /**
     * Виводить результати підрахунку в консоль.
     *
     * @param words   Масив слів, що шукалися.
     * @param counter Масив результатів (кількість речень).
     */
    public static void printCounter(Word[] words, int[] counter){
        for (int i = 0; i < words.length; i++){
            System.out.println(words[i] + ": " + counter[i] + " sentences");
        }
    }

    public static void main(String[] args) {
        StringBuilder textInput = new StringBuilder("Hello darkness my old friend, nice to meet you here again. Hello world, goodbye happiness and my friend. Here we go again my friend."); 
        StringBuilder[] wordsInput = {new StringBuilder("hello"), new StringBuilder("friend"), new StringBuilder("again"), new StringBuilder("here")};
        Text text = new Text(textInput);
        Word[] words = new Word[wordsInput.length];
        for (int i = 0; i < wordsInput.length; i++){
            words[i] = new Word(wordsInput[i]);
        }
        int[] counter = wordsCounter(text, words);
        printCounter(words, counter);
        System.out.println(text);
        text.changePunctuation();
        System.out.println(text);
        
    }
    
}
