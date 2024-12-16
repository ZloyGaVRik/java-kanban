import Task.*;
import TaskManager.TaskManager;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();


        Task task1 = new Task("Переезд", "Заказать машину");
        Task task2 = new Task("Переезд", "Заказать грузчиков");
        EpicTask epicTask2 = new EpicTask("Прогулки", "Погулять в соседнем районе");
        EpicTask epicTask3 = new EpicTask("Покупки", "Зайти в магазины по дороге с работы");
        SubTask subTask1 = new SubTask("Перекресток", "Купить Молока");
        SubTask subTask2 = new SubTask("ВкусВилл", "Купить Дыню");
        SubTask subTask3 = new SubTask("Кофе", "Выпить кофе в новом месте ");
        SubTask subTask4 = new SubTask("Леруа", "Зайти в Леруа и выбрать полку для кухни");

        SubTask updateTask1 = new SubTask(null,null, Status.IN_PROGRESS);
        SubTask updateTask2 = new SubTask(null,null, Status.IN_PROGRESS);
        SubTask updateTask3 = new SubTask(null,null, Status.DONE);
        SubTask updateTask4 = new SubTask(null,null, Status.DONE);



        manager.addTask(task1);
        manager.addTask(task2);

        manager.addEpicTask(epicTask2);
        manager.addEpicTask(epicTask3);

        manager.addSubTask(epicTask2.taskId, subTask1);
        manager.addSubTask(epicTask2.taskId, subTask2);
        manager.addSubTask(epicTask3.taskId, subTask3);
        manager.addSubTask(epicTask3.taskId, subTask4);

        manager.printAllTasks();

        manager.updateTask(subTask1.taskId, updateTask1);
        manager.updateTask(subTask2.taskId, updateTask2);
        manager.updateTask(subTask3.taskId, updateTask3);
        manager.updateTask(subTask4.taskId, updateTask4);
        System.out.println("Задачи обновлены");

        manager.printAllTasks();

        manager.removeTask(epicTask2.taskId);
        System.out.println("Задача удалена");

        manager.printAllTasks();

        manager.removeAllTask();
        System.out.println("Все задачи удалены");

        manager.printAllTasks();










    }
}

