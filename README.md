# Start infrastructure
```
docker-compose up -d
```

# Running the app transform-kafka locally
```
./gradlew bootRun
```


## Call URL to send message 
```
curl --location --request POST 'localhost:8081/api/v1/message' \
--header 'Content-Type: application/json' \
--data-raw '{
"value": "value"
}'
```

# Stop infrastructure
```
docker-compose stop
```