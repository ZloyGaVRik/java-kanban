import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    public HashMap<Integer, Task> tasks;
    public HashMap<Integer, EpicTask> epicTasks;
    public HashMap<Integer, SubTask> subTasks;


    public TaskManager() {
        tasks = new HashMap<>();
        subTasks = new HashMap<>();
        epicTasks = new HashMap<>();

    }

    public void addTask(Task task) {
        tasks.put(task.taskId, task);
    }

    public void addEpicTask(EpicTask epicTask) {
        epicTasks.put(epicTask.taskId, epicTask);
    }

    public void addSubTask(int epicTaskId, SubTask subTask)
    {   getEpicTaskByID(epicTaskId).subTasksId.add(subTask.taskId);
        subTask.epicTaskId = epicTaskId;
        subTasks.put(subTask.taskId, subTask);
    }

    public Task getTaskByID(int taskId) {
        if (tasks.get(taskId) != null) return epicTasks.get(taskId);
        return null;
    }

    public EpicTask getEpicTaskByID(int taskId) {
        if (epicTasks.get(taskId) != null) return epicTasks.get(taskId);
        return null;
    }

    public SubTask getSubTaskByID(int taskId) {
        if (subTasks.get(taskId) != null) return subTasks.get(taskId);
        return null;
    }

    public void printAllTasks() {
        for (Task value : tasks.values()) {
            System.out.println(value + "\n");
        }
        for (Task value : epicTasks.values()) {
            System.out.println(value + "\n");
        }
        for (Task value : subTasks.values()) {
            System.out.println(value + "\n");
        }

    }

    public void updateTask(int taskId, Object newTask) {
        if (getTaskByID(taskId) != null) {
            Task task = (Task) newTask;

            if (task.getName() != null){
                this.getTaskByID(taskId).setName(task.getName());
            }
            if (task.getName() != null) {
                this.getTaskByID(taskId).setDescription(task.getDescription());

            }
            this.getTaskByID(taskId).setStatus(task.getStatus());

        } else if (getEpicTaskByID(taskId) != null) {
            EpicTask task = (EpicTask) newTask;

            if (task.getName() != null){
                this.getEpicTaskByID(taskId).setName(task.getName());

            }
            if (task.getName() != null) {
                this.getEpicTaskByID(taskId).setDescription(task.getDescription());

            }

        } else if (getSubTaskByID(taskId) != null) {
            SubTask task = (SubTask) newTask;

            if (task.getName() != null) {
                this.getSubTaskByID(taskId).setName(task.getName());

            }
            if (task.getName() != null) {
                this.getSubTaskByID(taskId).setDescription(task.getDescription());

            }
            this.getSubTaskByID(taskId).setStatus(task.getStatus());
            checkEpicTaskStatus(getSubTaskByID(taskId));

        }
    }

    private void checkEpicTaskStatus(SubTask task) {
        EpicTask epicTask = getEpicTaskByID(task.epicTaskId);

        int countStatusInProgress = 0;
        int countStatusDone = 0;
        for (Integer value : epicTask.subTasksId) {
            if (subTasks.get(value).getStatus().equals(Status.IN_PROGRESS)){
                countStatusInProgress++;
            } else if (subTasks.get(value).getStatus().equals(Status.DONE)) {
                countStatusDone++;
            }
        }
        if (countStatusInProgress > 0 ||  countStatusDone > 0) {
            epicTask.setStatus(Status.IN_PROGRESS);
        }
        if (countStatusDone == epicTask.subTasksId.size()){
            epicTask.setStatus(Status.DONE);
        }
    }


    public void removeTask(int taskId) {
        if (getTaskByID(taskId) != null) {
            tasks.remove(taskId);
        } else if (getSubTaskByID(taskId) != null) {
            subTasks.remove(taskId);
        } else {
            for (Integer value : getEpicTaskByID(taskId).subTasksId) {
                subTasks.remove(value);
            }
            epicTasks.remove(taskId);
        }
    }

    public void removeAllTask() {
        tasks.clear();
        subTasks.clear();
        epicTasks.clear();
    }

    public void printEpicALlSubTask(int taskId) {
        EpicTask epicTask = epicTasks.get(taskId);
        if (epicTask != null) {
            ArrayList<Integer> values = epicTask.subTasksId;
            for (Integer value : values) {
                System.out.println(subTasks.get(value));
            }
        }
    }








}
