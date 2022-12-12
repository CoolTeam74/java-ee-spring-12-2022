package org.example;

public class UserServiceFactory {
    //
    public UserService getInstance() {
        return new UserService(new UserDataRepositoryImpl());
    }
}
