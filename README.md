# GB-Spring
## Spring Security. Работа с JWT. Защита от основных видов атак.
### Базовое задание:
Условие:

__Внимание__ ДЗ выполнять в версии SpringBoot:2.7.14(модули security и web)
Вам необходимо создать Spring Boot приложение, которое управляет доступом к ресурсам в зависимости от роли пользователя. У вас должно быть два типа пользователей: USER и ADMIN.
1. Создайте ресурс /private-data, доступный только для аутентифицированных пользователей с ролью ADMIN.
2. Создайте ресурс /public-data, доступный для всех аутентифицированных пользователей независимо от их роли.
3. Реализуйте форму входа для аутентификации пользователей с использованием стандартных средств Spring Security.
4. Если неаутентифицированный пользователь пытается получить доступ к /private-data, он должен быть перенаправлен на форму входа.
   _
   Подсказка:
1) Файл HTML:
   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
   </head>
   <body>
   <h2>Login</h2>
   <form action="/login" method="post">
      <div>
         <label for="username">Username:</label>
         <input type="text" id="username" name="username"/>
      </div>
      <div>
         <label for="password">Password:</label>
         <input type="password" id="password" name="password"/>
      </div>
      <input type="submit" value="Login"/>
   </form>
   </body>
   </html>
   ```
2) 
   ```java
   http.authorizeRequests()
   .antMatchers("/private-data").hasRole("ADMIN")
   .antMatchers("/public-data").authenticated()
   .and()
   .formLogin()
   .and()
   .logout()
   .logoutSuccessUrl("/login");
   ```
3) 
   ```java
   auth.inMemoryAuthentication()
   .withUser("user").password("{noop}password").roles("USER")
   .and()
   .withUser("admin").password("{noop}password").roles("ADMIN");
   ```

---
### Задание со звездочкой:
Разработать 3 проекта реализации составных частей технологии авторизации OAuth 2.0 на SpringBoot:
1) Сервер ресурсов
2) Сервер авторизации на базе JWT
3) Клиент

Клиент должен при нажатии на кнопку (простая форма) получить доступ к ресурсу на сервере (к примеру - картинка котика).
Логин: user, пароль: password