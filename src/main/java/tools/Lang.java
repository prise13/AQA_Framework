package tools;

public enum Lang {
    SUBSCRIBE_RU {
        public String toString() {
            return "Подписаться";
        }
    },
    SUBSCRIBE_UA {
        public String toString() {
            return "Подписаться";
        }
    },
    SEARCH_UA {
        public String toString() {
            return "Введення пошукового запиту";
        }
    },
    SEARCH_RU {
        public String toString() {
            return "Ввод поискового запроса";
        }
    },
    SUBSCRIBED_UA {
        public String toString() {
            return "Відстежується";
        }
    },
    SUBSCRIBED_RU {
        public String toString() {
            return "Подписки";
        }
    },
    SUBMIT_UA {
        public String toString() {
            return "Опублікувати";
        }
    },
    SUBMIT_RU {
        public String toString() {
            return "Опубликовать";
        }
    },
    MESSAGE_RU {
        public String toString() {
            return "Отправить сообщение";
        }
    },
    MESSAGE_UA {
        public String toString() {
            return "Повідомлення";
        }
    }
}
