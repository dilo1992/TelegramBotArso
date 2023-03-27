package by.dilo1992.telegrambotarso.model;

public enum BotCommandsEnum {
    START("getting started with the bot"),
    INFO("info about LLC 'ArsoBeton'"),
    PRODUCTS("obtain information about manufactured products and reference prices"),
    CONTACTS("our bot couldn't help? Contact our specialists!"),
    WEBSITE("visit our website for more information about our work"),
    EXIT("get away from us :-(");

    private String description;

    BotCommandsEnum(String description) {
        this.description = description;
    }

    public String getName() {
        return "/" + name().toLowerCase();
    }

    public String getDescription() {
        return description;
    }

    public static String getAllCommandsAndTheirDescription() {
        String string = "";
        for (BotCommandsEnum botCommandsEnum : BotCommandsEnum.values()) {
            string += "/" + botCommandsEnum.name().toLowerCase() + ": " + botCommandsEnum.description + "\n";
        }
        return string;
    }
}

