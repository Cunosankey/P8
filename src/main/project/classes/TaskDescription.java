package PACKAGE_NAME.src.main.project.classes;

public class TaskDescription {
    private String title;
    private String description;

    // Getters and setters for the properties
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static TaskDescription createTaskDescription1() {
        TaskDescription taskDescription1 = new TaskDescription();
        taskDescription1.setTitle("Hvordan har Mikkel det?");
        taskDescription1.setDescription("Mikkel er ikke glad, men han ved at X ikke gjorde det med vilje.\n\nPrøv at skifte Mikkels ansigtsudtryk og kropssprog efter hvordan DU tror han har det.");
        return taskDescription1;
    }



}