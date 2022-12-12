## Checkstyle

За основу взят стандартный checkstyle on Google: https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml
 
Доработан следующем образом:
1. Отключен MissingJavadocMethod т.к. мы пишем приложения, а не библиотеки и методы в большинстве случаев очевидны из названия, а api документируем через swagger.

## Использование

Подключается опосредованно через parent-pom.

## Idea


1. Скомпилируйте проект, появится файл target/checkstyle-checker.xml.
2. Установите плагин https://plugins.jetbrains.com/plugin/1065-checkstyle-idea
3. Проимпортируйте checkstyle-checker.xml в ситили кодирования idea
4. Проимпортируйте checkstyle-checker.xml в конфигурацию checkstyle плагина

