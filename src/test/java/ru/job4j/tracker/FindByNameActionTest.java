package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

class FindByNameActionTest {

    @Test
    public void whenFindByNameIsOk() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("my Item");
        memTracker.add(item);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        FindByNameAction find = new FindByNameAction(output);
        find.execute(input, memTracker);
        String line = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + line
                        + item + line
        );
    }

    @Test
    public void whenFindByNameIsNotOk() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("my Item");
        memTracker.add(item);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("default");
        FindByNameAction find = new FindByNameAction(output);
        find.execute(input, memTracker);
        String line = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + line
                        + "Заявки с именем: " + "default" + " не найдены." + line
        );
    }
}