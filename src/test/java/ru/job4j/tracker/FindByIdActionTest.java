package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

class FindByIdActionTest {
    @Test
    public void whenFindByIdIsOk() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("new Item");
        tracker.add(item);
        Input input = mock(Input.class);
        FindByIdAction find = new FindByIdAction(output);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);
        String line = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + line
                        + item + line
        );
    }

    @Test
    public void whenFindByIdIsNotOk() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("new Item");
        tracker.add(item);
        Input input = mock(Input.class);
        FindByIdAction find = new FindByIdAction(output);
        find.execute(input, tracker);
        String line = System.lineSeparator();
        int defaultId = 0;
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + line
                        + "Заявка с введенным id: " + defaultId + " не найдена." + line
        );
    }
}