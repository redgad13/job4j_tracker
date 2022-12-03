package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultipleValidInput() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"1", "2", "3"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = input.askInt("Enter Menu: ");
        assertThat(selected).isEqualTo(1);
        selected = input.askInt("Enter Menu: ");
        assertThat(selected).isEqualTo(2);
        selected = input.askInt("Enter Menu: ");
        assertThat(selected).isEqualTo(3);
    }

    @Test
    void whenInValidInputDueToNegativeValue() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput validateInput = new ValidateInput(output, input);
        int selected = input.askInt("Enter Menu: ");
        assertThat(selected).isEqualTo(-1);
    }
}
