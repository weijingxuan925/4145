# CSCi4145
for project in CSCI4145 cloud computing

# introduction
this is a blog project

# Author
- [JingxuanWei](jn728702@dal.ca)
- B00844431


## how to run
1. install docker
2. install docker-compose
3. run `docker-compose up`
4. open browser and go to `localhost:8080`

## how to stop
1. run `docker-compose down`
2. run `docker system prune -a`
3. run `docker volume prune`
4. run `docker network prune`
5. run `docker image prune`
6. run `docker container prune`
7. run `docker rmi $(docker images -q)`
8. run `docker rm $(docker ps -a -q)`
9. run `docker volume rm $(docker volume ls -q)`

