# fund-trace

#### 介绍
基金-追踪

#### 软件架构
软件架构说明


#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  xxxx

### 接口说明
db-data-engine(provider):9021,9022
eureka-zone(eureka):9001,9002
fund(customer):9012
zuul-route(zuul):9031
service-monitor(monitor):9041
sideCar:9051
sidecar-nodejs:9052
sidecar-py:9061
service-config:9071
service-zipkin: 9081
service-systeminfo: 9091
 Fetching config from server at : http://localhost:9071/
#Redis
./src/redis-server redis.conf
redis-cli.exe --cluster create 127.0.0.1:9501 127.0.0.1:9502 127.0.0.1:9503 127.0.0.1:9504 127.0.0.1:9505 127.0.0.1:9506 --cluster-replicas 1

#nodejs
node nodejs-service/Node-server.js
 
 #docker-compose
 curl -L "http://github.com/docker/compose/releases/download/1.27.3/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
    curl -L "http://github.com/docker/compose/releases/download/1.27.3/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

#
```shell script
docker tag local-image:tagname new-repo:tagname
docker push new-repo:tagname
```
docker stop $(docker ps -a -q)

如果想要删除所有container的话再加一个指令：

docker rm $(docker ps -a -q)

semanage port -l | grep http_port_t

semanage port -a -t http_port_t  -p tcp 6379

mvn clean package docker:build
```dockerfile
FROM redis

ENV REDIS_PORT 7000

EXPOSE $REDIS_PORT

COPY entrypoint.sh /usr/local/bin/
COPY redis.conf /usr/local/etc/

ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
CMD ["redis-server", "/usr/local/etc/redis.conf"]
```
vim ~/.bashrc
    PS1="\[\e[33;41m\][\u@\h \w]\$\[\e[0m\] "
source ~/.bashrc

docker run --rm -it inem0o/redis-trib create --replicas 1 192.168.247.132:8001 192.168.247.132:8002 192.168.247.132:8003 192.168.247.132:8004 192.168.247.132:8005 192.168.247.132:8006

docker run -d --name jenkins -p 8080:8080 -v /home/jenkins:/home/jenkins jenkins/jenkins:lts

https://github.com/Groundhog-Chen/vue-material-admin.git

imagesid=`docker images|grep -i docker-test|awk '{print $3}'`
project=/root/.jenkins/workspace/Docker
if ! -n "$imagesid";then
   echo $imagesid "is null"
else
    docker rmi $imagesid -f
fi
cd $project
docker build -t docker-test .
if docker ps -a|grep -i docker;then
   docker rm -f docker
fi
docker run -it -d -p 8099:8080 --name docker docker-test

#### 参与贡献
1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)

# fund-trace

#### Description
基金-追踪

#### Software Architecture
Software architecture description

#### Installation

1.  xxxx
2.  xxxx
3.  xxxx

#### Instructions

1.  xxxx
2.  xxxx
3.  xxxx

#### Contribution

1.  Fork the repository
2.  Create Feat_xxx branch
3.  Commit your code
4.  Create Pull Request


#### Gitee Feature

1.  You can use Readme\_XXX.md to support different languages, such as Readme\_en.md, Readme\_zh.md
2.  Gitee blog [blog.gitee.com](https://blog.gitee.com)
3.  Explore open source project [https://gitee.com/explore](https://gitee.com/explore)
4.  The most valuable open source project [GVP](https://gitee.com/gvp)
5.  The manual of Gitee [https://gitee.com/help](https://gitee.com/help)
6.  The most popular members  [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
