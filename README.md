Домашнее задание №5

В рамках одной транзакции произвести комплексное обновление связанных таблиц (обновление двух таблиц)

Скачать и установить базу данных на выбор: postgresql ,  mysql, oracle.
Создать несколько таблиц (любых), так, что бы между ними было хотя бы отношение «один ко многим» или «многие ко многим»
Написать программу, которая будет подключаться к базе данных и производить чтение-запись(в методе main,например, сделать сохранение, обновление, чтение и удаление). 
В рамках одной транзакции произвести комплексное обновление связанных таблиц (обновление двух таблиц)
Для каждой таблицы должна существовать Entity в вашей программе.
Подключение к бд осуществить через Hibernate
Конфигурацию подключения вынести в конфигурационный файл, в java коде не хранить конфигурацию.
Использовать свойство  ddl.auto update для автоматического обновления схемы бд.

НАЧАЛЬНЫЕ ДАННЫЕ:

Были создана MySQL база данных Homework5 итаблицы product и laptop. Laptop связана с Product через FOREIGN KEY model:

CREATE TABLE product 
(
id smallint unsigned not null auto_increment, 
maker varchar(20) not null, 
model varchar(20) not null, 
type varchar(20) not null, 
primary key (id),
UNIQUE INDEX id_UNIQUE (id),
INDEX (model)
);

CREATE TABLE laptop 
(
id smallint unsigned not null auto_increment, 
model varchar(20) not null, 
ram smallint not null,
price smallint not null,
screen smallint not null,  
primary key (id),
FOREIGN KEY (model) REFERENCES product(model) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO product (maker, model, type) VALUES ('asus', 'gl502vs', 'laptop');
INSERT INTO product (maker, model, type) VALUES ('apple', 'macbook', 'laptop');
INSERT INTO product (maker, model, type) VALUES ('apple', 'iphone', 'phone');
INSERT INTO product (maker, model, type) VALUES ('asus', 'rogphone', 'phone');

INSERT INTO laptop (model, ram, price,screen) VALUES ('gl502vs', 16, 106, 15);
INSERT INTO laptop (model, ram, price,screen) VALUES ('macbook', 999, 130, 13);
