package main.project.classes;

public class Task {
    // Add the TaskDescription object
    private TaskDescription taskDescription;

    // Add the TaskDescription object as a parameter to the constructor
    public TaskDescription getTaskDescription() {
        return taskDescription;
    }

    // Add the TaskDescription object as a parameter to the constructor
    public void setTaskDescription(TaskDescription taskDescription) {
        this.taskDescription = taskDescription; // Call the constructor of the superclass (Task) with the taskDescription
    }

}
