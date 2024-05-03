package com.example.tzrstech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TzrstechApplication {
    //TODO
    // 1. Попробовать что нибудь с Фронтом
    // 2. Docker
    // 3. Поправить то о чем Паша говорил(Рефакторинг)
    // 4. Сделать получение всех продуктов по категории
    // 5. Переделать статус с bool на Enum
    // 6. Почему при создании возвращает id = null(узнать про @PostPersist)
    // 7. Определиться как передавать категорию(целиком или по названию или по id)
    // 8. Узнать про нагрузочное тестирование
    // 9. Попробовать прикрутить RabbitMQ
    public static void main(String[] args) {
        SpringApplication.run(TzrstechApplication.class, args);
    }
}
