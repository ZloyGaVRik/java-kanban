package task;

import java.util.Objects;

public class Task {
    private Status status = Status.NEW;
    protected TaskType typeTask;
    private String name;
    private String description;
    private Integer taskId;

    public Task(Integer taskId, String name, String description)
    {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
        this.typeTask = TaskType.TASK;
    }

    public Task(Integer taskId, String name, String description, Status status)
    {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
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

    public Integer getId() {
        return taskId;
    }

    public void setId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "taskManager.TaskManager.task.Task{" +
                "status=" + status +
                ", typeTask=" + typeTask +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + getId() +
                '}';
    }


}
