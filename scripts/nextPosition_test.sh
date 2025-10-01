curl -X POST \
  -H "Content-Type: application/json" \
  -d '{
    "start":{
      "lng": -3.192473,
      "lat": 55.946233
    },
    "angle": 45
  }' \
  http://localhost:8080/api/v1/nextPosition