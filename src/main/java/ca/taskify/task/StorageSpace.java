package ca.taskify.task;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "storage_spaces")
public class StorageSpace {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private String location;
    private String imageUrl;
}
