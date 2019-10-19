package com.may.entity;

import com.may.entity.Country;
import com.may.entity.Userlogs;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-19T10:19:27")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> firstName;
    public static volatile SingularAttribute<Account, String> lastName;
    public static volatile SingularAttribute<Account, Country> country;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> phoneNumber;
    public static volatile CollectionAttribute<Account, Userlogs> userlogsCollection;
    public static volatile SingularAttribute<Account, Integer> id;
    public static volatile SingularAttribute<Account, String> userName;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, Integer> status;

}