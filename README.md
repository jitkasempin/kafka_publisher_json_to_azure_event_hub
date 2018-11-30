# kafka_publisher_json_to_azure_event_hub
This demo is for test kafka publisher that publish json string to Azure Event Hub (enable Kafka support)

# How to setup Azure event hub to enable Kafka (or understand Kafka message)
1. Check the Enable Kafka checkbox
2. In the Pricing Tier -> must choose Standard only (not Basic)
3. After creating Event Hubs Namespace then create the Event Hub or topic and name it whatever you want

# Develop the code for sending json message (or json String) to Event Hub Kafka
I modified the code from https://github.com/jitkasempin/azure-event-hubs-for-kafka/tree/master/quickstart/java/producer
and change the code from sending normal string to sending json object instead

Please follow the instruction at https://github.com/jitkasempin/azure-event-hubs-for-kafka/tree/master/quickstart/java
for how to config the endpoint and run this java application

