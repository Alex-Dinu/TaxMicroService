package com.alex.tax.service;

import com.alex.tax.service.factory.TaxFactoryOrchestrator;
import com.alex.tax.service.taxrates.TexasTaxRate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alex.tax.repository.TaxGetter;
import com.alex.tax.repository.TaxRepo;
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

        @Bean
        public TaxGetter taxGetter(){
            return new TaxRepo();
        }

}
