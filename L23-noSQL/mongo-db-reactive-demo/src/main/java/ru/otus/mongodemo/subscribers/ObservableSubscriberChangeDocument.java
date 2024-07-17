package ru.otus.mongodemo.subscribers;

import com.mongodb.client.model.changestream.ChangeStreamDocument;
import com.mongodb.client.model.changestream.OperationType;
import org.bson.Document;

@SuppressWarnings("unused")
public class ObservableSubscriberChangeDocument extends ObservableSubscriber<ChangeStreamDocument<Document>> {

    public ObservableSubscriberChangeDocument() {
        super(true);
    }

    public ObservableSubscriberChangeDocument(boolean printOnNextElement) {
        super(printOnNextElement);
    }

    @Override
    public void onNext(ChangeStreamDocument<Document> changedDocument) {
        Document document = changedDocument.getFullDocument();
        OperationType operation = changedDocument.getOperationType();
        System.out.printf("operation: %s, changed document: %s%n", operation, document); // NOSONAR
    }
}
