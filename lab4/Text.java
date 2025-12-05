import java.util.Arrays;

/**
 * Клас, що представляє текст як сукупність речень.
 */
public class Text {

    public Sentence[] sentences = {};

    /**
     * Конструктор тексту. Розбиває вхідний рядок на речення.
     *
     * @param text Вхідний текст у вигляді StringBuilder.
     */
    public Text(StringBuilder text){
        int nextDot;
        int nextExlamation;
        int nextQuestion;
        int nextEnd;
        int index = 0;
        StringBuilder sentenceInput;
        Sentence sentence;
        while (text.length() != 0){
            nextDot = text.indexOf(".");
            nextExlamation = text.indexOf("!");
            nextQuestion = text.indexOf("?");
            if (nextDot == -1) {
                nextDot = text.length() + 100;
            }
            if (nextExlamation == -1) {
                nextExlamation = text.length() + 100;
            }
            if (nextQuestion == -1) {
                nextQuestion = text.length() + 100;
            }
            nextEnd = Math.min(nextDot, nextExlamation);
            nextEnd = Math.min(nextEnd, nextQuestion);
            if (nextEnd == text.length() + 100){
                nextEnd = text.length();
            }
            
            if (nextEnd < text.length()){
                nextEnd++;
            } 

            if (nextEnd < text.length()){
                nextEnd++;
            }

            sentenceInput = new StringBuilder(text.substring(0, nextEnd));
            sentence = new Sentence(sentenceInput);
            sentences = Arrays.copyOf(sentences, sentences.length + 1);
            sentences[index] = sentence;

            text = new StringBuilder(text.substring(nextEnd));
            index++;
        }
    }

    /**
     * Виконує модифікацію пунктуації в тексті. Прибирає всі табуляції та пробіли в тексті окрім першого
     */
    public void changePunctuation(){
        boolean firstPunctuation = true;
        StringBuilder empty = new StringBuilder("");
        Punctuation emptyPunctuation = new Punctuation(empty);
        StringBuilder space = new StringBuilder(" ");
        Punctuation spacePunctuation = new Punctuation(space);
        StringBuilder tab = new StringBuilder("\t");
        Punctuation tabPunctuation = new Punctuation(tab);
        for (int i = 0; i < sentences.length; i++){
            for(int j = 0; j < sentences[i].punctuations.length; j++){
                Punctuation[] punctuationInput = sentences[i].punctuations[j];
                for(int k = 0; k < punctuationInput.length; k++){
                    if (firstPunctuation && (sentences[i].punctuations[j][k].equals(spacePunctuation) || sentences[i].punctuations[j][k].equals(tabPunctuation))){
                        firstPunctuation = !firstPunctuation;
                        sentences[i].punctuations[j][k] = spacePunctuation;
                    } else if ((sentences[i].punctuations[j][k].equals(spacePunctuation) || sentences[i].punctuations[j][k].equals(tabPunctuation))){
                        sentences[i].punctuations[j][k] = emptyPunctuation;
                    }
                }
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder outputResult = new StringBuilder();
        
        for (Sentence sentenceOutput: sentences){
            outputResult.append(sentenceOutput);
        }
        return outputResult.toString();
    }

}
