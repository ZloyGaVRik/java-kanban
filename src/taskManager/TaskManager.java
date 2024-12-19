package taskManager;

import task.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TaskManager {
    public HashMap<Integer, Task> tasks;
    public HashMap<Integer, EpicTask> epicTasks;
    public HashMap<Integer, SubTask> subTasks;
    private int taskCounter = 0;


    public TaskManager() {
        tasks = new HashMap<>();
        subTasks = new HashMap<>();
        epicTasks = new HashMap<>();

    }


    public int nextId() {
        return taskCounter++;
    }


    public void addTask(Task task) {
        int newId = nextId();
        task.setId(newId);
        tasks.put(task.getId(), task);
    }

    public void addEpicTask(EpicTask epicTask) {
        int newId = nextId();
        epicTask.setId(newId);
        epicTasks.put(epicTask.getId(), epicTask);
    }

    public void addSubTask(int epicTaskId, SubTask subTask) {
        int newId = nextId();
        subTask.setId(newId);
        getEpicTaskByID(epicTaskId).subTasksId.add(subTask.getId());
        subTask.epicTaskId = epicTaskId;
        subTasks.put(subTask.getId(), subTask);

    }


    public Task getTaskByID(int taskId) {
        return epicTasks.get(taskId);
    }

    public EpicTask getEpicTaskByID(int taskId) {
        return epicTasks.get(taskId);
    }

    public SubTask getSubTaskByID(int taskId) {
        return subTasks.get(taskId);
    }


    //Пункт Менеджер 2.а
    public void printAllTask(){
        for (Task value : tasks.values()) {
            System.out.println(value + "\n");
        }
    }
    public void printAllEpicTask(){
        for (EpicTask value : epicTasks.values()) {
            System.out.println(value + "\n");
        }
    }
    public void printAllSubTask(){
        for (SubTask value : subTasks.values()) {
            System.out.println(value + "\n");
        }
    }


    public void updateTask(Task updateTask) {
        if (tasks.containsKey(updateTask.getId())) {
            Task task = tasks.get(updateTask.getId());
            if (updateTask.getName() != null) {
                task.setName(updateTask.getName());
            }
            task.setDescription(updateTask.getDescription());
            task.setStatus(updateTask.getStatus());
        }
    }

    public void updateEpicTask(Task updateEpicTask) {
        if (epicTasks.containsKey(updateEpicTask.getId())) {
            EpicTask epicTask = epicTasks.get(updateEpicTask.getId());
            if (updateEpicTask.getName() != null) {
                epicTask.setName(updateEpicTask.getName());
            }
            epicTask.setDescription(updateEpicTask.getDescription());
        }
    }

    public void updateSubTask(Task updateSubTask) {
        if (subTasks.containsKey(updateSubTask.getId())) {
            SubTask subTask = subTasks.get(updateSubTask.getId());
            if (updateSubTask.getName() != null) {
                subTask.setName(updateSubTask.getName());
            }
            subTask.setDescription(updateSubTask.getDescription());
            subTask.setStatus(updateSubTask.getStatus());
            checkEpicTaskStatus(subTask.getEpicTaskId());
        }
    }

    private void checkEpicTaskStatus(Integer epicTaskId) {
        EpicTask epicTask = getEpicTaskByID(epicTaskId);

        int countStatusInProgress = 0;
        int countStatusDone = 0;
        for (Integer value : epicTask.subTasksId) {
            if (subTasks.get(value) != null) {
                if (subTasks.get(value).getStatus().equals(Status.IN_PROGRESS)){
                    countStatusInProgress++;
                } else if (subTasks.get(value).getStatus().equals(Status.DONE)) {
                    countStatusDone++;
                }
            }
        }
        if (countStatusInProgress > 0 ||  countStatusDone > 0) {
            epicTask.setStatus(Status.IN_PROGRESS);
        }
        if (countStatusDone == epicTask.subTasksId.size()){
            epicTask.setStatus(Status.DONE);
        }
        if (countStatusInProgress == 0 && countStatusDone == 0) {
            epicTask.setStatus(Status.NEW);
        }
    }


    public void deleteTaskById(Integer taskId) {
        tasks.remove(taskId);
    }

    public void deleteEpicTaskById(Integer taskId) {
        for (Integer value : getEpicTaskByID(taskId).subTasksId) {
            subTasks.remove(value);
        }
        epicTasks.remove(taskId);
    }

    public void deleteSubTaskById(Integer subTaskId) {
        Integer epicTaskId = getSubTaskByID(subTaskId).epicTaskId;
        subTasks.remove(subTaskId);
        for (Integer value : getEpicTaskByID(epicTaskId).subTasksId) {
            if (Objects.equals(value, subTaskId)) {
                getEpicTaskByID(epicTaskId).subTasksId.remove(value);
            }
        }
        checkEpicTaskStatus(epicTaskId);
    }


    public void deleteAllTasks() {
        tasks.clear();
    }

    public void deleteAllEpicTasks() {
        epicTasks.clear();
        subTasks.clear();
    }

    public void deleteAllSubTasks() {
        subTasks.clear();
        for (Integer value : epicTasks.keySet()){
            getEpicTaskByID(value).subTasksId.clear();
            checkEpicTaskStatus(value);
        }
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
