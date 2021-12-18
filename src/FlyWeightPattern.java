import java.util.*;

public class FlyWeightPattern {

}

class Sentence
{
    public WordToken[] tokenized;
    public String plainText;
    public Sentence(String plainText)
    {
        this.plainText = plainText;
        tokenized = new WordToken[plainText.split(" ").length];
        for(int i=0;i<tokenized.length;i++){
            tokenized[i] = new WordToken();
        }
    }

    public WordToken getWord(int index)
    {
        return tokenized[index];
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        int count =0;
        for(String s : this.plainText.split(" ")){
            if(count!=0){
                sb.append(" ");
            }
            if (tokenized[count].capitalize){
                sb.append(s.toUpperCase());
            }else{
                sb.append(s);
            }
            count++;
        }
        return sb.toString();
    }

    class WordToken
    {
        public boolean capitalize;
    }

    public static void main(String[] args) {
        Sentence s = new Sentence("hello world");
        s.getWord(1).capitalize=true;
        System.out.println(s);
    }
}