package ru.job4j.enums;

public enum Status {
    ACCEPTED("Принят") {
        private String message = "Автомобиль принят на СТО";

        @Override
        public String getInfo() {
            return message;
        }
    },
    IN_WORK("В работе"),
    WAITING("Ожидание"),
    FINISHED("Работы завершены");

    private String info;

    Status(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
