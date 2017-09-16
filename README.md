Подготовка базы данных:
1. из папки "db" подключиться к базе данных mysql $ -u root -p 
2. creation.sql
3. mysql -u bank -p1234 bank
Проект запуск: из проекта
1. mvn package
2. mvn spring-boot:run

task:

Написать веб-приложение, выполняющее функции банка. 
Пусть это будет банк в городе N насчитывающем около 50 жителей.

Нужно хранить данные о:
- клиентах банка (идентификатор, имя — адрес, возраст);
- счетах (идентификатор, идентификатор владельца, количество денег);
- транзакциях — переводах денег между счетами или их поступлениях / списаниях.

Приложение должно содержать 3 страницы и дополнительные формы:
- список клиентов банка, при щелчке по имени открываются счета выбранного клиента (плюс внизу форма для добавления нового клиента);
- список счетов заданного клиента (плюс внизу форма для добавления нового счёта);
- форма для перевода денег между счетами (и для пополнения / списания денег: это могут быть отдельные формы, на ваш вкус);
- страница со списком транзакций (сверху форма фильтра, чтобы можно было выбрать за период и/или по заданному пользователю);
- дополнения — на ваш вкус, например, в списке клиентов можно сумму на всех счетах у каждого выводить и т. п.

Задание должно быть выполнено с применением технологий, инструментов и библиотек:
- Spring-boot
- база данных MySQL

Исходный код выложить на GitHub, задание снабдить пояснительной запиской как откомпилировать и запустить проект
