#название образа
FROM maven:3.8.3-openjdk-17

#копируем (две точки черех пробел значит что все на уровне Dockerfile скопируется с этими же
#именами в образ) и собираем его
COPY . .
RUN mvn clean install

#запуск (такой командой осуществляется запуск spring-boot проект через maven)
CMD mvn spring-boot:run
