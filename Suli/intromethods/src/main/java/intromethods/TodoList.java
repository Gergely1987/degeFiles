package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    @Override
    public String toString() {
        return "TodoList{" + todos.toString() +
                '}';
    }


    public void addTodo(String caption) {
        Todo td = new Todo(caption);
        todos.add(td);
    }

    public void finisTodos(String caption) {
        //  System.out.println(todos.size());
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).toString().contains(caption)) {
                todos.get(i).setFinished(true);
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish) {
        for (int i = 0; i < todos.size(); i++) {
            for (int j = 0; j < todosToFinish.size(); j++) {
                if (todos.get(i).toString().contains(todosToFinish.get(j))) {
                    todos.get(i).setFinished(true);
                }
            }
        }

    }

    public List<String> todosToFinish() {
        List<String> leftTodos = new ArrayList<>();

        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).isFinished() == false) {
                leftTodos.add(todos.get(i).toString());
            }
        }

        return leftTodos;

    }

    public int numberOffFinishedTodos() {
        int num = 0;
        for (Todo i : todos) {
            if (i.isFinished() == true) {
                num++;
            }
        }

        return num;

    }

    public static void main(String[] args) {
        TodoList tl = new TodoList();
        tl.addTodo("kávét főzni");
        tl.addTodo("felporszívózni");
        tl.addTodo("gyereket tisztába tenni");
        tl.addTodo("kutyát megetetni");
        tl.addTodo("letörölni a polcokat");
        tl.addTodo("virágokat locsolni");
        tl.addTodo("filmet nézni");
        tl.addTodo("kádat kimosni");


        List<String> tenni = new ArrayList<>();
        tenni.add("kávét főzni");
        tenni.add("kutyát megetetni");
        tenni.add("filmet nézni");

        System.out.println(tl);
        tl.finisTodos("kávét főzni");
        tl.finisTodos("kutyát megetetni");
        tl.finishAllTodos(tenni);
        System.out.println(tl);
        System.out.println();
        System.out.println(tl.todosToFinish());
        System.out.println();
        System.out.println(tl.numberOffFinishedTodos());
    }

}
