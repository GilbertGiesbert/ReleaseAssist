package de.joern.play.releaseassist.configuration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class UrlLocaleResolver implements LocaleResolver {

    private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
    private static final Locale[] SUPPORTED_LOCALES = {DEFAULT_LOCALE, Locale.GERMAN};

    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        String lang = request.getParameter("lang");
        for(Locale locale : SUPPORTED_LOCALES){
            if(StringUtils.equals(locale.getLanguage(), lang)){
                return locale;
            }
        }
        return DEFAULT_LOCALE;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // not needed
    }

}
