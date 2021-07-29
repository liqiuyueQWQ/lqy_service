### NACOS安装

1. 配置maven(3.2.x+),jdk(1.8)环境

2. 下载源码或者安装包

   ```sh
   git clone https://github.com/alibaba/nacos.git
   cd nacos/
   mvn -Prelease-nacos -Dmaven.test.skip=true clean install -U  
   ls -al distribution/target/
   
   // change the $version to your actual path
   cd distribution/target/nacos-server-$version/nacos/bin
   ```

   [最新稳定版本](https://github.com/alibaba/nacos/releases)
   
3. 启动nacos

   ```shell
   sh startup.sh -m standalone
   ```

   默认端口号:8848 初始化账号密码:nacos nacos

4. 关闭服务

   ```shell
   sh shutdown.sh
   ```

### NACOS配置

1. startup.sh 改为单机启动

2. /conf/application.properties 全局配置文件

3. 数据源默认内存,替换为mysql![image-20210729135412195](/Users/liqiuyue/Library/Application Support/typora-user-images/image-20210729135412195.png)

   sql脚本:/conf/nacos-mysql.sql

### NACOSclient 集成

#### 服务的注册与发现

```xml
<!-- nacos服务注册与发现 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

```yaml
#应用名称(nacos会将改名称当作服务名称)
spring:
  application:
    name: order-service
  cloud:
    nacos:
      discovery:
        server-addr: nacos-ip:8848
        username: nacos
        password: nacos
        namespace: dev:namespace
```

启动项目,校验是否已完成注册

![image-20210717110926992](/Users/liqiuyue/Library/Application Support/typora-user-images/image-20210717110926992.png)

注册中心调用流程

![image-20210717114153790](/Users/liqiuyue/Library/Application Support/typora-user-images/image-20210717114153790.png)

#### Nacos Stater配置项信息

[官网链接](https://github.com/alibaba/spring-cloud-alibaba/wiki/Nacos-discovery)

| 配置项                | Key                                              | 默认值                       | 说明                                                         |
| --------------------- | ------------------------------------------------ | ---------------------------- | ------------------------------------------------------------ |
| 服务端地址          | spring.cloud.nacos.discovery.server-addr       | 无                         | Nacos Server 启动监听的ip地址和端口                        |
| 服务名              | spring.cloud.nacos.discovery.service           | ${spring.application.name} | 给当前的服务命名                                           |
| 服务分组            | spring.cloud.nacos.discovery.group             | DEFAULT_GROUP              | 设置服务所处的分组                                         |
| 权重                | spring.cloud.nacos.discovery.weight            | 1                          | 取值范围 1 到 100，数值越大，权重越大                      |
| 网卡名              | spring.cloud.nacos.discovery.network-interface | 无                         | 当IP未配置时，注册的IP为此网卡所对应的IP地址，如果此项也未配置，则默认取第一块网卡的地址 |
| 注册的IP地址        | spring.cloud.nacos.discovery.ip                | 无                         | 优先级最高                                                 |
| 注册的端口          | spring.cloud.nacos.discovery.port              | -1                         | 默认情况下不用配置，会自动探测                             |
| 命名空间            | spring.cloud.nacos.discovery.namespace         | 无                         | 常用场景之一是不同环境的注册的区分隔离，例如开发测试环境和生产环境的资源（如配置、服务）隔离等。 |
| AccessKey           | spring.cloud.nacos.discovery.access-key        | 无                         | 当要上阿里云时，阿里云上面的一个云账号名                   |
| SecretKey           | spring.cloud.nacos.discovery.secret-key        | 无                         | 当要上阿里云时，阿里云上面的一个云账号密码                 |
| Metadata            | spring.cloud.nacos.discovery.metadata          | 无                         | 使用Map格式配置，用户可以根据自己的需要自定义一些和服务相关的元数据信息 |
| 日志文件名          | spring.cloud.nacos.discovery.log-name          | 无                         |                                                              |
| 集群                | spring.cloud.nacos.discovery.cluster-name      | DEFAULT                    | 配置成Nacos集群名称                                        |
| 接入点              | spring.cloud.nacos.discovery.enpoint           | UTF-8                      | 地域的某个服务的入口域名，通过此域名可以动态地拿到服务端地址 |
| 是否集成Ribbon      | ribbon.nacos.enabled                           | true                       | 一般都设置成true即可                                       |
| 是否开启Nacos Watch | spring.cloud.nacos.discovery.watch.enabled     | true                       | 可以设置成false来关闭 watch                                |

#### 雪崩保护

