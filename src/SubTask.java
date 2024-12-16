public class SubTask extends Task{
    protected Integer epicTaskId;

    public SubTask(String name, String description) {
        super(name, description);
        this.taskId = setId(name, description);
        this.typeTask = TaskType.SUBTASK;
    }

    public SubTask(String name, String description, Status status) {
        super(name, description);
        this.typeTask = TaskType.SUBTASK;
        this.taskId = setId(name, description);
        this.setStatus(status);
    }

    @Override
    public String toString() {
        return "TaskManager.SubTask{" +
                "status=" + getStatus() +
                ", typeTask=" + typeTask +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + taskId +
                ", epicId=" + epicTaskId +
                '}';
    }

}
