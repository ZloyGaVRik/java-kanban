package task;

public class SubTask extends Task {
    public Integer epicTaskId;

    public SubTask(Integer taskId, String name, String description) {
        super(taskId, name, description);
        this.typeTask = TaskType.SUBTASK;
    }

    public SubTask(Integer taskId, String name, String description, Status status) {
        super(taskId, name, description);
        this.typeTask = TaskType.SUBTASK;
        this.setStatus(status);
    }

    public int getEpicTaskId(){
        return epicTaskId;
    }

    @Override
    public String toString() {
        return "taskManager.TaskManager.task.Task.SubTask{" +
                "status=" + getStatus() +
                ", typeTask=" + typeTask +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() +
                ", epicId=" + epicTaskId +
                '}';
    }

}
