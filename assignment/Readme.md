Steps to create the connections group with multiple nodes

1. create Connection group 
      curl --location --request POST 'localhost:9999/connections/api/v1//creategroup' \
      --header 'Content-Type: application/json' \
      --data-raw '{
          "id":2,
          "name": "group 2"
      }'

2. register node:
      curl --location --request POST 'localhost:9999/connections/api/v1//registernode' \
      --header 'Content-Type: application/json' \
      --data-raw '{
          "id":7,
          "name":"node 7",
          "connection_group_id":2
      }'

3. create connection:
      curl --location --request POST 'localhost:9999/connections/api/v1/createconnections' \
      --header 'Content-Type: application/json' \
      --data-raw '{
          "from_node_id":1,
          "to_node_id":7
      }'

4. To get the id of connection group of a perticular node
     curl --location --request GET 'localhost:9999/connections/api/v1/1'
