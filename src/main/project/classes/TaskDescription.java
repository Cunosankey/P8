package main.project.classes;

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
        taskDescription1.setTitle("Hvordan har\nJeppe det?");
        taskDescription1.setDescription("Hvordan tror du, at Jeppe har det efter hans ven overtog spillet for ham?\n\nEns følelser kan skinne igennem udefra, så nu skal du prøve at vise hvordan Jeppe har det ved at vælge hans ansigtsudtryk og kropsudtryk.\n\nHusk, der er ingen rigtige eller forkerte svar.");
        return taskDescription1;
    }

}