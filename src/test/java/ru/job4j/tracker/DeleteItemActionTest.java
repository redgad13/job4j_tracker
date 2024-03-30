package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

class DeleteItemActionTest {

    @Test
    public void whenDeleteIsOk() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("new Item"));
        DeleteItemAction deleteItemAction = new DeleteItemAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteItemAction.execute(input, tracker);
        String line = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete item ===" + line
                        + "Заявка удалена успешно." + line
        );
    }

    @Test
    public void whenDeleteIsNotOk() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("new Item"));
        DeleteItemAction deleteItemAction = new DeleteItemAction(output);
        Input input = mock(Input.class);
        deleteItemAction.execute(input, tracker);
        String line = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete item ===" + line
                        + "Ошибка удаления заявки." + line
        );
    }
}