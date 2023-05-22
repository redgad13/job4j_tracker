package ru.job4j.tracker;

import ru.job4j.tracker.store.SqlTracker;

import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select > actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = null;
        Input input = new ValidateInput(
                output, new ConsoleInput()
        );
        output = new ConsoleOutput();
        try (Store tracker = new SqlTracker()) {
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new ShowAllItemsAction(output),
                    new EditItemAction(output),
                    new DeleteItemAction(output),
                    new FindByIdAction(output),
                    new FindByNameAction(output),
                    new ExitProgramAction(output)
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}