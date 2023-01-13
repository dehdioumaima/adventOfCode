import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Monkey {

    List<Integer> items;
    char operation;
    Integer operationItem;
    Integer divisible;
    Integer ifTrue;
    Integer ifFalse;
    int numberOfItemsInspected;
    List<List<Integer>> itemRemainders;

    public Monkey(List<Integer> items) {
        this.items = items;
    }

    public void addItem(Integer item)
    {
        List<Integer> items = new ArrayList<>(this.getItems());
        items.add(item);
        this.setItems(items);
    }

    public void popitem()
    {
        List<Integer> items = new ArrayList<>(this.getItems());
        items.remove(0);
        this.setItems(items);
    }

    public void addItemRemainders(List<Integer> itemRemainders)
    {
        List<List<Integer>> items = new ArrayList<>(this.getItemRemainders());
        items.add(itemRemainders);
        this.setItemRemainders(items);
    }

    public void popitemRemainders()
    {
        List<List<Integer>> items = new ArrayList<>(this.getItemRemainders());
        items.remove(0);
        this.setItemRemainders(items);
    }

    public void incrementInspectedItems()
    {
        this.setNumberOfItemsInspected(this.getNumberOfItemsInspected()+1);
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public Integer getOperationItem() {
        return operationItem;
    }

    public void setOperationItem(Integer operationItem) {
        this.operationItem = operationItem;
    }

    public Integer getDivisible() {
        return divisible;
    }

    public void setDivisible(Integer divisible) {
        this.divisible = divisible;
    }

    public Integer getIfTrue() {
        return ifTrue;
    }

    public void setIfTrue(Integer ifTrue) {
        this.ifTrue = ifTrue;
    }

    public Integer getIfFalse() {
        return ifFalse;
    }

    public void setIfFalse(Integer ifFalse) {
        this.ifFalse = ifFalse;
    }

    public int getNumberOfItemsInspected() {
        return numberOfItemsInspected;
    }

    public void setNumberOfItemsInspected(int numberOfItemsInspected) {
        this.numberOfItemsInspected = numberOfItemsInspected;
    }

    public List<List<Integer>> getItemRemainders() {
        return itemRemainders;
    }

    public void setItemRemainders(List<List<Integer>> itemRemainders) {
        this.itemRemainders = itemRemainders;
    }
}
