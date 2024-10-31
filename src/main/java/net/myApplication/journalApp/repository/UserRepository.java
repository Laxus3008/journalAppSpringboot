package net.myApplication.journalApp.repository;

import net.myApplication.journalApp.entity.JournalEntry;
import net.myApplication.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String userName);

    void deleteByUserName(String username);
}
