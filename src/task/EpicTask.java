package task;

import java.util.ArrayList;

public class EpicTask extends Task {
    public ArrayList<Integer> subTasksId;

    public EpicTask(Integer taskId, String name, String description) {
        super(taskId, name, description);
        this.typeTask = TaskType.EPIC;
        this.subTasksId = new ArrayList<>();

    }


    @Override
    public String toString() {
        return "taskManager.TaskManager.task.Task.EpicTask{" +
                "status=" + getStatus() +
                ", typeTask=" + typeTask +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() +
                ", subTaskId=" + subTasksId +
                '}';
    }


}
