package org.example;

import javax.inject.Inject;
import javax.inject.Named;

public class UserService {
    private final UserDataRepository userDataRepository;

    @Inject
    public UserService(@Named("userMongoRepository") UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public void persistUser(User user) {
        userDataRepository.save(user);
    }
}
