package ca.taskify.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
    @Id
    private ObjectId Id;

    private String body;
    private String _class;
}
