package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.repository.EnglishGreetingRepository;
import guru.springframework.sfgdi.repository.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }
    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18NSpanishService i18NSpanishService(){ return new I18NSpanishService();}
    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){return new I18nEnglishGreetingService(englishGreetingRepository);}
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){return new PrimaryGreetingService();}
    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
