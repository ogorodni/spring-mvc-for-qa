# Тренинг «Введение в Spring MVC для тестировщиков API и веб-приложений»
15 часов.<br/>
_Рассмотрим аспекты автоматизированного тестирования web-приложений и REST API._

# Для кого 
- ручные QA Spring web-приложений
- разработчики автотестов Spring web-приложений

# На выходе 
- участники поймут структуру REST API и API-автотестов
- смогут ускорить разработку автотестов за счет возможностей Spring и компонентов в его составе

# Программа
## Введение в протокол HTTP и Java EE web-приложения (3/1)
- Задачи и ограничения протокола HTTP
- Методы запросов
- Заголовки
- Статусы ответов
- Параметры и аргументы запросов
- Cookies
- Web-контейнеры
- Структура Java EE web-приложений

### Live coding demo
- Разработка простого get&post echo servlet
- Сборка и развертывание на web-контейнере
- Отладка запросов и ответов в браузере

### Practice Iteration 0
- Анализ Spring CRUD web-приложения
- Сборка и запуск
- Анализ запросов и ответов в браузере

## Концепция REST API и Spring RESTful Services (3/1)
- Сравнение RPC и REST
- Гайдлайны REST API
- JSON-сериализация данных
- REST-клиенты
- Spring MVC для реализации REST API
- Контроллеры
- Отображение данных на JSON

### Live coding demo
- Разработка простого REST-контролллера
- Сборка и развертывание приложения
- Вызовы из REST-клиента

### Practice Iteration 1
- Афиширование Spring CRUD через REST API
- Сборка и запуск
- Анализ запросов и ответов в REST-клиенте

## Автоматизированное тестирование Spring REST API (3/1)
- Структура автоматизированного теста на Spring MVC Test
- Тестовые дублеры для Spring-компонентов
- Тестовые конфигурации
- Тестовые дублеры для внешних веб- и REST-сервисов

### Live coding demo
- Разработка полностью автономного модульного теста
- Замещение Spring-компонентов и внешних сервисов
- Запуск тестового набора
- Анализ отчетности

### Practice Iteration 2
- Покрытие интеграционными тестами Spring CRUD через REST API
- Сборка и запуск тестов
- Анализ тестовой отчетности

## Production-ready REST API (3/1)
- Усложненная JSON-сериализация java-объектов
- Версионирование REST API
- Аутентификация
- Cериализация ошибок
- Документация на Swagger

### Practice Iteration 3
- Рефакторинг приложения до уровня production-ready
- Документирование API на Swagger
- Покрытие интеграционными тестами новых фич REST API
- Сборка и запуск тестов
- Анализ тестовой отчетности

## Микро-сервисная архитектура (3/2)
- Микро-сервисная архитектура
- Архитектурные шаблоны 
- Важность автотестов, сервисных тест-дублёров и документации 

### Practice Iteration 4
- Разработка своего микро-сервисного приложения "с нуля" каждой командой
- Интеграция микро-сервисов команд в единое приложение
