package by.dilo1992.telegrambotarso.model;

public enum BotCommands {
    START("getting started with the bot"),
    INFO("info about LLC 'ArsoBeton'"),
    PRODUCTS("obtain information about manufactured products and reference prices"),
    CONTACTS("our bot couldn't help? Contact our specialists!"),
    MYCREDS("find out your login details"),
    WEBSITE("visit our website for more information about our work"),
    EXIT("get away from us :-(");

    private String description;

    BotCommands(String description) {
        this.description = description;
    }

    public String getName() {
        return "/" + name().toLowerCase();
    }

    public String getDescription() {
        return description;
    }

    public static String getAllCommandsAndTheirDescription() {
        String nameOfCommandAndHerDescription = "";
        for (BotCommands botCommands : BotCommands.values()) {
            nameOfCommandAndHerDescription += "/" + botCommands.name().toLowerCase() + ": " + botCommands.description + "\n";
        }
        return nameOfCommandAndHerDescription;
    }
}

