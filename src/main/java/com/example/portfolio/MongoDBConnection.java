package com.example.portfolio;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDBConnection {

    private static final String URI = "mongodb+srv://gayetbastien8:r-%4096RnPHm%40x6CK@portfolio-dev-cluster.l3bye.mongodb.net/yourDatabaseName?retryWrites=true&w=majority";

    public void connectToMongoDB() {
        ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(URI))
                .serverApi(serverApi)
                .build();

        // Create a MongoDB client
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase("admin");
            executePingCommand(database);
        } catch (MongoException e) {
            System.err.println("MongoDB client creation failed: " + e);
        }
    }

    // Execute the ping command to check if the connection is successful
    private void executePingCommand(MongoDatabase database) {
        try {
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            Document commandResult = database.runCommand(command);
            System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        } catch (MongoException me) {
            System.err.println("MongoDB connection failed: " + me);
        }
    }
}