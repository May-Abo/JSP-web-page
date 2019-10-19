package com.may.entity;

import com.may.entity.Account;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-19T14:35:27")
@StaticMetamodel(Country.class)
public class Country_ { 

    public static volatile SingularAttribute<Country, String> country;
    public static volatile CollectionAttribute<Country, Account> accountCollection;
    public static volatile SingularAttribute<Country, Integer> id;

}