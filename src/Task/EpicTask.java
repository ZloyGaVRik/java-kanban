package Task;

import java.util.ArrayList;

public class EpicTask extends Task {
    public ArrayList<Integer> subTasksId;

    public EpicTask(String name, String description) {
        super(name, description);
        this.taskId = setId(name, description);
        this.typeTask = TaskType.EPIC;
        this.subTasksId = new ArrayList<>();

    }


    @Override
    public String toString() {
        return "TaskManager.TaskManager.Task.Task.EpicTask{" +
                "status=" + getStatus() +
                ", typeTask=" + typeTask +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + taskId +
                ", subTaskId=" + subTasksId +
                '}';
    }


}
