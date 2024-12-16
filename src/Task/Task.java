package Task;

public class Task {
    private Status status = Status.NEW;
    protected TaskType typeTask;
    private String name;
    private String description;
    public Integer taskId;

    public Task(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.taskId = setId(name, description);
        this.typeTask = TaskType.TASK;
    }

    public Task(String name, String description, Status status)
    {
        this.name = name;
        this.description = description;
        this.taskId = setId(name, description);
        this.typeTask = TaskType.TASK;
        this.status = status;
    }



    public Task(Status status)
    {
        this.status = status;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TaskType getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(TaskType typeTask) {
        this.typeTask = typeTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return taskId;
    }


    public int setId(String name, String description) {
        int hash = 17;
        if (name != null) {
            hash = hash + name.hashCode();
        }
        hash = hash * 31;

        if (description != null) {
            hash = hash + description.hashCode();
        } else {
            hash = hash * 31;
        }

        return hash;
    }

    @Override
    public String toString() {
        return "TaskManager.TaskManager.Task.Task{" +
                "status=" + status +
                ", typeTask=" + typeTask +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + taskId +
                '}';
    }

}
