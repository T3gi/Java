/**
 * Клас, що представляє окрему літеру.
 */
public class Letter {

    public StringBuilder name;

    public Letter(StringBuilder letter){
        this.name = letter;
    }

    public Letter toLowerCase(){
        StringBuilder letterOutput = new StringBuilder(name.toString().toLowerCase());
        return new Letter(letterOutput);
    }

    @Override
    public String toString(){
        return name.toString();
    }
}
