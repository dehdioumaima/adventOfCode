import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class part2 {
    public static List<Monkey> monkeys;

    public static void fillInInput()
    {
        Monkey monkey0 = new Monkey(List.of(93,54,69,66,71));
        monkey0.setOperation('*');
        monkey0.setOperationItem(Integer.valueOf(3));
        monkey0.setDivisible(Integer.valueOf(7));
        monkey0.setIfTrue(Integer.valueOf(7));
        monkey0.setIfFalse(Integer.valueOf(1));
        monkeys.add(monkey0);

        Monkey monkey1 = new Monkey(List.of(89,51,80,66));
        monkey1.setOperation('*');
        monkey1.setOperationItem(Integer.valueOf(17));
        monkey1.setDivisible(Integer.valueOf(19));
        monkey1.setIfTrue(Integer.valueOf(5));
        monkey1.setIfFalse(Integer.valueOf(7));
        monkeys.add(monkey1);

        Monkey monkey2 = new Monkey(List.of(90,92,63,91,96,63,64));
        monkey2.setOperation('+');
        monkey2.setOperationItem(Integer.valueOf(1));
        monkey2.setDivisible(Integer.valueOf(13));
        monkey2.setIfTrue(Integer.valueOf(4));
        monkey2.setIfFalse(Integer.valueOf(3));
        monkeys.add(monkey2);

        Monkey monkey3 = new Monkey(List.of(65,77));
        monkey3.setOperation('+');
        monkey3.setOperationItem(Integer.valueOf(2));
        monkey3.setDivisible(Integer.valueOf(3));
        monkey3.setIfTrue(Integer.valueOf(4));
        monkey3.setIfFalse(Integer.valueOf(6));
        monkeys.add(monkey3);

        Monkey monkey4 = new Monkey(List.of(76,68,94));
        monkey4.setOperation('!');
        monkey4.setOperationItem(Integer.valueOf(0));
        monkey4.setDivisible(Integer.valueOf(2));
        monkey4.setIfTrue(Integer.valueOf(0));
        monkey4.setIfFalse(Integer.valueOf(6));
        monkeys.add(monkey4);

        Monkey monkey5 = new Monkey(List.of(86,65,66,97,73,83));
        monkey5.setOperation('+');
        monkey5.setOperationItem(Integer.valueOf(8));
        monkey5.setDivisible(Integer.valueOf(11));
        monkey5.setIfTrue(Integer.valueOf(2));
        monkey5.setIfFalse(Integer.valueOf(3));
        monkeys.add(monkey5);

        Monkey monkey6 = new Monkey(List.of(78));
        monkey6.setOperation('+');
        monkey6.setOperationItem(Integer.valueOf(6));
        monkey6.setDivisible(Integer.valueOf(17));
        monkey6.setIfTrue(Integer.valueOf(0));
        monkey6.setIfFalse(Integer.valueOf(1));
        monkeys.add(monkey6);

        Monkey monkey7 = new Monkey(List.of(89,57,59,61,87,55,55,88));
        monkey7.setOperation('+');
        monkey7.setOperationItem(Integer.valueOf(7));
        monkey7.setDivisible(Integer.valueOf(5));
        monkey7.setIfTrue(Integer.valueOf(2));
        monkey7.setIfFalse(Integer.valueOf(5));
        monkeys.add(monkey7);
    }

    public static void fillItemsRemainderList()
    {
        for(Monkey monkey:monkeys)
        {
            List<List<Integer>> itemRemainders = new ArrayList<List<Integer>>();
            for(Integer item:monkey.getItems())
            {
                List<Integer> remainders = new ArrayList<Integer>();
                for(int i=0;i<monkeys.size();i++)
                {
                    remainders.add(item%monkeys.get(i).getDivisible());
                }
                itemRemainders.add(remainders);
            }
            monkey.setItemRemainders(itemRemainders);
        }
    }
    public static void applyOperation(List<Integer> remainders, char operation, Integer operationItem)
    {
        for(int i=0;i<remainders.size();i++)
        {
            Integer newRemainder;
            switch(operation)
            {
                case '+':
                    newRemainder=(remainders.get(i) + operationItem) % monkeys.get(i).getDivisible();
                    remainders.set(i, newRemainder);
                    break;
                case '-':
                    newRemainder=(remainders.get(i) - operationItem) % monkeys.get(i).getDivisible();
                    remainders.set(i, newRemainder);
                    newRemainder-=operationItem; break;
                case '*':
                    newRemainder=(remainders.get(i) * operationItem) % monkeys.get(i).getDivisible();
                    remainders.set(i, newRemainder);
                    break;
                case '/':
                    newRemainder=(remainders.get(i) / operationItem) % monkeys.get(i).getDivisible();
                    remainders.set(i, newRemainder);
                    break;
                case '!':
                    newRemainder=(remainders.get(i) * remainders.get(i)) % monkeys.get(i).getDivisible();
                    remainders.set(i, newRemainder);
                    break;
            }
        }
    }


    public static void main(String[] args) throws IOException {

        monkeys = new ArrayList<>();
        fillInInput();
        fillItemsRemainderList();

        for(int i=0;i<10000;i++)
        {
            for(Monkey monkey :monkeys)
            {
                for(List<Integer> remainders :monkey.getItemRemainders())
                {
                    applyOperation(remainders, monkey.getOperation(), monkey.getOperationItem());
                    int monkeyIndex = monkeys.indexOf(monkey);
                    if(remainders.get(monkeyIndex)  % monkey.getDivisible() == 0) monkeys.get(monkey.getIfTrue()).addItemRemainders(remainders);
                    else monkeys.get(monkey.getIfFalse()).addItemRemainders(remainders);
                    monkey.popitemRemainders();
                    monkey.incrementInspectedItems();
                }
            }
        }

        for(Monkey monkey :monkeys)
        {
            System.out.println("monkey "+monkeys.indexOf(monkey)+": inspected "+monkey.getNumberOfItemsInspected());
        }

    }
}