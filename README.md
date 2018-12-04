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

# Stream the data in Azure Event Hub to Azure Blob Storage

The data in Azure Event Hub can be sent to Azure Blob Storage in order to store the streaming data as the file.
You can do this by using Service in Azure called "Stream Analytics Job" with the following steps...

         1. "Add Stream Input" inside "Stream Analytics Job" console, select type of stream input as "Event Hub"
         2. Enter an information for "Event Hub" stream input and for "Event Serialization Format" select JSON and then click SAVE button
         3. In Job topology menu select Outputs and then click on "Add" button to add the output.
         4. Select "Blob storage" from the dropdown menu.
         5. Config the Blob Storage such as your Container to store the file and set "Event serialization format" as JSON and then click SAVE button
         6. After you add the input and output for the Stream Analytics Job then click on "Query" under "Job topology" menu.
         7. Assign the Input alias and Output alias that you build on the above step and then type the query like below in the textbox area

        SELECT
    				*
				INTO
    				[yourOutputAlias]
				FROM
    				[youtInputAlias]

    	 8. Click on Save
    	 9. Go back to the Overview page and then you could see the Start button above the general information, click on the Start button to run the "Stream Analytics Job".
    	 10. Now you can stream the data from Azure Event Hub into the file on Azure Blob Storage. The file on Azure Blob Storage will be json file contain the data inside Azure Event Hub.
