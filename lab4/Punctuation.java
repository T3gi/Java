/**
 * Клас, що представляє знак пунктуації.
 */
public class Punctuation {

    public StringBuilder name;

    public Punctuation(StringBuilder punctuation){
        this.name = punctuation;
    }

    public boolean equals(Punctuation punctuationInput){
        return this.toString().equals(punctuationInput.toString());
    }

    @Override
    public String toString(){
        return name.toString();
    }
}
