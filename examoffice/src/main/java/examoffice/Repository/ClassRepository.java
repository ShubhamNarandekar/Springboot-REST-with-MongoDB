package examoffice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import examoffice.Document.ClassDoc;

public interface ClassRepository extends MongoRepository<ClassDoc, Integer> {
    
}
