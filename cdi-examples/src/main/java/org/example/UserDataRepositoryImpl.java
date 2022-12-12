package org.example;

import javax.enterprise.inject.Alternative;

@Alternative
public class UserDataRepositoryImpl implements UserDataRepository {
    @Override
    public void save(User user) {
        // presist into database
    }
}
