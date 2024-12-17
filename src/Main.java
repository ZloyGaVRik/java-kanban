import task.*;
import taskManager.TaskManager;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();


        Task task1 = new Task(null,"Переезд", "Заказать машину");
        Task task2 = new Task(null,"Переезд", "Заказать грузчиков");
        EpicTask epicTask2 = new EpicTask(null,"Прогулки", "Погулять в соседнем районе");
        EpicTask epicTask3 = new EpicTask(null,"Покупки", "Зайти в магазины по дороге с работы");
        SubTask subTask1 = new SubTask(null,"Перекресток", "Купить Молока");
        SubTask subTask2 = new SubTask(null,"ВкусВилл", "Купить Дыню");
        SubTask subTask3 = new SubTask(null,"Кофе", "Выпить кофе в новом месте ");
        SubTask subTask4 = new SubTask(null,"Леруа", "Зайти в Леруа и выбрать полку для кухни");

        SubTask updateTask1 = new SubTask(4,null,null, Status.IN_PROGRESS);
        SubTask updateTask2 = new SubTask(5,null,null, Status.IN_PROGRESS);
        SubTask updateTask3 = new SubTask(6,null,null, Status.DONE);
        SubTask updateTask4 = new SubTask(7,null,null, Status.DONE);
        EpicTask updateTask5 = new EpicTask(3,null,"Зайти в магазин по дороге на работу");
        Task updateTask6 = new Task(1                                                                                                                                                                                                                 ,null,null, Status.DONE);



        manager.addTask(task1);
        manager.addTask(task2);

        manager.addEpicTask(epicTask2);
        manager.addEpicTask(epicTask3);

        manager.addSubTask(epicTask2.getId(), subTask1);
        manager.addSubTask(epicTask2.getId(), subTask2);
        manager.addSubTask(epicTask3.getId(), subTask3);
        manager.addSubTask(epicTask3.getId(), subTask4);

        manager.printAllTask();
        manager.printAllEpicTask();
        manager.printAllSubTask();

        manager.updateTask(updateTask6);
        manager.updateSubTask(updateTask1);
        manager.updateSubTask(updateTask2);
        manager.updateSubTask(updateTask3);
        manager.updateSubTask(updateTask4);
        manager.updateEpicTask(updateTask5);
        System.out.println("Задачи обновлены");

        manager.printAllTask();
        manager.printAllEpicTask();
        manager.printAllSubTask();

        manager.deleteEpicTaskById(epicTask2.getId());
        manager.deleteTaskById(task1.getId());
        manager.deleteSubTaskById(subTask3.getId());
        System.out.println("Задачи удалены");

        manager.printAllTask();
        manager.printAllEpicTask();
        manager.printAllSubTask();

        manager.deleteAllEpicTasks();
        manager.deleteAllTasks();
        manager.deleteAllSubTasks();
        System.out.println("Все задачи удалены");

        manager.printAllTask();
        manager.printAllEpicTask();
        manager.printAllSubTask();










    }
}

