import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    public HashMap<Task, ArrayList<Task>> tasks;
    public ArrayList<Task> subTasks;

    public TaskManager() {
        tasks = new HashMap<>();
        subTasks = new ArrayList<>();

    }

    public void addTask(Task task) {
        tasks.put(task, null);
    }

    public void addSubTask(int taskID, Task subTask) {
        Task task = getTaskByID(taskID);
        if (tasks.get(task) != null) {
            subTasks = tasks.get(task);
            subTask.setTypeTask(TaskType.SUBTASK);
            subTasks.add(subTask);

        } else {
            subTasks = new ArrayList<>();
            subTask.setTypeTask(TaskType.SUBTASK);
            subTasks.add(subTask);
            tasks.put(task, subTasks);
            task.setTypeTask(TaskType.EPIC);
        }
    }

    public void addEpicTask(Task task) {
        task.setTypeTask(TaskType.EPIC);
        tasks.put(task, null); // Метод сделан по требованиям тех-задания, таска уровня эпик создаётся автоматически при создании сабтаски
    }

    public Task getTaskByID(int taskID) {
        Task task = null;
        for (Task key : tasks.keySet()) {
            if (key.getId() == taskID) {
                task = key;
                break;
            }

        }
        for (ArrayList<Task> values : tasks.values()) {
            if (values != null) {
                for (Task value : values) {
                    if (value.getId() == taskID) {
                        task = value;
                        break;
                    }

                }

            }
        }
        return task;
    }

    public void printAllTasks() {
        for (Task key : tasks.keySet()) {
            System.out.println(key);
            ArrayList<Task> values = tasks.get(key);
            if (values != null) {
                for (Task value : values) {
                    System.out.println(value);
                }
            }

        }
    }

    public Task getKey(int taskID) {
        Task taskKey = null;
        for (Task key : tasks.keySet()) {
            ArrayList<Task> values = tasks.get(key);
            if (values != null) {
                for (Task value : values) {
                    if (value.getId() == taskID) {
                        taskKey = key;
                    }
                }
            }

        }
        return taskKey;
    }

    public void updateTask(int taskID, Task newTask) {
        Task findTask = getTaskByID(taskID);
        if (newTask.getName() != null) {
            findTask.setName(newTask.getName());
        }
        if (newTask.getDescription() != null) {
            findTask.setDescription(newTask.getDescription());
        }
        if (newTask.getStatus() != null) {
            if (findTask.getTypeTask().equals(TaskType.TASK)) {
                findTask.setStatus(newTask.getStatus());
            } else if (findTask.getTypeTask().equals(TaskType.SUBTASK)) {
                findTask.setStatus(newTask.getStatus());
            }
        }
        findTask = getKey(taskID);
        if (findTask != null) {
            ArrayList<Task> values = tasks.get(findTask);
            int countStatusInProgress = 0;
            int countStatusDone = 0;
            for (Task value : values) {
                if (value.getStatus().equals(Status.IN_PROGRESS)){
                    countStatusInProgress++;
                } else if (value.getStatus().equals(Status.DONE)) {
                    countStatusDone++;
                }
            }
            if (countStatusInProgress > 0 ||  countStatusDone > 0) {
                findTask.setStatus(Status.IN_PROGRESS);
            }
            if (countStatusDone == values.size()){
                findTask.setStatus(Status.DONE);
            }
        }
    }

    public void removeTask(int taskID) {
        tasks.remove(getTaskByID(taskID));
        subTasks.remove(getTaskByID(taskID));
    }

    public void removeAllTask() {
        tasks.clear();
    }

    public ArrayList<Task> printEpicALlSubTask(int taskID) {
        ArrayList<Task> values = null;
        if (tasks.get(getTaskByID(taskID)) != null) {
            values = tasks.get(getTaskByID(taskID));
        }
        return values;
    }








}
