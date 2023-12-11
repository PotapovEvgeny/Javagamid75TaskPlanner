package ru.netology.javagamid.Javagamid75TaskPlanner.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtasks() {

        String[] subtasks = {"Позвонить родителям", "Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(31, subtasks);

        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetId() {

        String[] subtasks = {"Позвонить родителям", "Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(31, subtasks);
        Task task = new Task(31);

        int expected = epic.getId();
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchInTodos() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Позвонить родителям", "Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search(" ");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTaskAndEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Позвонить родителям", "Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search(simpleTask.getTitle());

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchInEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Позвонить родителям", "Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("молоко");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingFirst() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Позвонить родителям", "Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getTopic());

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingSecond() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Позвонить родителям", "Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getProject());

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingThird() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Позвонить родителям", "Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search(meeting.getStart());

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenSearchingWithNoMatches() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Позвонить родителям"));
        todos.add(new Epic(2, new String[]{"Купить молоко"}));
        Task[] expected = {};
        Task[] actual = todos.search("Купить яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayOfTasksWhenSearchingWithOneMatch() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Купить молоко"));
        todos.add(new Epic(2, new String[]{"Купить хлеб"}));
        Task[] expected = {new SimpleTask(1, "Купить молоко")};
        Task[] actual = todos.search("молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayOfAllTasksWhenSearchingWithEmptyQuery() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Купить молоко"));
        todos.add(new Epic(2, new String[]{"Позвонить родителям"}));
        Task[] expected = {new SimpleTask(1, "Купить молоко"), new Epic(2, new String[]{"Позвонить родителям"})};
        Task[] actual = todos.search("");
        Assertions.assertArrayEquals(expected, actual);
    }


}
