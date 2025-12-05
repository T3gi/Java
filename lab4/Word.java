import java.util.Arrays;

/**
 * Клас, що представляє слово як масив літер.
 */
public class Word {

    public Letter[] letters = {};

    /**
     * Конструктор слова.
     * @param word Рядок StringBuilder.
     */
    public Word(StringBuilder word){
        StringBuilder letterInput;
        Letter letter;
        for(int i = 0; i < word.length(); i++){
            letterInput = new StringBuilder(String.valueOf(word.charAt(i)));
            letter = new Letter(letterInput);
            letters = Arrays.copyOf(letters, letters.length + 1);
            letters[i] = letter;
        }
    }

    /**
     * Створює нове слово у нижньому регістрі.
     * @return Новий об'єкт Word.
     */
    public Word toLowerCase(){
        Word wordOutput = new Word(new StringBuilder(this.toString()));
        for (int i = 0; i < wordOutput.letters.length; i++) {
            wordOutput.letters[i] =  wordOutput.letters[i].toLowerCase();
        }
        return wordOutput;
    }

    /**
     * Перевіряє рівність слів (по вмісту).
     * @param wordInput Інше слово.
     * @return true, якщо рядкові представлення рівні.
     */
    public boolean equals(Word wordInput){
        return this.toString().equals(wordInput.toString());
    }

    @Override
    public String toString(){
        StringBuilder outputResult = new StringBuilder();
        for (int i = 0; i < letters.length; i++){
            outputResult.append(letters[i]);
        }
        return outputResult.toString();
    }

    
}
