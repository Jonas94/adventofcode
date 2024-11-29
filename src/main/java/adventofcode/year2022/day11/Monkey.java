package adventofcode.year2022.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Monkey {


    private int id;
    private List<Item> items = new ArrayList<>();
    private Function<Integer, Integer> function;
    private Supplier<Integer> supplier;
    private Predicate<Integer> dividerByFunction;

    private int throwToMonkeyIdIfFail;
    private int throwToMonkeyIdIfTrue;
    
    private int numberOfInspectedItems;


    public Monkey(int id) {
        this.id = id;
    }

    public Monkey(int id, List<Item> items, Function<Integer, Integer> function) {
        this.id = id;
        this.items = items;
        this.function = function;

    }
    
    public void increaseNumberOfInspections(){
        numberOfInspectedItems++;
    }

    public int getNumberOfInspectedItems() {
        return numberOfInspectedItems;
    }

    public void setNumberOfInspectedItems(int numberOfInspectedItems) {
        this.numberOfInspectedItems = numberOfInspectedItems;
    }

    public int getThrowToMonkeyIdIfFail() {
        return throwToMonkeyIdIfFail;
    }

    public void setThrowToMonkeyIdIfFail(int throwToMonkeyIdIfFail) {
        this.throwToMonkeyIdIfFail = throwToMonkeyIdIfFail;
    }

    public int getThrowToMonkeyIdIfTrue() {
        return throwToMonkeyIdIfTrue;
    }

    public void setThrowToMonkeyIdIfTrue(int throwToMonkeyIdIfTrue) {
        this.throwToMonkeyIdIfTrue = throwToMonkeyIdIfTrue;
    }

    public Predicate<Integer> getDividerByFunction() {
        return dividerByFunction;
    }

    public void setDividerByFunction(Predicate<Integer> dividerByFunction) {
        this.dividerByFunction = dividerByFunction;
    }

    public Supplier<Integer> getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier<Integer> supplier) {
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Function<Integer, Integer> getFunction() {
        return function;
    }

    public void setFunction(Function<Integer, Integer> function) {
        this.function = function;
    }
}
