package DesignPatternsAndPrinciples.SOLID_Principles;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

enum COLOR{
    GREEN,BLACK,BLUE
}
enum SIZE{
    SMALL,MEDIUM,LARGE
}
public class OCP {
}

class Product{
    String name;
    COLOR color;
    SIZE size;

    Product(String name, COLOR color,SIZE size){
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

interface Specification<T>{
    boolean isSpecific(T item);
}
class ColorSpecification implements Specification<Product> {
    COLOR color;
    ColorSpecification(COLOR color){
        this.color = color;
    }
    @Override
    public boolean isSpecific(Product item){
        return item.color == this.color;
    }
}

class SizeSpecification implements Specification<Product>{
    SIZE size;
    SizeSpecification(SIZE size){
        this.size = size;
    }
    @Override
    public boolean isSpecific(Product item){
        return item.size == size;
    }
}
interface Filter<T>{
    Stream<T> filter(List<T> list, Specification<T> spec);
}

class BetterFilter implements Filter<Product>{

    @Override
    public Stream<Product> filter(List<Product> list, Specification<Product> spec){
        return list.stream().filter(p -> spec.isSpecific(p));
    }
}

class AndSpecification implements Specification<Product>{
    SizeSpecification size;
    ColorSpecification color;

    AndSpecification(ColorSpecification c, SizeSpecification s){
        this.color =c;
        this.size =s;
    }

    @Override
    public boolean isSpecific(Product item) {
        return size.isSpecific(item) && color.isSpecific(item);
    }
}

class Demo1{
    public static void main(String[] args) {
        Product apple = new Product("Apple",COLOR.GREEN,SIZE.SMALL);
        Product tree = new Product("Tree",COLOR.GREEN,SIZE.LARGE);
        Product house = new Product("House",COLOR.BLUE,SIZE.LARGE);

        List<Product> products = Arrays.asList(apple,tree,house);
        BetterFilter bf = new BetterFilter();
        bf.filter(products,new ColorSpecification(COLOR.GREEN)).forEach(p -> System.out.println(" - "+ p.name + " is green"));

        bf.filter(products,new AndSpecification(new ColorSpecification(COLOR.GREEN),new SizeSpecification(SIZE.LARGE)))
                .forEach(p -> System.out.println(" - " + p.name + " is of "+ p.color.name() + " color & "+ p.size.name() + " size"));

    }

}

