Инструкция по развёртыванию:
Внутри директории MyWarehouse_TestTask\src\main\resources\application.properties указывается
1)url адрес БД
2)имя пользователя
3)пароль
Для создания новой БД следует прописать hibernate.hbm2ddl.auto=create
Для взаимодействия с уже существующей вместо create указывается нужная вам операция:validate, update, create-drop, none
Для запуска приложения используется Swagger-UI
В строке браузера прописывается http://localhost:8080/swager-ui