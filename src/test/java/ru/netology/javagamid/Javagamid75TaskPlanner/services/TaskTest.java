package ru.netology.javagamid.Javagamid75TaskPlanner.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void findQueryInSimpleTaskTrue() {
        Task simpleTask = new SimpleTask(3, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findQueryInSimpleTaskFalse() {
        Task simpleTask = new SimpleTask(1, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Не позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findQueryInEpicTrue() {
        String[] subtasks = {"Позвонить родителям", "Купить молоко", "Купить яйца", "Купить хлеб"};
        Task epic = new Epic(12, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findQueryInEpicFalse() {
        String[] subtasks = {"Позвонить родителям", "Купить молоко", "Купить яйца", "Купить хлеб"};
        Task epic = new Epic(12, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("яйца");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findQueryInMeetingTrue() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("В");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findQueryInMeetingFalse() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("вторник");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findQueryInTaskFalse() {
        Task task = new Task(45);

        boolean expected = false;
        boolean actual = task.matches("молоко");

        Assertions.assertEquals(expected, actual);
    }
}
