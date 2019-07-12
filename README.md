

## 1.  使用 Docker 配置  rabbitmq

```
sudo docker search rabbitmq
sudo docker pull rabbitmq
sudo docker images
// 获得rabbitmq 的镜像ID

-> % sudo docker images                                                                                                              
[sudo] password for jeesk: 
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
rabbitmq            management          f05c3eb3cf91        7 days ago          179MB
elasticsearch       7.2.0               0efa6a3de177        2 weeks ago         861MB
mysql               8.0                 c7109f74d339        4 weeks ago         443MB
mysql               latest              c7109f74d339        4 weeks ago         443MB

sudo docker run -d -p 5672:5672 -p 15672:15672 --name myrabbitmq rabbitmq的镜像ID
比如: 
sudo docker run -d -p 5672:5672 -p 15672:15672 --name myrabbitmq rabbitmq的镜像ID

```

##   使用Docker 配置 elasticsearch
```
sudo docker search elasticsearch
sudo docker pull elasticsearch
sudo docker run -d --name elasticsearch --net somenetwork -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.2.0
启动 elasticsearch 的时候可以使用镜像ID 也可以使用 名字:标签的方式
```