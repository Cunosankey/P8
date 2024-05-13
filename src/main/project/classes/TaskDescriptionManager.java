package main.project.classes;

public class TaskDescriptionManager {
    private static TaskDescriptionManager instance;
    private TaskDescription taskDescription;

    private TaskDescriptionManager() {
    }

    public static TaskDescriptionManager getInstance() {
        if (instance == null) {
            instance = new TaskDescriptionManager();
        }
        return instance;
    }

    public void setTaskDescription(TaskDescription taskDescription) {
        this.taskDescription = taskDescription;
    }

    public TaskDescription getTaskDescription() {
        return taskDescription;
    }
}