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

### NACOS集群搭建(ecs配置太低 选择性放弃启用(无奈放弃 配置太低后续windows电脑加内存条买虚拟机在搞))

1. 下载[nacos](https://github.com/alibaba/nacos/releases/download/2.0.3/nacos-server-2.0.3.tar.gz)
2. 单机搭建伪集群，手动修改每个文件的名字和端口号![image-20210731175710070](/Users/liqiuyue/Library/Application Support/typora-user-images/image-20210731175710070.png)

3. 配置mysql数据源 详情操作可见上

4. 将/conf/cluster.conf.example复制为/conf/cluster.conf添加节点配置

   ```conf
   # ip list
   127.0.0.1:8849
   127.0.0.1:8850
   127.0.0.1:8851
   ```

5. 如果内存不足修改启动脚本

   ```sh
   JAVA_OPT="${JAVA_OPT} -server -Xms256M -Xmx2356M -Xmn128M -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=320m"
   ```

   1. 修改端口号

### 下载nginx

```bash
# 1.添加官方源仓库
yum install yum-utils
yum-config-manager --add-repo https://openresty.org/package/centos/openresty.repo

# 2.安装openresty
yum install openresty

cd /usr/local/openresty
```

### 负载均衡算法

> 随机，通过随机选择服务进行执行，一般很少使用
>
> 轮训,负载均衡默认实现方式，请求来之后排队处理
>
> 加权轮训，通过对服务器性能的分型，给高配置，低负载的服务器分配更高的权重，均衡各个服务器的压力
>
> 地址Hash，通过客户端请求的地址HASH值取模映射进行服务器调度。ip-->hash
>
> 最小链接数，即使请求均衡了，压力不一定会均衡，最小链接数法就是根据服务器的情况，比如请求积压数等参数，将请求分配到当前压力最小的服务器上。最小活跃数

### java项目实现接口调用

**1) HttpClient**

HttpClient是Apache Jakarta Common下的子项目，用来提供高效的、最新的、功能丰富的支持http协议的客户端编程工具包，并且它支持HTTP协议最新版本和建议。HttpClient相比传统JDK自带的URLConnection，提升了易用性和灵活性，使客户端发送HTTP请求变得容易，提高了开发的效率。

**2)Okhttp**

一个处理网络请求的开源项目，是安卓最火的轻量级框架，由Square公司贡献，用于替代HttpUrlConnection和Apache HttpClient。OkHttp拥有简洁的APi、高效的性能，并支持多种协议(Http/2和SPDY)。

**3)HttpUrlConnection**

HttpUrlConnection是Java的标准累，它继承自URLConnection，可用于向指定网站发送GET请求，post请求。HttpUrlConnection使用比较复杂，不像HttpClient那样容易使用。

**4)RestTemplate WebClient**

RestTemplate是Spring提供的用于访问Rest服务的客户端，RestTemplate提供了多种便捷访问远程HTTP服务的方法，能够大大提高客户端的编写效率。

**1. 什么是Feign？**

Feign是Netfilix开发的声明式、模版化的HTTP客户端，其灵感来自Retrofit、JAXRS-2.0以及WebSocket。Feign可帮助我们更加便捷、优雅地调用HTTP API。

Spring Cloud Openfeign对Feign进行了增强，使其支持Spring MVC注解，另外还整合了Ribbon和Nacos，从而使得Feign的调用更加方便

Feign可以做到使用TTP请求远程服务时就像调用本地方法一样的体验，开发者完全感知不到这是远程方法，更感知不到这是个HTTP请求。它像Dubbo一样，consumer直接调用接口方法调用provider，而不需要通过常规的HttpClient构造请求再解析返回数据。它解决了让开发者调用远程接口就跟调用本地方法一样，无需关注与远程的交互细节，更无需关注分布式环境开发。

**2. SpringCloudAlibaba快速整合Feign**

1）引入依赖

```xml
<!-- openfeign 远程调用 -->
<dependency>
	<groupId>org.springframework.cloud</groupId>
  <aftifactId>spring-cloud-starter-openfeign</aftifactId>
</dependency>
```

2）编写调用接口+@FeignClient注解

```java
@FeignClient(value = "mall-order",path="/order")
public interface OrderFeignService{
  
  @RequestMapping("/findOrderByUserId/{userId}")
  public R findOrderByUserId(@PathVariable("userId") Integer userId);
  
}
```

3）调用端在启动类上添加@EnableFeignClients注解

```java
@SpringBootApplication
@EnableFeignClients
public class MallUserFeignDemoApplication{
  public static void main(String[] args){
    SpringApplication.run(MallUserFeignDemoApplication.class,args);
  }
}
```

4）发起调用，像调用本地方式一样调用远程服务



**3. Spring Cloud Feign的自定义配置及使用**

**3.1日志配置**

- NONE
- BASIC: 基本请求信息(请求格式,url,响应时长)
- HEADERS : 请求头信息
- FULL : BASIC + HEADERS + 请求响应数据

全局配置

```java
// 全局配置：使用@Configuration注解，会将配置作用所有的服务提供方
// 局部配置： 不使用注解 针对某个服务
@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }
}
```

```yml
# openfeign默认日志级别debug 需在配置开启debug打印权限
logging:
  level:
  # feign 接口包路径
    com.liqiuyue.order.feign: debug
```

局部配置

> 配置类
>
> 配置文件

```java
// feign接口注解 添加configuration属性 去掉配置类的@Configuration注解
@FeignClient(name = "stock-service",path = "/stock" ,configuration = FeignConfig.class)
```

```yml
feign:
  client:
    config:
    # 仅针对对应服务名的调用日志
      stock-service:
        loggerLevel: BASIC
```

**3.2契约配置**

​	Spring Cloud在Feign的基础上做了扩展，使用Spring MVC的注解来完成Feign的功能。原生的Feign是不支持Spring MVC注解的，如果你想在Spring Cloud中使用原生的注解方式来定义客户端也是可以的，通过配置契约来改变这个配置，Spring Cloud中默认的是SpringMvcContract

​		Spring Cloud 1 早期版本就是用的原生Feign.随着netflix的停更替换成了Open feign

1）修改契约配置，支持Feign原生的注解

```java
@Bean
public Contract feignContract(){
    return new Contract.Default();
}
```

```yml
# 配置文件方式
feign:
  client:
    config:
    # 仅针对对应服务名的调用日志
      stock-service:
        loggerLevel: BASIC
        contract: feign.Contract.Default
```

```java
// feign原生注解
@RequestLine("GET /reduce")
```

**3.3自定义拦截器实现认证**

```yml
feign:
  client:
    config:
      stock-service:
        loggerLevel: FULL
#        contract: feign.Contract.Default
        connectTimeout: 5000
        readTimeout: 3000
        requestInterceptors[0]: com.liqiuyue.order.interceptor.feign.CustomerFeignInterceptor
```



```java
@Bean
public CustomerFeignInterceptor feignInterceptor(){
  return new CustomerFeignInterceptor();
}
```

```java
public class CustomerFeignInterceptor implements RequestInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void apply(RequestTemplate requestTemplate) {
      requestTemplate.query("id", "1");
      requestTemplate.uri("/10");
      logger.info("feign拦截器!");
    }

}
```



**3.4超时时间设置**

```yml
# 配置文件方式
feign:
  client:
    config:
    # 仅针对对应服务名的调用日志
      stock-service:
        loggerLevel: BASIC
        contract: feign.Contract.Default
				# 连接超时时间 单位ms
        connectTimeout: 5000
        # 读取超时时间
        readTimeout: 3000
```


