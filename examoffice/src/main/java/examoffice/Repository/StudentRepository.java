package examoffice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import examoffice.Document.StudentDoc;

public interface StudentRepository extends MongoRepository<StudentDoc, Integer> {
    
}
