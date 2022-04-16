### Redis 主从复制

- redis6379.conf
- redis6380.conf

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


