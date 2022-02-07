package org.aguzman.apiservlet.webapp.headers.services;

import jakarta.enterprise.inject.Alternative;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;
/*No se registra porqe no tiene una anotacion de alcance y el el bean.xml esta como annotated
* No le va a parar*/
/*Esta no se registra, es como que si no existiera en el contexto*/
// @Alternative
public class LoginServiceCookieImpl implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies() != null ? req.getCookies(): new Cookie[0];
        return Arrays.stream(cookies)
                .filter(c-> "username".equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }
}
