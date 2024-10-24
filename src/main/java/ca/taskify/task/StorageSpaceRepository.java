package ca.taskify.task;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StorageSpaceRepository extends MongoRepository<StorageSpace, String> {
}
