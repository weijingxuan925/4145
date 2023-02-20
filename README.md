# CSCi4145
for project in CSCI4145 cloud computing

# introduction
this is a blog project

# Author
- [JingxuanWei](jn728702@dal.ca)
- B00844431

## how to send to the docker
1. `cd csci4145`
2. `docker build -t myproject . `
3. `docker login `
4. `docker tag myproject weijingxuan925/vlog:latest`
5. `docker push weijingxuan925/vlog:latest`

## pull from docker
1. `docker pull weijingxuan925/vlog:latest`
2. `docker run -p 80:80 -d weijingxuan925/vlog:latest`
3. `docker run -p 80:80 --name myproject --network host -e SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/flame -e  SPRING_DATASOURCE_USERNAME=root -e  SPRING_DATASOURCE_PASSWORD=Wjx010925 weijingxuan925/vlog`
4. 注意，使用这种网络模式有一些限制和安全隐患，请确保你理解这些风险并根据你的实际情况来决定是否使用这种方式。如果你不确定，那么请使用默认的桥接网络模式。