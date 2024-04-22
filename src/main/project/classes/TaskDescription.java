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

    public static void main(String[] args) {
        // Task 1
        TaskDescription taskDescription1 = new TaskDescription();
        taskDescription1.setTitle("Hvordan har Mikkel det?");
        taskDescription1.setDescription("Mikkel er ikke glad, men han ved at X ikke gjorde det med vilje.\n\nPrøv at skifte Mikkels ansigtsudtryk og kropssprog efter hvordan DU tror han har det.");

        // Define taskTitle1
        String taskTitle1 = "Hvordan har Mikkel det?2";

        // Task 1 object and set title, description, audio
        Task task1 = new Task();
        task1.setTaskTitle(taskTitle1);
        task1.setTaskDescription(taskDescription1);
        task1.setAudioFilePath("src/main/audio_files/kill_me.mp3");
        task1.playAudio();

        // Task 2
        TaskDescription taskDescription2 = new TaskDescription();
        taskDescription2.setTitle("Title 2");
        taskDescription2.setDescription("Description 2");

        // Define taskTitle2
        String taskTitle2 = "Title 2";

        // Task 2 object and set title and description
        Task task2 = new Task();
        task2.setTaskTitle(taskTitle2);
        task2.setTaskDescription(taskDescription2);
        task2.setAudioFilePath("src/main/audio_files/kill_me.mp3");
        task2.playAudio();
    }
}