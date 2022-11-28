package ru.job4j.tracker;

public class ExitProgramAction implements UserAction {
    private final Output output;

    public ExitProgramAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
