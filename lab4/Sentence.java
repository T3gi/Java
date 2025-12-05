import java.util.Arrays;

/**
 * Клас, що представляє речення як набір слів та розділових знаків.
 */
public class Sentence {

    public Word[] words = {};
    public Punctuation[][] punctuations = {{}};

    /**
     * Конструктор речення. Розбиває рядок на слова та пунктуацію.
     *
     * @param sentence Рядок (StringBuilder), що містить речення.
     */
    public Sentence(StringBuilder sentence){
        int nextDot;
        int nextExlamation;
        int nextQuestion;
        int nextEnd;
        int nextComma;
        int nextSpace;
        int nextSeparator;
        int index = 0;
        StringBuilder wordInput;
        StringBuilder[] punctuationInput;
        Word word;
        Punctuation punctuation;
        while (sentence.length() != 0){
            nextComma = sentence.indexOf(",");
            nextSpace = sentence.indexOf(" ");
            if (nextComma < 1){
                nextComma = sentence.length() + 100;
            }
            if (nextSpace < 1){
                nextSpace = sentence.length() + 100;
            }
            nextSeparator = Math.min(nextComma, nextSpace);
            if (nextSeparator == sentence.length() + 100){
                nextSeparator = sentence.length();
            }
            
            if (nextSeparator <= sentence.length() - 2){
                wordInput = new StringBuilder(sentence.substring(0, nextSeparator));
                punctuationInput = new StringBuilder[] {new StringBuilder(String.valueOf(sentence.charAt(nextSeparator)))};
                nextSeparator++;

                if (nextSeparator - 1 == nextComma) {
                    if (nextSpace - nextComma == 1) {
                        punctuationInput = Arrays.copyOf(punctuationInput, punctuationInput.length + 1);
                        punctuationInput[1] = new StringBuilder(String.valueOf(sentence.charAt(nextSeparator)));
                        nextSeparator++;
                    }
                }

                punctuations = Arrays.copyOf(punctuations, punctuations.length + 1);
                punctuations[index + 1] = new Punctuation[] {};
                
                for (int i = 0; i < punctuationInput.length; i++){
                    punctuation = new Punctuation(punctuationInput[i]);
                    punctuations[index] = Arrays.copyOf(punctuations[index], punctuations[index].length + 1);
                    punctuations[index][i] = punctuation;
                }
            } else {
                nextDot = sentence.indexOf(".");
                nextExlamation = sentence.indexOf("!");
                nextQuestion = sentence.indexOf("?");
                if (nextDot == -1) {
                    nextDot = sentence.length() + 100;
                }
                if (nextExlamation == -1) {
                    nextExlamation = sentence.length() + 100;
                }
                if (nextQuestion == -1) {
                    nextQuestion = sentence.length() + 100;
                }
                nextEnd = Math.min(nextDot, nextExlamation);
                nextEnd = Math.min(nextEnd, nextQuestion);
                
                if (nextEnd != sentence.length() + 100){
                    punctuationInput = new StringBuilder[] {new StringBuilder(String.valueOf(sentence.charAt(nextEnd)))};
                    punctuation = new Punctuation(punctuationInput[0]);
                    punctuations[index] = Arrays.copyOf(punctuations[index], punctuations[index].length + 1);
                    punctuations[index][0] = punctuation;
                } 

                if (nextSeparator == nextSpace) {
                    punctuationInput = new StringBuilder[] {new StringBuilder(String.valueOf(sentence.charAt(nextSpace)))};
                    punctuation = new Punctuation(punctuationInput[0]);
                    punctuations[index] = Arrays.copyOf(punctuations[index], punctuations[index].length + 1);
                    punctuations[index][1] = punctuation;
                    nextSeparator++;
                }
                wordInput = new StringBuilder(sentence.substring(0, nextEnd));
            }
                

            word = new Word(wordInput);
            words = Arrays.copyOf(words, words.length + 1);
            words[index] = word;

            sentence = new StringBuilder(sentence.substring(nextSeparator));
            index++;
        }
    }
    

    @Override
    public String toString(){
        StringBuilder outputResult = new StringBuilder();
        
        for (int i = 0; i < words.length; i++){
            outputResult.append(words[i]);
            for (Punctuation punctuation: punctuations[i]){
                outputResult.append(punctuation);
            }
        }
        return outputResult.toString();
    }

}
