package com.example.springboottests.configuration;

import com.example.springboottests.model.persistence.PersonEntity;
import com.example.springboottests.model.persistence.WalletEntity;
import com.example.springboottests.model.transport.PersonTransportObject;
import com.example.springboottests.model.transport.WalletTransportObject;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrikaConfiguration {

  private static final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

  static {
    registerPersonMapper(mapperFactory);
    registerWalletMapper(mapperFactory);
  }

  private static void registerPersonMapper(MapperFactory mapperFactory) {
    mapperFactory.classMap(PersonEntity.class, PersonTransportObject.class)
        .field("first_name", "firstName")
        .field("last_name", "lastName")
        .byDefault()
        .register();
  }

  private static void registerWalletMapper(MapperFactory mapperFactory) {
    mapperFactory.classMap(WalletEntity.class, WalletTransportObject.class)
        .byDefault()
        .register();
  }

  @Bean
  public static MapperFacade mapperFacade() {
    return mapperFactory.getMapperFacade();
  }
}
