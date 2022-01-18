package com.nekochanoide.univerSpringSecurity.config;

import com.nekochanoide.univerSpringSecurity.services.UsersService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UsersService usersService;

    public WebSecurityConfig(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()

                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/register").not().fullyAuthenticated()

                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/news").hasRole("USER")

                //Доступ разрешен всем пользователям
                .antMatchers("/", "/resources/**").permitAll()

                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()

                //Настройка для входа в систему
                .and()
                .formLogin()
                .loginPage("/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()

                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
