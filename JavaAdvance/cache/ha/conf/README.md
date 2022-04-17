### Redis 主从复制

- redis6379.conf
- redis6380.conf
- redis6381.conf

1. 修改端口号port，
2. 修改文件夹dir，
3. 修改pidifile

```
$ redis-server redis6379.conf & # 主库
$ redis-server redis6380.conf & # 启动从库1
$ redis-server redis6381.conf & # 启动从库2

$ redis-cli -h 127.0.0.1 -p 6380 # 连接从库1
slaveof 127.0.0.1 6379

$ redis-cli -h 127.0.0.1 -p 6381 # 连接从库2
slaveof 127.0.0.1 6379
```


### Redis Sentinel 自动主从切换

- sentinel0.conf
- sentinel1.conf

启动两个 sentinel 的节点，专门去监控redis-server 的状态和自动主从切换

可以使用客户端直接连接 Sentinel

```
redis-cli -h 127.0.0.1 -p 26380

>info 

or

>sentinel masters

```


