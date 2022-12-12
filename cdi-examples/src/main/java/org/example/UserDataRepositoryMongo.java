package org.example;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Named("userMongoRepository")
@Alternative
public class UserDataRepositoryMongo implements UserDataRepository{
    @Override
    public void save(User user) {

    }
}
