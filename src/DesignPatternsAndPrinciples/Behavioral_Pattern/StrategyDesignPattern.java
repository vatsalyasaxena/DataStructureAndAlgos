package DesignPatternsAndPrinciples.Behavioral_Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

enum OutputFormat{
    MARKDOWN,HTML
}
// HTML List - <ul><li>element</li></ul>
//Markdown list - * foo
//                * bar
interface ListStrategy{
    default void start(StringBuilder sb){};
    void addListItem(StringBuilder sb , String item);
    default void end(StringBuilder sb){};
}
public class StrategyDesignPattern {

}
class MarkdownListStrategy implements ListStrategy{

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append(" * ")
        .append(item)
        .append(System.lineSeparator());
    }
}
class HtmlListStrategy implements ListStrategy{

    @Override
    public void start(StringBuilder sb) {
        sb.append("<ul>").append(System.lineSeparator());
    }

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append("    <li>")
                .append(item)
                .append("</li>")
                .append(System.lineSeparator());

    }

    @Override
    public void end(StringBuilder sb) {
        sb.append("</ul>").append(System.lineSeparator());
    }
}
//Dynamic strategy
class TextProcessor{
    private StringBuilder stringBuilder = new StringBuilder();
    private ListStrategy listStrategy;

    public TextProcessor(OutputFormat format){
        setOutputFormat(format);
    }

    public void setOutputFormat(OutputFormat format){
        switch(format){
            case HTML -> {listStrategy = new HtmlListStrategy();
            break;}
            case MARKDOWN -> {listStrategy = new MarkdownListStrategy();break;}
        }
    }

    public void appendList(List<String> items){
        listStrategy.start(stringBuilder);
        for(String item : items) {
            listStrategy.addListItem(stringBuilder, item);
        }
        listStrategy.end(stringBuilder);
    }
    public void clear(){
        stringBuilder.setLength(0);
    }

    @Override
    public String toString(){
        return stringBuilder.toString();
    }
}
//Static Strategy
class TextProcessorStatic<LS extends ListStrategy>{
    private StringBuilder sb = new StringBuilder();
    private LS listStrategy;

    public TextProcessorStatic(Supplier<LS> lambda){
        listStrategy = lambda.get();
    }
    public void appendList(List<String> items){
        listStrategy.start(sb);
        for(String item : items) {
            listStrategy.addListItem(sb, item);
        }
        listStrategy.end(sb);
    }
    public void clear(){
        sb.setLength(0);
    }

    @Override
    public String toString(){
        return sb.toString();
    }
}
class Demo{
    public static void main(String[] args) {
        //Dynamic strategy demo, as arg is passed at runtime/ implementation time
        TextProcessor tp = new TextProcessor(OutputFormat.HTML);

        List<String> list  = new ArrayList<>();
        list.add("subah");
        list.add("dophar");
        list.add("shaam");
        list.add("raat");
        tp.appendList(list);
        System.out.println(tp);

        tp.clear();
        TextProcessor tp1 = new TextProcessor(OutputFormat.MARKDOWN);
        tp1.appendList(list);
        System.out.println(tp1);
        System.out.println("-------------**********----------------");
        //Static strategy demo, as separate classes for Different type of text processor
        //Keep in mind that we didn't touch anything except
        //TextProcessor class
        TextProcessorStatic<HtmlListStrategy> htmlListStrategy = new TextProcessorStatic<HtmlListStrategy>(HtmlListStrategy::new);
        htmlListStrategy.appendList(list);
        System.out.println(htmlListStrategy);

        //htmlListStrategy.clear();

        TextProcessorStatic<MarkdownListStrategy> markdownListStrategy = new TextProcessorStatic<>(MarkdownListStrategy::new);
        markdownListStrategy.appendList(list);
        System.out.println(markdownListStrategy);
    }
}