# hood-filler

Steps to run on docker
1. Checkout the project and run a maven install.
2. Build the docker image with name hood-filler. ( sudo docker build -t hood-filler)
3. Run the docker image with the required port. ( eg sudo docker run -p 9090:8080 hood-filler )
4. invoke post api on the url localhost:9090/hoodfiller with json with keys ("hood_capacity" and "present_weigts")
5. Enjoy


Find the sample json attached.

{ 
  "hood_capacity": 41, 
  "present_weights": [2,5,10,50,100] 
} 
