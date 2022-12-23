package ru.job4j.queue;

import java.util.ArrayList;
import java.util.Queue;

public class ReconstructPhrase {
    private final Queue<Character> descendingElements;

    private final Queue<Character> evenElements;

    public ReconstructPhrase(Queue<Character> descendingElements, Queue<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>(evenElements);
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                stringBuilder.append(list.get(i));
            }
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character descendingElement : descendingElements) {
            stringBuilder.append(descendingElement);
        }
        return stringBuilder.reverse().toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
