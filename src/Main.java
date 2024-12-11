import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TaskManager manager = new TaskManager();


        Task task1 = new Task("Переезд", "Купить чемодан");
        Task task2 = new Task("Сходить в магазин", "Купить продуктов");
        Task task3 = new Task("Выпить кофе", "Сходить в кофейню на районе");
        Task task4 = new Task("Купить Полку", "Зайти в леруа и выбрать полку для кухни");
        Task task5 = new Task("Купить Полку", "Зайти в леруа и выбрать полку для кухни");

        //manager.addTask(new Task(scanner.nextLine(), scanner.nextLine()));
        manager.addTask(task1);
        manager.addTask(task3);



        manager.addSubTask(task1.taskID, task2);
        manager.addSubTask(task1.taskID, task4);


        //System.out.println(manager.tasks);

        //System.out.println(manager.getTaskByID(-136842436));

        //manager.printAllTasks();

        //manager.removeTask(-136842436);

       // manager.printAllTasks();

        //manager.removeAllTask();

        //manager.printAllTasks();

        //System.out.println(manager.printEpicALlSubTask(-1228530043));
        //manager.updateTask(909976286, new Task(null,null,Status.IN_PROGRESS));
        manager.updateTask(909976286, new Task(Status.DONE));
        //manager.updateTask(968457343, new Task("","",Status.IN_PROGRESS));

        manager.printAllTasks();






    }
}

