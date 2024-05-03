# RsTech
<h1>Необходимо разработать REST API для отображения и администрирования каталога продуктов.</h1>
<h2>Описание сущностей:</h2>
<h3>Продукт:</h3>
- Наименование
<br>- Описание
<br>- Цена
<br>- Изображение
<br>- Категория(Создать продукт без назначения категории не возможно)
<br>- Дата добавления в каталог
<br>- Статус (активен/не активен)
<h3>Категория:</h3>
- Наименование
<br>- Краткое описание
<h2>Действия над сущностями:</h2>
<h3>Продукт:</h3>
- Создать
<br>- Удалить
<br>- Редактировать (Поменять поля, назначить категорию)
<br>- Поиск(Просмотр списка продуктов с фильтрами)(Искать по категории, по наименованию и по диапазону цен ОТ/ДО).
<h3>Категория:</h3>
- Создать
<br>- Удалить (При этом у всех продуктов данной категории должен быть проставлен статус - "не активен")
<br>- Просмотр списка категорий
<br>- Редактировать
<p>
Данные можно хранить в памяти приложения, но плюсом было бы подключить бд и хранить данные там (желательно воспользоваться любым облачным решением), используя библиотеку Hibernate.
Необходимо обработать возможные ошибки и возвращать их из API.
Допускается использование любых дополнительных библиотек.
Покрывать приложение тестами не нужно.
</p>
Технологии: Java, Spring Boot, Maven.
<h2>Плюсом будет:</h2>
<ol>
<li> Если будет написан минимальный Front-end (JSP, Javascript(нативный или JQuery).
<li> Если будет внедрена документация API(Swagger).
<li> Если будет реализована Bearer Token (Логин/Пароль) авторизация с двумя типами пользователей:
   <ul>USER: Имеет доступ к просмотру списка категорий и поиску по продуктам.</ul>
   <ul>ADMIN: Имеет полный функционал.</ul>
   <ul>Не авторизованный пользователь: не имеет доступа ни к чему, кроме авторизации.</ul>
</ol>
