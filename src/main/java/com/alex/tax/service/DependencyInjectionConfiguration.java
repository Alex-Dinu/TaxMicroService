package com.alex.tax.service;

import com.alex.tax.service.factory.TaxFactoryOrchestrator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alex.tax.service.factory.*;

@Configuration
public class DependencyInjectionConfiguration {

        // @Bean
        // public TaxService taxService(@Autowired TaxFactoryOrchestrator  taxFactoryOrchestrator){
        //     return new TaxService(taxFactoryOrchestrator);
        // }

        @Bean
        public TaxFactoryOrchestrator taxFactoryOrchestrator() {
            return new TaxFactory();
        }
}
